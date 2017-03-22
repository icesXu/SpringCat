/**
 * 
 */
package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 上午12:09:01
 * 
 * @author yuzhao.yang
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		// URL resource = loader.getResource("settings.properties");
		Class<?> loadClass = loader.loadClass("search.BinarySearch");
		Method[] methods = loadClass.getMethods();
		for (Method method : methods) {
			if (method.getName().equals("binarySearch")) {
				method.invoke(loadClass.newInstance(), 10);
			}
		}
		InputStream stream = loader
				.getSystemResourceAsStream("settings.properties");
		Properties prop = new Properties();
		prop.load(stream);
		System.out.println(prop.getProperty("test"));
	}
}
