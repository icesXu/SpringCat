/**
 * 
 */
package mianshi;

import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import utils.InputUtils;

/**
 * 下午12:56:14
 * 
 * @author yuzhao.yang
 *
 *
 *         给定两个字符串A，B（只包含26个英文字母），输出所有公共的最长子字符串（如果出现重复子串,则输出多次）
 */
public class CommonMaxString extends BaseSpider {

	@Override
	public void baseCount() {
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

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月14日
	 */
	@Override
	public void betterCount() {
		// TODO Auto-generated method stub
		// 输出所有公共的字符串，暴力求解肯定不是最好的解决办法

		String line1 = InputUtils.getInput("输入字符串:A");
		String line2 = InputUtils.getInput("输入字符串:B");
		// 将所有公共字符串都输出
		// 字符串1设置游标
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < line1.length(); i++) {
			// 字符串2设置游标
			for (int j = 0; j < line2.length(); j++) {
				// 如果当前字符对应
				int first = i;
				int second = j;
				while (first < line1.length() && second < line2.length()
						&& line1.charAt(first) == line2.charAt(second)) {
					// 如果出现字符对应
					first++;
					second++;
				}
				if (StringUtils.isNotBlank(line2.substring(j, second))) {
					list.add(line2.substring(j, second));
				}
			}
		}
		for (String ss : list) {
			System.out.print(ss + " ");
		}
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月14日
	 */
	@Override
	public void bestCount() {
		// TODO Auto-generated method stub
		// 重点在于求取公共子串

	}
}
