/**
 * 
 */
package singlemodel;

import mianshi.Singleton;

/**
 * @author yuzhao.yang
 * @description:双重校验锁
 * @time:2017年8月15日 上午11:06:57
 */
public class SixSingle {
	private volatile static SixSingle single;

	private SixSingle() {

	}

	public static SixSingle getInstance() {
		if (null == single) {
			synchronized (SixSingle.class) {
				if (null == single) {
					single = new SixSingle();
				}
			}
		}
		return single;
	}
}
