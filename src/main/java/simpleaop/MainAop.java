/**
 * 
 */
package simpleaop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 下午5:59:54
 * 
 * @author yuzhao.yang
 *
 */
public class MainAop {

	public static void main(String[] args) throws Exception {
		MainAop aop = new MainAop();
		Properties prop = PropertiesLoaderUtils
				.loadAllProperties("settings.properties");
		String className = prop.getProperty("className");
		Class<?> forName = Class.forName(className);
		Method[] methods = forName.getMethods();
		for (Method method : methods) {
			if (method.getName().equals("before")) {
				method.invoke(forName.newInstance());
			}
		}
		aop.mainMethod();

		for (Method method : methods) {
			if (method.getName().equals("after")) {
				method.invoke(forName.newInstance());
			}
		}

		ClassLoader loader = ClassLoader.getSystemClassLoader();

	}

	public void mainMethod() {
		System.out.println("主要调用的方法!");
	}
}
