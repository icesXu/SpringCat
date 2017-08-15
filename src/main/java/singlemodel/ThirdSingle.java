/**
 * 
 */
package singlemodel;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 上午10:57:05
 */
public class ThirdSingle {
	private static ThirdSingle single = new ThirdSingle();

	private ThirdSingle() {

	}

	public static ThirdSingle getInstance() {
		return single;
	}

	public static void main(String[] args) {
		ThirdSingle s1 = ThirdSingle.getInstance();
		ThirdSingle s2 = ThirdSingle.getInstance();
		System.out.println(s1 == s2);

	}

}
