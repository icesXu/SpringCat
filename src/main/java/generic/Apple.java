/**
 * 
 */
package generic;

/**
 * 上午11:49:07
 * 
 * @author yuzhao.yang
 *
 */
public class Apple<T> {
	private T info;

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public static void main(String[] args) {
		Apple<String> apple = new Apple<>();
		apple.setInfo("longwang");
		System.out.println(apple.getInfo());
	}

}
