/**
 * 
 */
package netty;

import java.io.Serializable;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月23日 上午11:03:56
 */
public class Command implements Serializable {

	/**
	 * 
	 **/
	private static final long serialVersionUID = 8779012805158403460L;

	private String actionName;

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName
	 *            the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

}
