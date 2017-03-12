/**
 * 
 */
package utils;

import java.util.Random;

/**
 * 下午4:34:53
 * 
 * @author yuzhao.yang
 *
 */
public class RandomArray {
	public static void main(String[] args) {

	}

	public static Integer[] randArr(int n) {
		Integer[] array = new Integer[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Random().nextInt(n + 40);
		}
		return array;
	}
}
