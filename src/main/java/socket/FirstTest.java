/**
 * 
 */
package socket;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 下午2:12:31
 */
public class FirstTest {

	public static void main(String[] args) {
		process();
	}

	public static void process() {
		Socket socket = null;
		try {
			socket = new Socket("www.baidu.com", 80);
			InputStream inputStream = socket.getInputStream();
			byte[] readStream = readStream(inputStream);
			String result = new String(readStream);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
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
	 * @description way to read form InputStream to Byte[]
	 * @author yuzhao.yang
	 * @param inStream
	 *            the stream to read from
	 * @return
	 * @time 2017年8月23日 下午2:42:48
	 */
	public static byte[] readStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		return outSteam.toByteArray();
	}
}
