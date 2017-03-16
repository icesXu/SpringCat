/**
 * 
 */
package mianshi;

import java.util.HashMap;
import java.util.Map;

import utils.InputUtils;
import utils.RandomArray;

/**
 * 下午1:48:07
 * 
 * @author yuzhao.yang
 *
 *
 *         每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * 
 *         输出出现次数大于等于n/2的数。
 */
public class MoreThanHalfOccur extends BaseSpider {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月16日
	 */
	@Override
	public void baseCount() {
		// TODO Auto-generated method stub
		String line = InputUtils.getInput("输入数字:");
		String[] array = line.split(" ");
		System.out.println("数组长度:" + array.length);

		for (String ele : array) {
			System.out.print(ele + " ");
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				Integer times = Integer.valueOf(map.get(array[i]));
				map.put(array[i], times + 1);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key) >= array.length / 2) {
				System.out.println(key);
				break;
			}
		}
	}

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月16日
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
	 * @date 2017年3月16日
	 */
	@Override
	public void bestCount() {
		// TODO Auto-generated method stub

	}
}
