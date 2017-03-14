/**
 * 
 */
package mianshi;

import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.List;

import utils.InputUtils;

/**
 * 下午12:56:14
 * 
 * @author yuzhao.yang
 *
 *
 *         给定两个字符串A，B（只包含26个英文字母），输出所有公共的最长子字符串（如果出现重复子串,则输出多次）
 */
public class CommonMaxString {
	public static void main(String[] args) {
		count();
	}

	public static void count() {
		String line1 = InputUtils.getInput("输入字符串:A");
		String line2 = InputUtils.getInput("输入字符串:B");

		// 先求出所有的公共字符串，然后予以清除

		// 第一种最暴力的解法
		// 求出字符串B的所有子串
		// 子字符串的起点
		List<String> subList1 = subList(line1);
		List<String> subList2 = subList(line2);
		List<String> commonList = new ArrayList<String>();
		for (String common1 : subList1) {
			for (String common2 : subList2) {
				if (common1.equals(common2)) {
					commonList.add(common2);
				}
			}
		}
		int max = 0;
		for (String coString : commonList) {
			max = Math.max(max, coString.length());
		}
		for (String commString : commonList) {
			if (commString.length() == max) {
				System.out.print(commString + " ");
			}
		}
	}

	public static List<String> subList(String line2) {
		List<String> subList = new ArrayList<String>();
		for (int i = 0; i < line2.length(); i++) {
			// 子字符串的长度
			for (int j = 1; j < line2.length(); j++) {
				if ((i + j) <= line2.length()) {
					String subString = line2.substring(i, i + j);
					subList.add(subString);
				}
			}
		}
		// 添加自身
		subList.add(line2);
		return subList;
	}
}
