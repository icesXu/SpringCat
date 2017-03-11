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

import utils.InputUtils;

/**
 * 下午7:43:09
 * 
 * @author yuzhao.yang
 *
 */
public class AmendTables {
	public static void main(String[] args) {

	}

	public List<Integer> allLegLength(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(new Random().nextInt(104) + 1);
		}
		return list;
	}

	public List<Integer> allPrices(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(new Random().nextInt(200) + 1);
		}
		return list;
	}

	public void AmendTable() {
		String input = InputUtils.getInput("请输入桌腿数目:");
		int n = Integer.parseInt(input);
		// 所有桌腿长度
		List<Integer> allLegs = allLegLength(n);
		// 所有桌腿去除代价
		List<Integer> allPrices = allPrices(n);

		// Collections.sort(allLegs);

		// 以某一种桌腿为基准：就是需要保留的桌腿长度
		// 比其长的，全部删除
		// 比其短的，按照一定的规则予以保留
		// 如果个数比现在的要少，则保留
		// 如果个数比现在的多，必须要删除
		// 遍历那些个数比其少的，从最小到最大进行遍历，进行代价计算
		// 对于每一种个数比其少的，计算出其总代价
		// 由此，最先前需要计算出每一种长度的总代价
		// 按照长度进行排序
		// 计算出每一种长度清除的总代价

		// 重点1：计算出每种桌腿的个数
		// 桌腿长度排序
		// 完成桌腿与代价的一一对应关系
		List<Leg> legs = new ArrayList<Leg>();
		for (int i = 0; i < n; i++) {
			Leg leg = new Leg(allLegs.get(i), allPrices.get(i));
			legs.add(leg);
		}
		// 对于桌腿依据长度进行排序
		Collections.sort(legs);
		// 遍历
		int leftPrices = 0;
		for (Leg ele : legs) {
			leftPrices += ele.getPrice();
		}

		// 计算最小的代价
		int min = Integer.MAX_VALUE;

		int curNum = 1;
		for (int i = 1; i < legs.size(); i += curNum) {
			// 本次代价的初始值
			int count = 0;

			// 从当前长度开始计算
			// 计算出当前长度的个数:
			int curLength = legs.get(i).getLength();
			int result = 1;
			int k = 1;
			while ((i + k) < legs.size()
					&& legs.get(i + k).getLength() == curLength) {
				// 如果计入当前，剩余的代价递减
				leftPrices -= legs.get(i + k).getPrice();
				k++;
				result += 1;
			}
			// 计算后的result代表当前需要保留的元素的总长度
			curNum = result;
			// 下次遍历，以当前元素的个数，递增之后，开始下一轮的遍历

			// 还需要对每种桌腿，进行代价排序
			// 前面的桌腿，需要按照代价进行排序
			// 从最低的代价，开始删除

			List<Leg> partLegs = legs.subList(0, i);
			// 这部分桌腿，必须从代价最低的开始遍历
			List<Integer> beforeList = new ArrayList<Integer>();
			for (Leg leg : partLegs) {
				beforeList.add(leg.getPrice());
			}
			Collections.sort(beforeList);

			for (int j = 0; j < i - curNum; j++) {
				count += beforeList.get(i);
			}
			count += leftPrices;

			// i + curNum后面的所有元素都需要删除
			min = Math.min(count, min);
		}
	}

	class Leg implements Comparable<Leg> {
		private Integer length;
		private Integer price;

		public Leg(Integer length, Integer price) {
			this.length = length;
			this.price = price;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		/**
		 * @desc
		 * @param
		 * @return
		 * @author yuzhao.yang
		 * @date 2017年3月11日
		 */
		public int compareTo(Leg o) {
			// 如果长度较大，且代价高，向后排
			if (this.length > o.length) {
				return 1;
			} else if (this.length < o.length) {
				return -1;
				// 如果长度相等，按照代价排序
			} else if (this.length == o.length && this.price > o.price) {
				return 1;
				// 如果长度相等且代价相同
			} else if (this.length == o.length && this.price == o.price) {
				return 0;
			} else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "length:" + this.length + ";price:" + this.price;
		}
	}
}
