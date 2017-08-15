/**
 * 
 */
package singlemodel;

/**
 * @author yuzhao.yang
 * @description:lazy loading,not multiThreadSafe
 * @time:2017年8月15日 上午10:53:03
 */
public class FirstSingle {
	private static FirstSingle single;

	private FirstSingle() {
	}

	public static FirstSingle getInstance() {
		if (null == single) {
			single = new FirstSingle();
		}
		return single;
	}
}
