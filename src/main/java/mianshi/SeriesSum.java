/**
 * 
 */
package mianshi;

import utils.InputUtils;

/**
 * 下午11:26:02
 * 
 * @author yuzhao.yang
 *
 *
 *         给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。 例如 N
 *         = 18 L = 2： 5 + 6 + 7 = 18 3 + 4 + 5 + 6 = 18 都是满足要求的，但是我们输出更短的 5 6 7
 */
public class SeriesSum {
	public static void main(String[] args) {
		count();
	}

	public static void count() {
		Integer n = InputUtils.getInt("请输入正整数：N");
		Integer l = InputUtils.getInt("请输入正整数：l");

		// 找出最短的，当然是从l出发了，如果未曾出现这样的数列，则结束
		// 牵涉到数学公式；
		// 最初始值满足：sum / l - (l - 1) /2;

		for (int i = l; i <= Math.min(100, n); i++) {

			if (n % i != 0) {
				continue;
			}
			if ((i - 1) % 2 != 0) {
				continue;
			}

			if (i == Math.min(100, n)) {
				System.out.println("No");
			}
			int x = n / i - (i - 1) / 2;
			if (x > 0) {
				System.out.println(i);
				System.out.println(x);
				for (int j = 0; j < i; j++) {
					System.out.print(x + j + " ");
				}
				System.out.println();
				break;
			}
		}
	}
}
