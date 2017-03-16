package sorting;

/**
 * 快速排序 下午1:15:43
 * 
 * @author yuzhao.yang
 * 
 *         http://blog.csdn.net/morewindows/article/details/6684558
 *
 */
public class FastSort {

	public static void main(String[] args) {
		int[] a = { 12, 20, 5, 16, 15, 1, 30, 45, 23, 9 };
		int start = 0;
		int end = a.length - 1;
		myQuickSort(a, start, end);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	public static void quickSort(int[] a, int start, int end) {

		int low = start;
		int high = end;
		int key = a[low];

		while (low < high) {
			// 从右到左遍历
			while (a[high] >= key && high > low) {
				high--;
			}
			// 将较大的值赋值给小的，并且前往向后挪一位
			if (high > low) {
				a[low++] = a[high];

			}
			// 从左往右
			while (a[low] <= key && high > low) {
				low++;
			}
			//
			if (high > low) {
				a[high--] = a[low];
			}
			// 左右交换一次之后，
			a[low] = key;
		}

		if (start < low) {
			quickSort(a, start, low - 1);
		}
		if (low < end) {
			quickSort(a, low + 1, end);
		}
	}

	public static void myQuickSort(int[] array, int start, int end) {
		// 部署最低点
		int low = start;
		// 部署最高点
		int high = end;
		// 拿到最低点的值
		int key = array[low];
		// 满足条件的时候，从右向左先找比当前元素小的
		while (low < high) {
			// 快速排序
			// 先从右向左排序
			while (array[high] >= key && high > low) {
				high--;
			}
			if (high > low) {
				array[low++] = array[high];
			}
			while (array[low] <= key && high > low) {
				low++;
			}
			if (low < high) {
				array[high--] = array[low];
			}
		}
		array[low] = key;

		if (start < low) {
			myQuickSort(array, start, low - 1);
		}
		if (low < end) {
			myQuickSort(array, low + 1, end);
		}
	}
}