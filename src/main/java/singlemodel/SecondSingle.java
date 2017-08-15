/**
 * 
 */
package singlemodel;

/**
 * @author yuzhao.yang
 * @description:懒汉，线程安全
 * @time:2017年8月15日 上午10:55:05
 */
public class SecondSingle {
	private static SecondSingle single;

	private SecondSingle() {

	}

	public static synchronized SecondSingle getInstance() {
		if (null == single) {
			single = new SecondSingle();
		}
		return single;
	}

}
