package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.SettableListenableFuture;

/**
 * 
 */

/**
 * 下午9:39:41
 * 
 * @author yuzhao.yang
 *
 */
@Component("chinese")
public class Chinese implements Person {

	@Autowired
	private Axe axe;

	// public void setAxe(Axe axe) {
	// this.axe = axe;
	// }

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月20日
	 */
	public void useAxe() {
		// TODO Auto-generated method stub
		System.out.println(axe.chop());
	}

}
