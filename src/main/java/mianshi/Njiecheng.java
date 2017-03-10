/**
 * 
 */
package mianshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * 下午11:25:57
 * 
 * @author yuzhao.yang 实现N的阶乘，并且使用递归进行
 */
public class Njiecheng {
	public static void main(String[] args) throws Exception {
		// 阶乘计算
		// System.out.println(jiecheng(5));
		// getDifferNumber();
		// getSixNumber();
		// shuixianhua();
		// tiaojianyunsuan();
		// getSum();
		// wanshu();
		bubbleSort();
	}

	/**
	 * 
	 * @desc 阶乘计算
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月6日
	 */
	public static int jiecheng(int n) {

		if (n == 1) {
			return 1;
		} else {
			return jiecheng(n - 1) * n;
		}
	}

	/**
	 * 
	 * @desc 1,2,3,4 四个不同的数字，输出一个三位数，不重复，且彼此之间不相同
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public static void getDifferNumber() {

		int m = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4 && j != i; j++) {
				for (int k = 1; k <= 4 && k != i && k != j; k++) {
					m++;
					System.out.println(i + "" + j + "" + k);
				}
			}
		}
		System.out.println(m + "个整数!");
	}

	public static void getSixNumber() {
		int m = 0;
		for (long i = 100001; i < 999999; i++) {
			String result = "" + (i * i);

			boolean flag = true;
			for (char ele : (i + "").toCharArray()) {
				// 如果结果中包含了该字符;当前的数字无需计算了。
				// 内层循环结束
				if (result.contains(ele + "")) {
					flag = false;
					break;
				}
			}
			if (flag) {
				// 当前字符还不能重复
				Set<Character> set = new HashSet<Character>();
				for (Character ele2 : (i + "").toCharArray()) {
					set.add(ele2);
				}
				if (set.size() == 6) {
					m++;
					System.out.println(i);
					System.out.println(i * i);
				}
			}
		}
		System.out.println(m + "个数");
	}

	public static void shuixianhua() {
		for (int i = 100; i <= 999; i++) {
			int ge = i % 10;
			int bai = i / 100;
			int shi = (i - ge - bai * 100) / 10;
			if (i == (ge * ge * ge + shi * shi * shi + bai * bai * bai)) {
				System.out.println(i);
			}
		}
	}

	/**
	 * 
	 * @desc 2/1+3/2+5/3
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public static int jisuan(int n) {
		if (n == 1) {
			return 2 / 1;
		} else {
			return 0;
		}
	}

	/**
	 * @desc 判断是否是回文数
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public void huiwen() {
		Scanner scanner = new Scanner(System.in);
		String text1 = scanner.nextLine();
	}

	public static void tiaojianyunsuan() {
		String str = "";
		str = JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");
		int N;
		N = 0;
		try {
			N = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		str = (N > 90 ? "A" : (N > 60 ? "B" : "C"));
		System.out.println(str);

	}

	/**
	 * 
	 * @desc 求取最大公约数
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public static int MaxGongyueshu(int m, int n) {
		while (true) {
			// 求取余数
			if ((m = m % n) == 0)
				return n;
			if ((n = n % m) == 0)
				return m;
		}
	}

	/**
	 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字
	 * 
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public static void getSum() throws IOException {
		int s = 0;
		String output = "";
		BufferedReader stadin = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("请输入a的值");
		String input = stadin.readLine();
		for (int i = 1; i <= Integer.parseInt(input); i++) {
			output += input;
			int a = Integer.parseInt(output);
			s += a;
		}
		System.out.println(s);
	}

	/**
	 * 
	 * @desc 1000之内的所有完数
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public static void wanshu() {

		for (int i = 1; i < 1000; i++) {
			int s = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					s += j;
				}
			}
			if (s == i) {
				System.out.println(s);
			}
		}
	}

	// 冒泡排序
	// 每次排序的时候，都将最大的冒到最前面
	public static void bubbleSort() {
		int[] sort = new int[10];
		for (int k = 0; k < 10; k++) {
			sort[k] = new Random().nextInt(20);
		}

		// 外层循环
		// 方式1
		// 外层循环的N次
		for (int i = 1; i < sort.length; i++) {
			// 后面的所有元素，依次对调
			// 依次往后轮换，最大的会轮换到末尾去
			// 每次循环，空间都会压缩依次，变小，排序的数目逐次递减
			// 变成泡泡，一直向后冒
			for (int j = 0; j < sort.length - i; j++) {
				if (sort[j] > sort[j + 1]) {
					int temp = sort[j + 1];
					sort[j + 1] = sort[j];
					sort[j] = temp;
				}
			}
		}
		for (int k = 0; k < 10; k++) {
			System.out.println(sort[k]);
		}
	}

	// 稍后还可以继续参悟

	/**
	 * 
	 * @desc 选择排序
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public void selectSort() {
		Random ran = new Random();
		int[] sort = new int[10];
		for (int i = 0; i < 10; i++) {
			sort[i] = ran.nextInt(50);
		}
		System.out.print("排序前的数组为");
		for (int i : sort) {
			System.out.print(i + " ");
		}

		// 选择排序的核心
		// 选择排序：从后面待排序的数组中，找出最小的，或者是最大的，赋给当前的值
		for (int i = 0; i < sort.length - 1; i++) {
			for (int j = i + 1; j < sort.length; j++) {
				// 注意，一定是赋给当前值
				if (sort[j] < sort[i]) {
					int temp = sort[j];
					sort[j] = sort[i];
					sort[i] = temp;
				}
			}
		}

		System.out.println();
		System.out.print("排序后的数组为");
		for (int i : sort) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param sort
	 *            要排序的数组
	 * @param start
	 *            排序的开始座标
	 * @param end
	 *            排序的结束座标
	 */
	public static void quickSort(int[] sort, int start, int end) {
		// 设置关键数据key为要排序数组的第一个元素，
		// 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
		int key = sort[start];
		// 设置数组左边的索引，往右移动判断比key大的数
		int i = start;
		// 设置数组右边的索引，往左移动判断比key小的数
		int j = end;
		// 如果左边索引比右边索引小，则还有数据没有排序
		while (i < j) {
			while (sort[j] > key && j > start) {
				j--;
			}
			while (sort[i] < key && i < end) {
				i++;
			}
			if (i < j) {
				int temp = sort[i];
				sort[i] = sort[j];
				sort[j] = temp;
			}
		}
		// 如果左边索引比右边索引要大，说明第一次排序完成，将sort[j]与key对换，
		// 即保持了key左边的数比key小，key右边的数比key大
		if (i > j) {
			int temp = sort[j];
			sort[j] = sort[start];
			sort[start] = temp;
		}
		// 递归调用
		if (j > start && j < end) {
			quickSort(sort, start, j - 1);
			quickSort(sort, j + 1, end);
		}
	}

	/**
	 * 
	 * @desc 挖坑填数的方法
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	public static void quickSorting(int[] a, int start, int end) {

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

	/**
	 * 
	 * @desc 直接插入排序
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	private static void directInsertSort(int[] sort) {
		for (int i = 1; i < sort.length; i++) {
			int index = i - 1;
			int temp = sort[i];
			// index用于记录当前比较到的数组下标
			// 如果当前的值比其大，则继续排序，而当前值递增一下
			while (index >= 0 && sort[index] > temp) {
				sort[index + 1] = sort[index];
				index--;
			}
			sort[index + 1] = temp;
		}
	}

	/**
	 * 
	 * @desc 二分搜索法
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月7日
	 */
	private static int binarySearch(int[] sort, int data) {
		if (data < sort[0] || data > sort[sort.length - 1]) {
			return -1;
		}
		int begin = 0;
		int end = sort.length;
		int mid = (begin + end) / 2;

		// 递归进行
		while (begin <= end) {
			mid = (begin + end) / 2;
			if (data > sort[mid]) {
				begin = mid + 1;
			} else if (data < sort[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = nums[i];
					result[1] = nums[j];
				}
			}
		}

		return result;
	}
}
