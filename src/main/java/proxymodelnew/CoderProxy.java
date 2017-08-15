/**
 * 
 */
package proxymodelnew;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年8月14日 上午11:52:03
 */
public class CoderProxy implements ICoder {
	private ICoder coder;

	public CoderProxy(ICoder coder) {
		this.coder = coder;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public void implDemands(String demandName) {
		if (demandName.startsWith("Add")) {
			System.out.println("No longer receive 'Add' command");
			return;
		}
		coder.implDemands(demandName);
	}
}
