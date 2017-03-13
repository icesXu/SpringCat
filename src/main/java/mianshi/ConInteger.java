/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.InputUtils;

/**
 * 下午10:21:17
 * 
 * @author yuzhao.yang
 *
 *
 *         牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
 *         牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如： 10 7 12 8 11
 *         那么抹除掉的整数只可能是9 5 6 7 8 那么抹除掉的整数可能是4也可能是9
 */
public class ConInteger {
	public static void main(String[] args) {
		conInteger();
	}

	public static void conInteger() {
		List<Integer> list = new ArrayList<Integer>();
		int n = 5;
		int begin = new Random().nextInt(100);
		for (int i = 0; i < n; i++) {
			list.add(begin + 1 + i);
		}
		// 输出当前的所有数字
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
		String line = InputUtils.getInput("请输入需要删除的整数:");
		list.remove(Integer.valueOf(line));

		// 中间省略了排序的步骤，就当做是排序好的
		for (int i = 0; i < list.size() - 1; i++) {
			// 出现不等于1的情况
			if ((list.get(i + 1) - list.get(i)) != 1) {
				System.out.println(list.get(i) + 1);
				break;
			}
			if (i == 2) {
				System.out.println(list.get(0) - 1);
				System.out.println(list.get(i + 1) + 1);
			}
		}
	}
}
