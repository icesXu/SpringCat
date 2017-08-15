/**
 * 
 */
package queue;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 下午1:56:32
 */
public class LinkedQueue<T> implements Queue<T> {
	private Node head;
	private Node tail;
	private int size;

	public LinkedQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
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

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
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

	class Node<T> {
		T data;
		Node<T> next;

		/**
		 * @return the data
		 */
		public T getData() {
			return data;
		}

		/**
		 * @param data
		 *            the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}

		/**
		 * @return the next
		 */
		public Node<T> getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

}
