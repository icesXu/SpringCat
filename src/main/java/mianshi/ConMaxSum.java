/**
 * 
 */
package mianshi;

import java.util.Random;

import utils.RandomArray;

/**
 * 下午9:21:51
 * 
 * @author yuzhao.yang
 * 
 *         http://blog.csdn.net/superchanon/article/details/8228212
 *
 */
public class ConMaxSum {
	public static void main(String[] args) {
		conMaxSum();
		// random();
	}

	public static void conMaxSum() {
		Integer[] array = RandomArray.InitArr(10);
		for (int i = 0; i < array.length; i++) {
			array[i] = fushu() * array[i];
		}
		RandomArray.outArr(array);

		// 对其进行遍历
		int max = Integer.MIN_VALUE;
		// for (int i = 0; i < array.length; i++) {
		// int curSum = array[i];
		// int index = 1;
		// while ((i + index) < array.length
		// && curSum + array[i + index] > curSum) {
		// curSum = curSum + array[i + index];
		// index++;
		// }
		// max = Math.max(max, curSum);
		// }
		max = maxSubSumRec(array, 0, array.length - 1);
		System.out.println("最大值:" + max);

	}

	public static int maxSubSumRec(Integer[] array, int left, int right) {
		// 递归的基准情况:待处理序列只有一个元素
		if (left == right) {
			// 空集也算是子序列，空集和为0，所以最大子序列和最小为0
			if (array[left] > 0)
				return array[left];
			else
				return 0;
		}

		// 递归求出左半部分和右半部分的最大子序列和
		int center = (left + right) / 2;

		// 递归方式求取左侧最大值
		int maxLeftSum = maxSubSumRec(array, left, center);
		// 递归方式，求取右侧最大值
		int maxRightSum = maxSubSumRec(array, center + 1, right);

		// 求出左半部分中包含最右边元素的子序列的最大和
		int maxLeftBorderSum = 0, leftBorderSum = 0;
		
		for (int i = center; i >= left; i--) {
			leftBorderSum += array[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}

		// 求出右半部分中包含最左边元素的子序列的最大和
		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += array[i];
			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}
		// 跨越两个部分的最大子序列和
		int maxLeftRightSum = maxLeftBorderSum + maxRightBorderSum;
		// maxLeftSum、maxRightSum、maxLeftRightSum中的最大值即为最大子序列和
		int maxSubSum = 0;
		maxSubSum = maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
		maxSubSum = maxSubSum > maxLeftRightSum ? maxSubSum : maxLeftRightSum;
		return maxSubSum;
	}

	public static int fushu() {
		int all = new Random().nextInt(10);
		int result = -1;
		for (int i = 0; i <= all; i++) {
			result = -1 * result;
		}
		return result;
	}
}
