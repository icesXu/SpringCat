/**
 * 
 */
package stack;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 上午11:57:46
 */
public class LinkedStack implements StackADT {
	// 栈顶元素
	private LinearElement top;
	// 栈的大小统计
	private int count;

	public LinkedStack() {
		// TODO Auto-generated constructor stub
		top = null;
		count = 0;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public void push(Object object) {
		// TODO Auto-generated method stub

	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			System.exit(1);
		}
		Object element = top.getData();
		// 栈顶元素替换
		top = top.getNext();
		// 栈的size减小
		count--;
		return element;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return top.getData();
	}

}
