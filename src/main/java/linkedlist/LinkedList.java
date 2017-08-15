/**
 * 
 */
package linkedlist;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 下午1:34:14
 */
public class LinkedList {

	Node head = null;
	int length;

	/**
	 * 
	 * @description:向链表中插入数据
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年8月15日 下午1:36:44
	 */
	public void addNode(Object data) {
		// 创建新节点
		Node newNode = new Node(data);
		if (null == head) {
			head = newNode;
			return;
		}
		Node temp = head;
		// 遍历到链表末端去找数据
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.next = newNode;
		length++;
	}

	public boolean deleteNode(int index) {
		if (index < 1 || index > length) {
			return false;
		}
		if (index == 1) {
			head = head.next;
			return true;
		}
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while (null != curNode) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return false;
	}

	class Node {
		private Object data;
		private Node next;

		/**
		 * @return the data
		 */
		public Object getData() {
			return data;
		}

		/**
		 * @param data
		 *            the data to set
		 */
		public void setData(Object data) {
			this.data = data;
		}

		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		public Node(Object data) {
			this.data = data;
		}
	}
}
