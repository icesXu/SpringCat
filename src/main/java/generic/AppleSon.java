/**
 * 
 */
package generic;

/**
 * 下午1:52:37
 * 
 * @author yuzhao.yang
 *
 */
public class AppleSon extends Apple {

	private String basic;

	/**
	 * @param info
	 */
	public AppleSon(String info, String basic) {
		super(info);
		this.basic = basic;
		System.out.println(info);
	}

	public static void main(String[] args) {
		AppleSon appleSon = new AppleSon("first", "basic");
		System.out.println(appleSon.basic);
	}
}
