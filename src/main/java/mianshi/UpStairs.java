/**
 * 
 */
package mianshi;

/**
 * 上午1:23:01
 * 
 * @author yuzhao.yang
 *
 */
public class UpStairs {

	public static void main(String[] args) {
		System.out.println(calculator(15));
	}

	/**
	 * 
	 * @desc 实质就是计算，从1，2，3选任意数目，其值等于15
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月12日
	 */
	public void getUp(int n) {
		while (n != 0) {
			if (n - 1 == 0) {
				getUp(n - 1);
				return;
			}
			if (n - 2 == 0) {
				getUp(n - 2);
				return;
			}
			if (n - 3 == 0) {
				getUp(n - 3);
				return;
			}
		}
	}

	public static int calculator(int n) {

		switch (n) {

		case 1:

			return 1;

		case 2:

			return 2;

		case 3:

			return 4;

		}
		return calculator(n - 1) + calculator(n - 2) + calculator(n - 3);

	}
}
