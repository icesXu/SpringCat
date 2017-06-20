/**
 * 
 */
package callback.another;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年4月19日 下午3:51:05
 */
public class CallbackTest {
	public void testCallback() {
		Student student = new Ricky();
		Teacher teacher = new Teacher(student);

		teacher.askQuestion();
	}

	public static void main(String[] args) {
		CallbackTest test = new CallbackTest();
		test.testCallback();
	}
}
