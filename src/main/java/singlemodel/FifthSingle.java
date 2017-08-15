/**
 * 
 */
package singlemodel;

/**
 * @author yuzhao.yang
 * @description:静态内部类
 * @time:2017年8月15日 上午11:04:44
 */
public class FifthSingle {
	private static class SingletonHolder {
		private static final FifthSingle INSTANCE = new FifthSingle();
	}

	private FifthSingle() {

	}

	public static final FifthSingle getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
