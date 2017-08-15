/**
 * 
 */
package stack;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月15日 上午11:57:34
 */
public class LinearElement {

	private Object data;
	private LinearElement next;

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
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public LinearElement getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(LinearElement next) {
		this.next = next;
	}

}
