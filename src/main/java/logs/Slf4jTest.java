/**
 * 
 */
package logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月20日 下午4:10:19
 */
public class Slf4jTest {
	private static Logger logger = LoggerFactory.getLogger("mylog");

	public static void main(String[] args) {
		logger.info("info slf4j");
	}

}
