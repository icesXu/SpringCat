/**
 * 
 */
package mianshi;

/**
 * 下午11:13:11
 * 
 * @author yuzhao.yang
 *
 */
public class Singleton {

	private Singleton() {

	}

	private static Singleton singleton;

	// public static Singleton getInstance() {
	// 空的，新建一个
	// if (null == singleton) {
	// singleton = new Singleton();
	// }
	// return singleton;
	// }
	public static Singleton getSingleton() {
		// 首先，空的
		if (singleton == null) {
			synchronized (Singleton.class) {
				// 二重锁定
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		System.out.println(s1 == s2);
	}
}
