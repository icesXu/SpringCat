/**
 * 
 */
package mianshi;

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
		System.out.println("基础方法测试:");
		baseCount();

		System.out.println("较好方法测试:");
		betterCount();

		System.out.println("最好方法测试:");
		bestCount();
	}

	public abstract void baseCount();

	// 较好解法
	public abstract void betterCount();

	// 自己定义的三种方法级别
	public abstract void bestCount();
}
