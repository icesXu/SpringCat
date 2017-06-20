/**
 * 
 */
package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月20日 下午1:53:13
 */
public class Log4j2Test {
	private static Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args) {
		process();
	}

	public static void process() {
		logger.trace("trace travel");
		logger.debug("debug level");
		logger.info("info level");
		logger.info("warn level");
		logger.error("error level");
		logger.fatal("fatal error");
	}
}
