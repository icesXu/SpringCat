/**
 * 
 */
package CallBack;

/**
 *下午11:22:50
 * @author yuzhao.yang
 *
 */
public class Employee {
	private CallBack callBack;
	
	public void setCallBack(CallBack callBack){
		this.callBack = callBack;
	}
	
	public void doSomeThing() throws InterruptedException{
		for(int i = 0 ; i < 10 ; i++){
			System.out.println("还在做事情!");
			Thread.sleep(1000);
		}
		callBack.execute();
	}

}
