package mianshi;

import java.util.Stack;

public class MyStack1 {

	// 构建两个栈
	// 用于存储栈内的数据
	private Stack<Integer> stackData;
	// 用于存储最小值
	private Stack<Integer> stackMin;

	public MyStack1() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	/**
	 * 
	 * @desc 元素入栈
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月9日
	 */
	public void push(int newNum) {
		// 压栈的时候，如果最小栈内是空的:则直接填入
		if (this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
			// 如果其比当前的最小值要小，则将其压入最小栈
		} else if (newNum < this.getmin()) {
			this.stackMin.push(newNum);
			// 否则，将当前的最小栈栈顶的元素入栈
		} else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}

	/**
	 * 
	 * @desc 元素出栈的时候，数据存储栈和最小值存储栈都需要出栈一个元素
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月9日
	 */
	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is Empty.");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}

	/**
	 * @desc 获取当前栈的最小元素
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月9日
	 */
	public int getmin() {
		if (this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}

}