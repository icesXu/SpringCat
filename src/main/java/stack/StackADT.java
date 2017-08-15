/**
 * 
 */
package stack;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 上午11:55:02
 */
public interface StackADT {
	// 压栈
	void push(Object object);

	// 出栈
	Object pop();

	boolean isEmpty();

	int size();

	// 返回栈顶元素的引用
	Object peek();

	String toString();

}
