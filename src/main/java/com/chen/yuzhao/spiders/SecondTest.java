/**
 * 
 */
package com.chen.yuzhao.spiders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月12日 下午2:27:04
 */
public class SecondTest {

	private static Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args) {
		new SecondTest().test();
	}

	public void test() {
		try {
			throw new Exception("参数错误！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("");
		}
	}
}
