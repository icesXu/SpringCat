/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 下午1:23:22 URL :http://group.jobbole.com/28738/
 * 
 * @author yuzhao.yang
 *
 */
public class ResPurchase {
	public static void main(String[] args) {
		ResPurchase chase = new ResPurchase();
		// chase.sort();
		// chase.customSort();
		chase.AnotherCount();
	}

	public void AnotherCount() {

		List<Integer> list = new ArrayList<Integer>();
		// 用于存储客人的消费能力
		List<Customer> xiaofei = new ArrayList<Customer>();

		System.out.println("请输入两个整数:n & m");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		String line = sc.next();
		String n = line.split(" ")[0];
		String m = line.split(" ")[1];
		System.out.println("桌子总数:" + n + ";客人批数:" + m);

		System.out.println("请输入桌子容量");
		Scanner sc1 = new Scanner(System.in);
		sc1.useDelimiter("\n");
		String line1 = sc1.next();
		String[] array = line1.split(" ");
		for (String ele : array) {
			list.add(Integer.parseInt(ele));
		}

		System.out.println("请输入" + m + "行数:");
		for (int i = 0; i < Integer.parseInt(m); i++) {
			System.out.println("请输入" + i + "行数:");
			Scanner sc3 = new Scanner(System.in);
			sc3.useDelimiter("\n");
			String line3 = sc.next();
			String[] innnerArray = line3.split(" ");
			int num = Integer.parseInt(innnerArray[0]);
			int jine = Integer.parseInt(innnerArray[1]);

			Customer customer = new Customer(i, num, jine);
			xiaofei.add(customer);
		}

		// 桌子按照顺序排序
		// 消费金额按照倒序排序
		// 争取让每张桌子都能够拿到最大的金额
		// 当前桌子的表达形式是一个ArrayList，需要对其进行排序，确定其大小，放入一个新的array里面
		// 对桌子的大小进行顺序排序
		Collections.sort(list);

		Collections.sort(xiaofei);
		Collections.reverse(xiaofei);

		// 已经计算过的客人
		List<Customer> counted = new ArrayList<Customer>();

		// 顺序的对桌子进行排序
		int sum = 0;

		for (Integer table : list) {
			// 逆序的去遍历金额
			for (Customer customer : xiaofei) {
				if (table >= customer.num && !counted.contains(customer)) {
					counted.add(customer);
					sum += customer.jine;
					System.out.println(sum);
					break;
				}
			}
		}
		System.out.println("最大消费金额:" + sum);

	}

	public void sort() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(new Random().nextInt(10));
		}
		Collections.sort(list);
		for (Integer ele : list) {
			System.out.println(ele);
		}
	}

	class Customer implements Comparable<Customer> {
		private Integer pici;
		private Integer num;
		private Integer jine;

		public Integer getJine() {
			return jine;
		}

		public void setJine(Integer jine) {
			this.jine = jine;
		}

		public Customer(Integer pici, Integer num, Integer jine) {
			this.pici = pici;
			this.num = num;
			this.jine = jine;
		}

		public Integer getPici() {
			return pici;
		}

		public void setPici(Integer pici) {
			this.pici = pici;
		}

		public Integer getNum() {
			return num;
		}

		public void setNum(Integer num) {
			this.num = num;
		}

		/**
		 * @desc
		 * @param
		 * @return
		 * @author yuzhao.yang
		 * @date 2017年3月11日
		 */
		public int compareTo(Customer o) {
			// TODO Auto-generated method stub
			if (this.jine < o.jine) {
				return -1;
			} else if (this.jine > o.jine) {
				return 1;
			} else {
				return 0;
			}
		}

		@Override
		public String toString() {
			return "批次:" + this.pici + ";人数:" + this.num + ";消费金额:" + this.jine;
		}
	}

	public void customSort() {
		List<Customer> list = new ArrayList<Customer>();
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer(i, new Random().nextInt(10),
					new Random().nextInt(10));
			list.add(customer);
		}
		Collections.sort(list);
		Collections.reverse(list);
		for (Customer cus : list) {
			System.out.println(cus.toString());
		}
	}
}
