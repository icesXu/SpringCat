/**
 * 
 */
package callback.another;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年4月19日 下午3:47:42
 */
public class Ricky implements Student {

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public void resolveQuestion(Callback callback) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		callback.tellAnswer(3);
	}
}
