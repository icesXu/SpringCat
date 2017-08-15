/**
 * 
 */
package queue;

/**
 * @author yuzhao.yang
 * @param <T>
 * @description:
 * @time:2017年8月15日 下午1:08:57
 */
public class ArrayQueue<T> implements Queue<T> {
	private T[] array;
	private int front;
	private int rear;
	private int size;

	private static final int SIZE = 10;

	public ArrayQueue() {
		array = (T[]) new Object[SIZE];
		front = 0;
		rear = -1;
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
		return 0;
	}

	public void enlarge() {

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
		return front == array.length;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public boolean add(T data) {
		// TODO Auto-generated method stub
		if (isFull()) {
			enlarge();
			front = 0;
		}
		rear = (front + size) % array.length;
		array[rear] = data;

		return false;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public T offer(T data) {
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
	public T peek() {
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
	public T element() {
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
	public T remove() {
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
	public T poll() {
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
	public void clearQueue() {
		// TODO Auto-generated method stub

	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}
}
