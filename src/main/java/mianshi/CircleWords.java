/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.List;

import utils.InputUtils;

/**
 * 上午1:22:45
 * 
 * @author yuzhao.yang
 *
 */
public class CircleWords {
	public static void main(String[] args) {
		// String text = "longwang";
		// System.out.println(change(text, 2));
		count();
	}

	public static void count() {
		String line = InputUtils.getInput("请输入单词数目:");
		int n = Integer.parseInt(line);

		// 利用set自带的元素不重复的功能，过滤掉元素
		// 还是不要过滤了
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String line2 = InputUtils.getInput("请输入第" + (i + 1) + "个单词:");
			list.add(line2);
		}

		// 判断其中有多少个循环单词
		// 循环单词就是循环一下可以相等的单词
		// 首先，是暴力破解法：
		// 每个单词只能向后进行遍历，如果遇见相同的，就把这几个单词全部记录下来，不再参与计算
		//
		List<String> counted = new ArrayList<String>();
		int number = 0;

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).length(); j++) {
				// 当前正在遍历的字符串
				String text = list.get(i);
				// 当前元素不会再度遍历了
				counted.add(text);
				// 应该遇到第一个number会增加
				int index = 0;
				for (int k = 0; k < text.length(); k++) {
					String changeText = change(text, k);
					// 如果其不在已经录入的元素里，且包含在未曾录入的元素内
					if (!counted.contains(changeText)
							&& list.contains(changeText)) {
						// 如果出现了循环字符串，计入counted，代表已经统计过
						counted.add(changeText);
						index++;
						// 如果重复了第一个，会添加一个循环单词
						if (index == 1) {
							number++;
						}
					}
				}
			}
		}
		System.out.println("循环字符串的个数:" + number);
	}

	public static String change(String text, int n) {
		// 拆分成两部分
		String suffix = text.substring(n);
		String prefix = text.substring(0, n);

		return suffix + prefix;
	}
}
