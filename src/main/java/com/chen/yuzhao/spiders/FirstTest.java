/**
 * 
 */
package com.chen.yuzhao.spiders;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;

import com.chen.dao.TestDAO;
import com.chen.model.Test;
import com.chen.utils.WebDriverUtil;
import com.chen.yyzyhc.dao.MyTestDAO;
import com.chen.yyzyhc.model.MyTest;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月9日 上午11:23:52
 */
public class FirstTest {

	private static Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args) {
		test();
	}

	public static void test() {
  
		WebDriver driver = WebDriverUtil.getChromeDriver();
		driver.get("https://www.baidu.com");

		try {
			Thread.sleep(2000);
			driver.get("http://www.jd.com");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(Jsoup.parse(driver.getPageSource()));
	}
}
