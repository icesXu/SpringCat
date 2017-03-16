/**
 * 
 */
package sorting;

import utils.InputUtils;
import utils.RandomArray;

/**
 * 下午5:28:24
 * 
 * @author yuzhao.yang
 *
 */
public class DirectInsertSorting {
	public static void main(String[] args) {
		insertSort();
	}

	public static void insertSort() {
		Integer[] array = RandomArray.InitArr(10);
		for (int i = 1; i < array.length; i++) {
			// 每一个元素都会向后移动
			// 当前需要进行排序的元素
			// 当前有i个元素，构成了i的空间
			int target = array[i];
			int index = 0;

			while (target < array[i - index - 1]) {
				// 前面的元素都会向后挪动一位
				array[i - index] = array[i - index - 1];
				index++;
			}
			array[i - index] = target;
		}
	}
}
