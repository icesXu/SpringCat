/**
 * 
 */
package annotation.document;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 下午11:51:57
 * 
 * @author yuzhao.yang
 *
 */
public class DocumentRun {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.baidu.com").get();
		pageProcessor.processor(parser.class, doc);
	}
}
