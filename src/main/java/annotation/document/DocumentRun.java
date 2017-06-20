/**
 * 
 */
package annotation.document;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 下午11:51:57
 * 
 * @author yuzhao.yang
 *
 */
public class DocumentRun {

	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("http://www.baidu.com").get();
		pageProcessor.processor(parser.class, doc);
		resourceTest();
	}

	public static void resourceTest() throws Exception {
		Properties prop = PropertiesLoaderUtils
				.loadAllProperties("settings.properties");
		System.out.println(prop.getProperty("test1"));
	}
}
