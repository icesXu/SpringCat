/**
 * 
 */
package service.cdplay;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextConfigurationAttributes;

/**
 * 上午10:19:59
 * 
 * @author yuzhao.yang
 *
 */
@Component
public class CDPlayerTest {
	@Autowired
	private MediaPlayer player;

	@Autowired
	private CompactDisc cd;

	@Resource(name = "settings")
	private Properties prop;

	// @Value("#{settings['test'] ?: '123.57.23.67'}")
	// private String value;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CDPlayerTest bean = ctx.getBean(CDPlayerTest.class);
		bean.play();
	}

	public void play() {
		player.play();
		// System.out.println(prop.getProperty("test"));
	}

}
