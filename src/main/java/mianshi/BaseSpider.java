/**
 * 
 */
package mianshi;

import java.util.Scanner;

import org.apache.commons.io.*;
import org.apache.commons.lang.StringUtils;

/**
 * 下午1:36:06
 * 
 * @author yuzhao.yang
 *
 */
public abstract class BaseSpider {
	// 最主要的计算方法
	// 基础解法

	public void count() {

		System.out.println("选择要测试的方法:1:base;2:better;3:best");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		if (StringUtils.isEmpty(line) || line.equals("1")) {
			System.out.println("基础方法测试:");
			baseCount();
		}
		if (line.equals("2")) {
			System.out.println("较好方法测试:");
			betterCount();
		}
		if (line.equals("3")) {
			System.out.println("最好方法测试:");
			bestCount();
		}
	}

	public abstract void baseCount();

	// 较好解法
	public abstract void betterCount();

	// 自己定义的三种方法级别
	public abstract void bestCount();
}
