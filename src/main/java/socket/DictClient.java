/**
 * 
 */
package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 下午2:56:07
 */
public class DictClient {
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		process(new String[] { "gold", "uranium", "silver", "copper", "lead" });
	}

	public static void process(String[] args) {
		Socket socket = null;
		try {
			// 建立一个连接端口，就可以实现数据发送了
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			OutputStream stream = socket.getOutputStream();
			// 建立写入流
			Writer writer = new OutputStreamWriter(stream, "UTF-8");
			writer = new BufferedWriter(writer);

			// 建立写入的字符串，进行写入
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream, "UTF-8"));
			for (String word : args) {
				define(word, writer, bufferedReader);
			}
			writer.write("quit\r\n");
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != socket) {
				try {
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @description
	 * @author yuzhao.yang
	 * @param
	 * @return
	 * @throws IOException
	 * @time 2017年8月23日 下午3:05:26
	 */
	public static void define(String word, Writer writer, BufferedReader reader)
			throws IOException {
		writer.write("DEFINE eng-lat " + word + "\r\n");
		writer.flush();

		for (String line = reader.readLine(); line != null; line = reader
				.readLine()) {
			if (line.startsWith("250")) {
				return;
			} else if (line.startsWith("552")) {
				System.out.println("No definition found for " + word);
				return;
			} else if (line.matches("\\d\\d\\d .*")) {
				continue;
			} else if (line.trim().equals(".")) {
				continue;
			} else {
				System.out.println(line);
			}

		}
	}

}
