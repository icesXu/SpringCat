/**
 * 
 */
package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.InputUtils;

import com.alibaba.fastjson.JSON;

/**
 * 下午10:53:13
 * 
 * @author yuzhao.yang
 * 
 *         如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。现在给出一个正整数n,
 *         如果n是一个超级素数幂需要找出对应的p,q。
 *
 */
public class SuperSushuMi {
	public static void main(String[] args) {
		count();
		// allSushu(1000);
	}

	public static void count() {
		String line = InputUtils.getInput("请输入需要计算的整数:");
		long n = Long.parseLong(line);

		// 首先，求取小于该根的所有素数
		Set<Long> set = allSushu(n);

		for (long ele : set) {
			int index = 2;
			while (mi(ele, index) < n) {
				index++;
			}
			if (mi(ele, index) == n) {
				System.out.println(ele + "##" + index);
			}
		}
	}

	public static long mi(long m, long n) {
		long result = 1;
		for (long i = 0; i < n; i++) {
			result = m * result;
		}
		return result;
	}

	public static Set<Long> allSushu(long n) {
		Set<Long> set = new TreeSet<Long>();
		// 计算出根下面的所有素数
		long gen = (long) Math.sqrt(n);
		List<Long> counted = new ArrayList<Long>();
		counted.add((long) 2);
		for (long i = 3; i <= gen; i = i + 2) {
			// 如果遇到前面的素数里面能够整除的，说明无需继续了
			// counted记录了前面发现的所有素数
			for (int j = 0; j < counted.size(); j++) {
				// 如果发现可以整除，则该数肯定不是素数
				if (i % (counted.get(j)) == 0) {
					break;
				}
				if (j == counted.size() - 1) {
					set.add(i);
					counted.add(i);
				}
			}
		}
		System.out.println(JSON.toJSONString(set));
		return set;
	}
}
