/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 下午1:23:22 URL :http://group.jobbole.com/28738/
 * 
 * @author yuzhao.yang
 *
 */
public class ResPurchase {
	public static void main(String[] args) {

	}

	public void getInput() {
		System.out.println("请输入两个整数:n & m");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		String line = sc.next();
		String n = line.split(" ")[0];
		String m = line.split(" ")[1];
		System.out.println("桌子总数:" + n + ";客人批数:" + m);

		List<Integer> list = new ArrayList<Integer>();
		System.out.println("请输入桌子容量");
		Scanner sc1 = new Scanner(System.in);
		sc1.useDelimiter("\n");
		String line1 = sc1.next();
		String[] array = line1.split(" ");
		for (String ele : array) {
			list.add(Integer.parseInt(ele));
		}

		// 获取其中最大的值
		int result = 0;
		for (Integer element : list) {
			if (element > result) {
				result = element;
			}
		}

		// 用于存储客人的消费能力
		List<String> xiaofei = new ArrayList<String>();

		System.out.println("请输入" + m + "行数:");
		for (int i = 0; i < Integer.parseInt(m); i++) {
			Scanner sc3 = new Scanner(System.in);
			String line3 = sc.next();
			xiaofei.add(i + "#" + line3);
			sc3.useDelimiter("\n");
		}

		// 接下来，输出桌子容量，并且输入客人以及消费能力，用于存储
		// 客人以及其消费能力的对应，用一个hashMap进行存储
		// 接下来需要计算，如何接收客人，能够达到最大的消费能力，但是每次消费都只是一次消费。
		// 根据条件去过滤

		// 对于桌子进行遍历，该桌子能够容纳的人数，以及最大金额
		int sum = 0;
		// 给被过滤掉的那一批客人，予以标记	
		for (int i = 0; i < list.size(); i++) {
			int max = 0;
			for (int j = 0; j < xiaofei.size(); j++) {
				// 每批的人数

				int renshu = Integer.parseInt((xiaofei.get(j).split("#")[1])
						.split(" ")[0]);
				int jine = Integer.parseInt((xiaofei.get(j).split("#")[1])
						.split(" ")[1]);

				// 需要确定其不会重复计算
				// 一遍遍过滤，最终定下之后，刷掉这一组，否则其他桌还坐着这桌的人，就不合理了。
				// 小于等于当前桌子的尺寸
				if (renshu <= list.get(i)) {
					// 需要刷出当前的最大值，并且给这组一个标记
					max = Math.max(max, jine);
				}
			}
		}
	}

	/**
	 * 
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月10日
	 */
	public int max() {
		// 遍历最大值也可以解决问题的
		//

		return 0;
	}
}
