/**
 * 
 */
package utils;

import java.util.Scanner;

/**
 * 下午3:43:37
 * 
 * @author yuzhao.yang
 *
 */
public class InputUtils {
	public static void main(String[] args) {

	}

	public static String getInput(String tishi) {
		System.out.println(tishi);
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		return line;
	}

	public static Integer getInt(String tishi) {
		String line = getInput(tishi);
		return Integer.parseInt(line);
	}

	public static Long getLong(String tishi) {
		String line = getInput(tishi);
		return Long.parseLong(line);
	}
}
