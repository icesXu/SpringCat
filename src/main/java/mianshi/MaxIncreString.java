/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

import utils.RandomArray;

/**
 * 下午9:46:21
 * 
 * @author yuzhao.yang
 *
 *
 *         给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）
 *         例如：给定一个长度为8的数组A{1,3,5,2,4,6,7,8}，则其最长的单调递增子序列为{1,2,4,6,7,8}，长度为6.
 * 
 *         输入描述: 第一行包含一个整数T，代表测试数据组数。 对于每组测试数据： N-数组的长度 a1 a2 … an （需要计算的数组） 保证：
 *         1<=N<=3000,0<=ai<=MAX_INT.
 * 
 *         输出描述: 对于每组数据，输出一个整数，代表最长递增子序列的长度。
 * 
 *         http://group.jobbole.com/23585/#comm-66402
 */
public class MaxIncreString extends BaseSpider {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月15日
	 */
	@Override
	public void baseCount() {
		// TODO Auto-generated method stub
		// 最长单调自增字符串
		Integer[] initArr = RandomArray.InitArr(10);
		for (Integer inte : initArr) {
			System.out.print(inte + " ");
		}

		int max = 0;
		for (int i = 0; i < initArr.length; i++) {
			// 替换着一直遍历
			// 这个字符串，总归必须有开头吧，其开头，只能是每一个字母了
			// 第二，其必须有长度吧
			// 定义已经遍历到的最大值
			int innerMax = initArr[i];
			// length用于保存单调自增序列的长度
			int length = 1;
			// j用于保存便利到i后面的第几个数字
			//
			for (int j = 1; j < initArr.length - i; j++) {
				if (initArr[i + j] > innerMax) {
					// 如果遇到比其大的数字
					length++;
					// 完成最大值替换
					innerMax = initArr[i + j];
				}
			}
			max = Math.max(length, max);
		}
		System.out.println("最大长度:" + max);
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月15日
	 */
	@Override
	public void betterCount() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// 最长单调自增字符串
		Integer[] initArr = RandomArray.InitArr(10);
		List<Number> list = new ArrayList<Number>();
		for (int i = 0; i < initArr.length; i++) {
			list.add(new Number(initArr[i], i));
		}

		for (Integer inte : initArr) {
			System.out.print(inte + " ");
		}

		// 按照数字大小进行排序
		Collections.sort(list);
		System.out.println();
		
		for(Number number : list){
			System.out.print(number.getCount() + ";" + number.getPosition() + " ");
		}
		
		// 现在问题就转化为在list中取其一部分，要求其位置是递增的就可以
		int max = 0;
		// 起始点
		//最主要的在于，可以非连续，简单来说，就是按照这个顺序，截取里面出现最多的坐标的字符串
		//已经满足了递增的顺序
		System.out.println("最大长度:" + max);
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月15日
	 */
	@Override
	public void bestCount() {
		// TODO Auto-generated method stub

	}

	class Number implements Comparable<Number> {
		private Integer count;
		private Integer position;

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Integer getPosition() {
			return position;
		}

		public void setPosition(Integer position) {
			this.position = position;
		}

		/**
		 * @param count
		 * @param position
		 */
		public Number(Integer count, Integer position) {
			super();
			this.count = count;
			this.position = position;
		}

		/**
		 * @desc
		 * @param
		 * @return
		 * @author yuzhao.yang
		 * @date 2017年3月15日
		 */
		public int compareTo(Number o) {
			// TODO Auto-generated method stub
			if (this.count > o.count) {
				return 1;
			} else if (this.count < o.count) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
