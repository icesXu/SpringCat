/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 下午11:59:10
 * 
 * @author yuzhao.yang
 * 
 *         请设计一个高效算法，再给定的字符串数组中，找到包含”Coder”的字符串(不区分大小写)，并将其作为一个新的数组返回。结果字符串的顺序按照
 *         ”Coder”出现的次数递减排列，若两个串中”Coder”出现的次数相同，则保持他们在原数组中的位置关系。
 *
 */
public class SearchCoder extends BaseSpider {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月14日
	 */
	@Override
	public void baseCount() {
		// TODO Auto-generated method stub
		String[] array = new String[] { "i am a coder", "All be coders",
				"Coder Coder", "Code" };
		System.out.println("数组的size:" + array.length);
		List<Appear> list = new ArrayList<Appear>();
		for (int i = 0; i < array.length; i++) {
			int index = 0;
			if (array[i].contains("coder")) {
				// 判断出现次数
				// 只要包含着
				String example = array[i];
				while (example.indexOf("coder") != -1) {
					int position = example.indexOf("coder");
					index++;
					// 从当前的位置向后移动
					example = example.substring(position + 5);
				}
			}
			if (index != 0) {
				Appear appear = new Appear(array[i], i, index);
				list.add(appear);
			}
		}
		Collections.sort(list);
		for (Appear appear : list) {
			System.out.println(JSON.toJSONString(appear));
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
	public void betterCount() {
		// TODO Auto-generated method stub

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

	}

	class Appear implements Comparable<Appear> {
		private String itself;
		private Integer oripos;
		private Integer times;

		/**
		 * @param itself
		 * @param times
		 */
		public Appear(String itself, Integer oriInteger, Integer times) {
			super();
			this.oripos = oriInteger;
			this.itself = itself;
			this.times = times;
		}

		public String getItself() {
			return itself;
		}

		public Integer getOripos() {
			return oripos;
		}

		public void setOripos(Integer oripos) {
			this.oripos = oripos;
		}

		public void setItself(String itself) {
			this.itself = itself;
		}

		public Integer getTimes() {
			return times;
		}

		public void setTimes(Integer times) {
			this.times = times;
		}

		/**
		 * @desc
		 * @param
		 * @return
		 * @author yuzhao.yang
		 * @date 2017年3月15日
		 */
		public int compareTo(Appear o) {
			// TODO Auto-generated method stub
			if (this.times > o.times) {
				return 1;
			} else if (this.times < o.times) {
				return -1;
			} else {
				if (this.oripos == o.oripos) {
					return 0;
				} else if (this.oripos > o.oripos) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}

	public static void main(String[] args) {
	}
}
