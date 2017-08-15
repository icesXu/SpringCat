/**
 * 
 */
package stack;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 下午12:08:23
 */
public class ArrayStack implements StackADT {
	private Object[] contents;

	// top标记下一个入栈的位置，同时也表示栈的容量大小
	private int top;

	private static final int SIZE = 10;

	public ArrayStack() {
		contents = new Object[SIZE];
		top = 0;
	}

	public void expand() {
		Object[] larger = new Object[size() * 2];
		for (int index = 0; index < top; index++) {
			larger[index] = contents[index];
		}
		contents = larger;
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
		if (top == contents.length) {
			expand();
		}
		contents[top] = object;
		top++;
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
		return null;
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
		return top;
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
		Object object;
		if (isEmpty()) {
			object = null;
		} else {
			object = contents[top - 1];
		}
		return object;
	}

}
