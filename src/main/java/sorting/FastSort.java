package sorting;

/**
 * 快速排序 下午1:15:43
 * 
 * @author yuzhao.yang
 *
 */
public class FastSort {

	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] a = { 12, 20, 5, 16, 15, 1, 30, 45, 23, 9 };
		int start = 0;
		int end = a.length - 1;
		quickSort(a, start, end);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	public static void sort(int[] a, int low, int high) {
		// 定义最小值
		int start = low;
		// 定义最大值
		int end = high;
		// 最低处的值
		int key = a[low];

		while (end > start) {
			// 从后往前比较
			while (end > start && a[end] >= key)
				// 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			if (a[end] <= key) {
				int temp = a[end];
				a[end] = a[start];
				a[start] = temp;
			}
			// 从前往后比较
			while (end > start && a[start] <= key)
				// 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			if (a[start] >= key) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 递归
		if (start > low)
			sort(a, low, start - 1);// 左边序列。第一个索引位置到关键值索引-1
		if (end < high)
			sort(a, end + 1, high);// 右边序列。从关键值索引+1到最后一个
	}

	public static void quickSort(int[] a, int start, int end) {

		int low = start;
		int high = end;
		int key = a[start];

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

			a[low] = key;

			if (start < low) {
				quickSort(a, start, low - 1);
			}
			if (low < end) {
				quickSort(a, low + 1, end);
			}
		}
	}
}