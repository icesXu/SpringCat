/**
 * 
 */
package mianshi;

import utils.InputUtils;

/**
 * 下午3:42:53
 * 
 * @author yuzhao.yang
 *
 */
public class MaxSeriesNumber {

	public static void main(String[] args) {
		count();
	}

	public static void count() {
		while (true) {
			String line = InputUtils.getInput("请输入字符串:");
			char[] charArray = line.toCharArray();
			int result = 0;
			for (int i = 0; i < charArray.length; i++) {
				int max = 1;
				// 如果当前的是数字，继续遍历
				if (Character.isDigit(charArray[i])) {
					int k = 1;
					// 如果下一个也是，则max加1
					while ((i + k) < charArray.length
							&& Character.isDigit(charArray[i + k])) {
						k++;
						max++;
					}
				}
				result = Math.max(max, result);
			}
			System.out.println("最长数字字符串:" + result);
		}
	}
}
