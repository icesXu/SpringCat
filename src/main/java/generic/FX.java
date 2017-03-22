/**
 * 
 */
package generic;

/**
 * 上午9:46:59
 * 
 * @author yuzhao.yang
 *
 */
public class FX<T> {
	private T ob; // 定义泛型成员变量

	public FX(T ob) {
		this.ob = ob;
	}

	public T getOb() {
		return ob;
	}

	public void showType() {
		System.out.println("T的实际类型是: " + ob.getClass().getName());
	}

	public static void main(String[] args) {
		FX<Integer> intOb = new FX<Integer>(100);
		intOb.showType();
		System.out.println("value= " + intOb.getOb());
		System.out.println("----------------------------------");

		FX<String> strOb = new FX<String>("CSDN_SEU_Calvin");
		strOb.showType();
		System.out.println("value= " + strOb.getOb());
	}
}
