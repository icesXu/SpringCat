/**
 * 
 */
package singlemodel;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 上午10:59:04
 */
public class FourthSingle {

	private static FourthSingle single;
	static {
		single = new FourthSingle();
	}

	private FourthSingle() {

	}

	private FourthSingle getInstance() {
		return single;
	}
}
