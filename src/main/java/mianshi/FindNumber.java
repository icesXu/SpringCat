/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.RandomArray;

/**
 * 下午1:22:22
 * 
 * @author yuzhao.yang
 *
 *
 *         给定一个数组，除了一个数出现1次之外，其余数都出现3次。找出出现一次的数。 如：{1, 2, 1, 2, 1, 2, 7}, 找出7.
 *         格式： 第一行输入一个数n，代表数组的长度，接下来一行输入数组A[n],(输入的数组必须满足问题描述的要求),最后输出只出现一次的数。
 *         要求： 你的算法只能是线性时间的复杂度，并且不能使用额外的空间哦～
 */
class FindNumber extends BaseSpider {

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

		Integer[] initArr = RandomArray.InitArr(10);
		List<Integer> list = new ArrayList<Integer>();
		for (Integer number : initArr) {
			list.add(number);
			list.add(number);
		}
		int index = new Random().nextInt(list.size()) - 1;
		if (index >= list.size()) {
			list.remove(index - 1);
		} else {
			list.remove(index);
		}

		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		// 生成一个随机的数组，其中只有一个元素是非重复的

		// 做一次排序
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i = i + 2) {
			if (list.get(i).equals(list.get(i + 1))) {
				continue;
			}
			System.out.println(list.get(i));
			break;
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
	public void betterCount() {
		// TODO Auto-generated method stub

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

}
