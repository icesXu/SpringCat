package internet;

import java.net.InetAddress;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 下午1:54:57
 */
public class OReillyByName {
	public static void main(String[] args) {
		try {
			InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
			for (InetAddress address : addresses) {
				System.out.println(address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}