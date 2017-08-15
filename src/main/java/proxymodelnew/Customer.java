/**
 * 
 */
package proxymodelnew;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月14日 上午11:53:45
 */
public class Customer {
	public static void main(String[] args) {
		ICoder coder = new JavaCoder("zhang");
		ICoder coderProxy = new CoderProxy(coder);

		coderProxy.implDemands("Add user management");
	}

}
