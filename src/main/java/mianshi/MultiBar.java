/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;

/**
 * 下午2:29:31
 * 
 * @author yuzhao.yang
 *
 */
public class MultiBar {
	public static void main(String[] args) {
		MultiBar multiBar = new MultiBar();
		multiBar.BigBar();
	}

	public void BigBar() {
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		while (true) {
			System.out.println("请输入数据:");
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			String line = sc.next();

			String[] array = line.split(" ");
			int oper = Integer.parseInt(array[0]);
			Integer length = Integer.parseInt(array[1]);
			if (oper == 1) {
				if (list.size() >= 2) {
					list.add(length);
					sum += length;
					Collections.sort(list);
					// 除却最大元素之外的所有元素，大于最大元素
					if (sum - list.get(list.size() - 1) > list
							.get(list.size() - 1)) {
						System.out.println("当前List所有元素:"
								+ JSON.toJSONString(list));
						System.out.println("Yes");
					} else {
						System.out.println("当前List所有元素:"
								+ JSON.toJSONString(list));
						System.out.println("No");
					}
				} else {
					list.add(length);
					sum += length;
					System.out.println("当前List所有元素:" + JSON.toJSONString(list));
					System.out.println("No");
				}
			}
			if (oper == 2) {
				if (list.size() != 0) {
					if (list.contains(length)) {
						list.remove(length);
						sum -= length;
						// 除却最大元素之外的所有元素，大于最大元素
						if (sum - list.get(list.size() - 1) > list.get(list
								.size() - 1)) {
							System.out.println("Yes");
							System.out.println("当前List所有元素:"
									+ JSON.toJSONString(list));
						} else {
							System.out.println("当前List所有元素:"
									+ JSON.toJSONString(list));
							System.out.println("No");
						}
					} else {
						System.out.println("当前List所有元素:"
								+ JSON.toJSONString(list));
						System.out.println("您要删除的元素不存在!");
					}
				} else {
					System.out.println("当前List所有元素:" + JSON.toJSONString(list));
					System.out.println("已输入元素为0，不可删除!");
				}
			}
		}
	}

	// 最好能够实现一个辅助栈，始终用于保存当前最大的长度

	class Bar {
		private int length;

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}
	}

	class MyStack2 {
		// 数据存储栈
		private List<Bar> dataList;
		// 最大值栈
		private List<Bar> maxList;

		public void add(Bar bar) {
			dataList.add(bar);
		}

		public void remove(Bar bar) {
			dataList.remove(bar);
		}

	}
}
