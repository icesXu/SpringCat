/**
 * 
 */
package simpleaop;

import java.lang.reflect.Constructor;
import java.net.URLClassLoader;

/**
 * 下午5:08:56
 * 
 * @author yuzhao.yang
 *
 */
public class MainAopSon extends MainAop {

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @throws Exception
	 * @date 2017年3月25日
	 */
	@Override
	public void mainMethod() {
		// TODO Auto-generated method stub
		Class<? super MainAopSon> superclass = MainAopSon.class.getSuperclass();
		System.out.println(superclass.getName());
		try {
			test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MainAop aop = new MainAopSon();
		aop.mainMethod();
	}

	public void test() throws Exception {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		ClassLoader parent = loader.getParent();
		System.out.println(System.getProperty("java.ext.dirs"));

		Class<?> loadClass = loader.loadClass("simpleaop.HelpAop");
		System.out.println(loadClass.getName());

		Class<?> forName = Class.forName("java.lang.String");
		Constructor<?>[] constructors = forName.getConstructors();
		for (Constructor<?> con : constructors) {
			System.out.println(con.getName());
			
		}
	}
}
