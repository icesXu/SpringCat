/**
 * 
 */
package annotation.document;

import java.lang.reflect.Field;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 下午11:44:33
 * 
 * @author yuzhao.yang
 *
 *         简单的解析类
 */
public class pageProcessor {
	public static <T> T processor(Class<T> conf, Document page) {

		Field[] declaredFields = conf.getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(xpath.class)) {
				String value = field.getAnnotation(xpath.class).value();
				String text = value.substring(2);
				Elements select = page.select(text);
				for (Element ele : select) {
					System.out.println(ele.text());
				}
			}
		}
		return null;
	}
}
