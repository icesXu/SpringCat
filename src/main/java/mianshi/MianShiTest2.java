/**
 * 
 */
package mianshi;

import java.util.Scanner;

/**
 * 下午9:57:09
 * 
 * @author yuzhao.yang
 *
 */
public class MianShiTest2 {
	public static void main(String[] args) {
		// stringCode();
		juzhen();
		// MultiplyLineInput();
	}

	public static void stringCode() {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			StringBuffer sb = new StringBuffer();
			// 对line进行编码计算
			int max = 1;
			for (int i = 1; i < line.length(); i++) {
				// 如果当前元素与之前的相等，则加1
				if (line.charAt(i) == line.charAt(i - 1)) {
					max++;
				} else {
					String newLine = line.charAt(i - 1) + "" + max;
					sb.append(newLine);
					max = 1;
				}
				if (i == line.length() - 1) {
					sb.append(line.charAt(line.length() - 1) + "" + max);
				}
			}
			System.out.println(sb.toString());
		}
	}

	public static void juzhen() {
		// 用于记录当前已经输入了几行
		int size = 1;
		// 用于保存行数:n
		int n = 0;
		int d = 0;
		// 用于保存个数：d
		System.out.println("请输入数组的大小:N");
		Scanner scanner1 = new Scanner(System.in);

		String line1 = scanner1.next();
		n = Integer.parseInt(line1);

		Scanner scanner2 = new Scanner(System.in);
		System.out.println("请输入计算的数字数目:D");
		String line2 = scanner2.nextLine();
		d = Integer.parseInt(line2);

		int[][] array = new int[n][n];
		System.out.println("接下来请输入" + n + "行数:");
		for (int i = 0; i < n; i++) {
			System.out.println("请输入第" + (i + 1) + "行数");
			Scanner sc3 = new Scanner(System.in);
			sc3.useDelimiter("\n");
			String curLine = sc3.next();
			String[] curArray = curLine.split(" ");
			for (int j = 0; j < curArray.length; j++) {
				array[i][j] = Integer.parseInt(curArray[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < n; j++) {
				sb.append(array[i][j] + " ");
			}
			System.out.println(sb.toString());
		}
		int result = 0;
		for (int i = 0; i <= n - d; i++) {
			for (int j = 0; j <= n - d; j++) {
				result = getMaxResult(result, i, j, array, d);
			}
		}

		// 其他范围内的，只能计算横着或者竖着的了
		for (int i = n - d + 1; i < n; i++) {
			for (int j = 0; j <= n - d; j++) {
				int sum2 = 0;
				for (int k = 0; k < d; k++) {
					sum2 += array[i][j + k];
				}
				result = Math.max(sum2, result);
			}
		}

		// 只计算其横着的值
		for (int j = n - d + 1; j < n; j++) {
			for (int i = 0; i <= n - d; i++) {
				int sum2 = 0;
				for (int k = 0; k < d; k++) {
					sum2 += array[i + k][j];
				}
				result = Math.max(sum2, result);
			}
		}
		System.out.println(result);
	}

	public static void MultiplyLineInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入:");

		while (sc.hasNext()) {
			System.out.println("请输入:");
			String line = sc.next();
			System.out.println(line);
		}
	}

	public static int getMaxResult(int result, int i, int j, int[][] array,
			int d) {
		int size = array.length;
		// 计算从左到右:sum1:横向i不变
		// 应该是对于任何一个数，都计算其上下左右，八个角度的所有数字才对
		int sum1 = 0;
		for (int k = 0; k < d; k++) {
			sum1 += array[i][j + k];
		}

		// 计算从上到下，sum2:竖向j不变
		int sum2 = 0;
		for (int k = 0; k < d; k++) {
			sum2 += array[i + k][j];
		}

		int sum3 = 0;
		for (int k = 0; k < d; k++) {
			sum3 += array[i + k][j + k];
		}
		return Math.max(result, Math.max(sum3, Math.max(sum1, sum2)));
	}
}
