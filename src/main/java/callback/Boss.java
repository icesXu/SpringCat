/**
 * 
 */
package callback;

/**
 *下午11:20:24
 * @author yuzhao.yang
 *
 */
public class Boss implements CallBack{

	@Override
	public void execute(){
		System.out.println("收到了!!"+System.currentTimeMillis());
	}
}
