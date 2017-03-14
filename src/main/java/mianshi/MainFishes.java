/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;

import utils.InputUtils;

/**
 * 上午12:03:21
 * 
 * @author yuzhao.yang
 *
 *
 *         牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤
 *         n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸
 *         。鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍
 *         (包括2倍大小和10倍大小)，鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证： 1、放进去的鱼是安全的，不会被其他鱼吃掉
 *         2、这条鱼放进去也不能吃掉其他鱼
 *         鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize
 *         ](考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 */
public class MainFishes {
	public static void main(String[] args) {
		count();
	}

	public static void count() {
		int first = InputUtils.getInt("请输入最小值:minSize");
		int second = InputUtils.getInt("请输入最大值:maxSize");
		int had = InputUtils.getInt("已存在鱼群的数目:Had");
		// 随机生成鱼缸里每条鱼的体重
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < had; i++) {
			list.add(new Random().nextInt(50));
		}
		Collections.sort(list);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();

		// 计算一条新放入的鱼的体重
		// 确定其体重范围

		List<Integer> integers = new ArrayList<Integer>();
		// 遍历的过程，应该跑一下过滤；
		// 初值，
		for (int i = first; i <= second; i++) {
			for (int j = 0; j < list.size(); j++) {
				// 遍历，一旦出现，表示当前的这个数无需计算了
				if ((i >= 2 * list.get(j) && i <= 10 * list.get(j))
						|| (list.get(j) >= 2 * i && list.get(j) <= 10 * i)) {
					break;
				}
				if (j == list.size() - 1) {
					integers.add(i);
				}
			}
		}
		if (integers.size() == 0) {
			System.out.println("不存在！！！");
		} else {
			System.out.println(JSON.toJSONString(integers));
		}
	}
}
