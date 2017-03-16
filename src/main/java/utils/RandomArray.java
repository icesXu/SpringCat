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

	public static Integer[] InitArr(int n) {
		Integer[] array = new Integer[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Random().nextInt(n + 40);
		}
		return array;
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月16日
	 */
	public static void outArr(Integer[] array) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
