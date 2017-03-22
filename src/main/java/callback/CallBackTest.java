/**
 * 
 */
package callback;

/**
 *下午11:25:15
 * @author yuzhao.yang
 *
 */
public class CallBackTest {

	public static void main(String [] args) throws InterruptedException{
		Employee employee = new Employee();
		employee.setCallBack(new Boss());
		
		employee.doSomeThing();
	}
}
