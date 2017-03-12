/**
 * 
 */
package sorting;

import utils.InputUtils;
import utils.RandomArray;

/**
 * 下午6:01:25
 * 
 * @author yuzhao.yang
 * 
 *         选择排序:
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		selectSort();
	}

	/**
	 * 
	 * @desc 从后面找出比当前元素小的元素
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月12日
	 */
	public static void selectSort() {
		// 初始化十个数字的数组
		Integer[] array = RandomArray.InitArr(10);
		RandomArray.outArr(array);
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				// 二者交换
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		RandomArray.outArr(array);
	}
}
