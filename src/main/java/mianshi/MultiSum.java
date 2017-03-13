/**
 * 
 */
package mianshi;

import java.util.HashMap;
import java.util.Map;

import utils.InputUtils;

/**
 * 下午11:52:24
 * 
 * @author yuzhao.yang
 *
 *
 *         牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：在这本算法书页码中0~9每个数字分别出现了多少次？
 */
public class MultiSum {
	public static void main(String[] args) {
		count();
	}

	public static void count() {
		Map<String, String> tongji = new HashMap<String, String>();
		Integer n = InputUtils.getInt("请输入页数:N");
		for (int i = 1; i <= n; i++) {
			String line = i + "";
			char[] charArray = line.toCharArray();
			for (char a : charArray) {
				if (tongji.containsKey(a + "")) {
					int old = Integer.parseInt(tongji.get(a + ""));
					tongji.put(a + "", (old + 1) + "");
				} else {
					tongji.put(a + "", "1");
				}
			}
		}
		for (String key : tongji.keySet()) {
			System.out.print(key + ":" + tongji.get(key) + " ");
		}
	}
}
