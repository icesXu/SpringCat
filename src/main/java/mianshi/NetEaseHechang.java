/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.InputUtils;

/**
 * 下午12:42:28
 * 
 * @author yuzhao.yang
 *
 *
 *         http://group.jobbole.com/29119/
 * 
 *         http://blog.csdn.net/lengxiao1993/article/details/52305420
 */
public class NetEaseHechang {
	public static void main(String[] args) {

	}

	public void count() {
		String line = InputUtils.getInput("请输入一个人数:");

		// 计算出总人数:
		int n = Integer.parseInt(line);

		String line1 = InputUtils.getInput("请输入选择学生的总数:");

		String line2 = InputUtils.getInput("请输入编号间隔:");

		// 学生人数
		int k = Integer.parseInt(line1);
		// 其间间隔
		int d = Integer.parseInt(line2);

		List<Student> stuList = new ArrayList<Student>();

		// 生成能力值:每个学生一个编号，一个能力值，存储于List
		for (int i = 0; i < n; i++) {
			// 能力值可能是负的，予以计算在内
			Student student = new Student(i + 1, new Random().nextInt(50)
					* fushu());
			// 能力值可能是负的，予以计算在内
			// 能力先都换算成正数，从大到小进行计算
			stuList.add(student);
		}

		// 积攒出一个全部是正数的例子
		List<Student> allZhengList = new ArrayList<NetEaseHechang.Student>();
		for (int i = 0; i < stuList.size(); i++) {
			allZhengList.add(new Student(stuList.get(i).getNumber(), Math
					.abs(stuList.get(i).getAbility())));
		}

		// 开始计算达到最大值的，且彼此间间隔在d以内的，其乘积以d计算
		Collections.sort(allZhengList);
		long max = Long.MIN_VALUE;

		// 接下来进行计算

	}

	/**
	 * 
	 * @desc 用于随机生成-1
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月12日
	 */
	public int fushu() {
		int result = -1;
		int size = new Random().nextInt(50) + 1;
		for (int i = 0; i < size; i++) {
			result = result * -1;
		}
		return result;
	}

	class Student implements Comparable<Student> {
		private Integer number;
		private Integer ability;

		public Student(Integer number, Integer ability) {
			this.number = number;
			this.ability = ability;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public Integer getAbility() {
			return ability;
		}

		public void setAbility(Integer ability) {
			this.ability = ability;
		}

		/**
		 * @desc
		 * @param
		 * @return
		 * @author yuzhao.yang
		 * @date 2017年3月12日
		 */
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			if (this.ability > o.ability) {
				return 1;
			} else if (this.ability < o.ability) {
				return -1;
			} else {
				return 0;
			}
		}

	}

}
