/**
 * 
 */
package ObserversModel;

/**
 *下午12:48:01
 * @author yuzhao.yang
 *
 */
public interface Subject {

	//注册观察者
	public void registerObserver(Observer o);
	
	//删除观察者
	public void removeObserver(Observer o );
	
	//通知所有观察者
	public void notifyAllObservers();
}
