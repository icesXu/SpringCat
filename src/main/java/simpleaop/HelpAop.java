/**
 * 
 */
package simpleaop;

/**
 * 下午6:01:12
 * 
 * @author yuzhao.yang
 *
 */
public class HelpAop {
	public static void main(String[] args) {

	}

	public void before() {
		innerBeforeMethod();
		System.out.println("执行方法前：即将执行Main方法!");
	}

	public void innerBeforeMethod() {
		System.out.println("Before内部执行的方法!");
	}

	public void after() {
		System.out.println("执行方法前：执行Main方法完毕!");
	}
}
