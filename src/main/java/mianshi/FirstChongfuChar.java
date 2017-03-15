/**
 * 
 */
package mianshi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.InputUtils;

/**
 * 上午12:28:42
 * 
 * @author yuzhao.yang
 * 
 *         对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 *         给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 *
 */
public class FirstChongfuChar extends BaseSpider {

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
		String line = InputUtils.getInput("请输入字符串:");
		char[] charArray = line.toCharArray();
		List<Word> list = new ArrayList<Word>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < charArray.length; i++) {
			char inner = charArray[i];
			if (!map.containsKey(inner + "")) {
				map.put(inner + "", 0);
			} else {
				Integer times = map.get(inner + "") + 1;
				map.put(inner + "", times + 1);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				list.add(new Word(key, map.get(key)));
			}
		}

		Collections.sort(list);
		System.out.println(list.get(0).itself);
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
		String line = InputUtils.getInput("请输入字符串:");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (!map.containsKey(ch + "")) {
				map.put(ch + "", 0);
			} else {
				System.out.println(ch + "");
			}
		}

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

	class Word implements Serializable, Comparable<Word> {

		private static final long serialVersionUID = 100L;

		private String itself;
		private Integer oripos;

		/**
		 * @param itself
		 * @param oripos
		 */
		public Word(String itself, Integer oripos) {
			super();
			this.itself = itself;
			this.oripos = oripos;
		}

		/**
		 * @desc
		 * @param
		 * @return
		 * @author yuzhao.yang
		 * @date 2017年3月15日
		 */
		public int compareTo(Word o) {
			// TODO Auto-generated method stub
			if (this.oripos > o.oripos) {
				return 1;
			} else if (this.oripos < o.oripos) {
				return -1;
			} else {
				return 0;
			}
		}

	}
}
