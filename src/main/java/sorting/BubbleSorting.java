/**
 * 
 */
package sorting;

import utils.RandomArray;

/**
 * 下午4:34:21
 * 
 * @author yuzhao.yang
 * 
 *         数组的冒泡排序
 *
 */
public class BubbleSorting {
	public static void main(String[] args) {
		// toAfterBubbleSort(10);
		toBeforeBubbleSort(10);
	}

	/**
	 * 
	 * @desc 向后冒泡的冒泡排序
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月12日
	 */
	public static void toAfterBubbleSort(int n) {
		Integer[] array = RandomArray.randArr(n);
		// 外循环
		for (int i = array.length; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				// 最大的元素向后走
				if (array[j - 1] > array[j]) {
					Integer temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
			outArr(array);
		}
	}

	public static void toBeforeBubbleSort(int n) {
		Integer[] array = RandomArray.randArr(n);
		// 把后面最小的往前冒
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
			outArr(array);
		}
	}

	public static void outArr(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
