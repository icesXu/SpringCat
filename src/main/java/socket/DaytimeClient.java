/**
 * 
 */
package socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 下午2:46:51
 */
public class DaytimeClient {

	public static void main(String[] args) {
		String hostname = args.length > 0 ? args[0] : "time.nist.gov";
		Socket socket = null;
		try {
			socket = new Socket(hostname, 13);
			socket.setSoTimeout(15000);
			InputStream stream = socket.getInputStream();
			StringBuilder sb = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(stream, "ASCII");
			for (int c = reader.read(); c != -1; c = reader.read()) {
				sb.append((char) c);
			}
			System.out.println(parseDate(sb.toString()));
		} catch (Exception e) {
			System.err.println(e);
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

	public static Date parseDate(String text) throws ParseException {
		String[] pieces = text.split(" ");
		String dateTime = pieces[1] + " " + pieces[2] + " UTC";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss z");
		return format.parse(dateTime);
	}
}
