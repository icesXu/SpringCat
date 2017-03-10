/**
 * 
 */
package mianshi;

import java.util.Scanner;

/**
 * 下午11:55:05
 * 
 * @author yuzhao.yang
 *
 */
public class MaxDuichenString {
	public static void main(String[] args) {
		getMaxString();
	}

	public static void getMaxString() {
		while (true) {
			System.out.println("请输入字符串:");
			Scanner sc = new Scanner(System.in);
			String line = sc.next();

			int max = 0;
			for (int i = 0; i < line.length() - 1; i++) {
				int result1 = 0;
				// 如果与后面的相等
				int k1 = 1;
				while ((i - k1 + 1) >= 0 && (i + k1) < line.length()
						&& line.charAt(i - k1 + 1) == line.charAt(i + k1)) {
					k1++;
					result1 += 2;
				}
				// 或者自身朝两边延伸
				int result2 = 1;
				int k2 = 1;
				while ((i - k2) >= 0 && (i + k2) < line.length()
						&& line.charAt(i + k2) == line.charAt(i - k2)) {
					k2++;
					result2 += 2;
				}
				max = Math.max(result2, Math.max(result1, max));
			}
			System.out.println("最长字符串的大小:" + max);
		}
	}
}
