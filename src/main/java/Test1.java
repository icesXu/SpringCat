import java.io.IOException;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import service.Person;

/**
 * 
 */

/**
 * 下午4:01:40
 * 
 * @author yuzhao.yang
 *
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person person = (Person) ctx.getBean("chinese");
		person.useAxe();

		Properties loadAllProperties = PropertiesLoaderUtils
				.loadAllProperties("settings.properties");
		System.out.println(loadAllProperties.getProperty("test"));
	}
}
