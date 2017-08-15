/**
 * 
 */
package proxymodelnew;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月14日 上午11:50:19
 */
public class JavaCoder implements ICoder {
	private String name;

	public JavaCoder(String name) {
		this.name = name;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public void implDemands(String demandName) {
		// TODO Auto-generated method stub
		System.out.println(name + " implemented demand:" + demandName
				+ "in Java!");
	}
}
