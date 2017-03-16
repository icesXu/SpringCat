/**
 * 
 */
package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.RandomArray;

/**
 * 下午6:52:41
 * 
 * @author yuzhao.yang
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		binarySearch(10);
	}

	public static int binarySearch(Integer key) {

		// 构建出一个数组
		Integer[] array = RandomArray.InitArr(20);
		// 对数组进行排序
		for (int i = array.length; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				// 最大的元素向后走
				if (array[j - 1] > array[j]) {
					Integer temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(erfenSearch(array, 10));
		return 0;
	}

	/**
	 * 
	 * @desc 非递归的实现版本
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月12日
	 */
	public static int erfenSearch(Integer[] array, Integer a) {
		// 非递归版本
		int lo = 0;
		int hi = array.length - 1;
		int mid;
		// 保证的基础条件是：最小值小于最大值
		while (lo <= hi) {
			// 取中间值
			mid = (lo + hi) / 2;
			if (array[mid] == a) {
				return mid + 1;
			} else if (array[mid] < a) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @desc 递归实现版本
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月12日
	 */
	public static int sort(int[] array, int a, int lo, int hi) {
		if (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a == array[mid]) {
				return mid + 1;
			} else if (a > array[mid]) {
				return sort(array, a, mid + 1, hi);
			} else {
				return sort(array, a, lo, mid - 1);
			}
		}
		return -1;
	}

}
