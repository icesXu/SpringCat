/**
 * 
 */
package com.chen.yuzhao.spiders;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.chen.utils.PropertiesUtil;
import com.chen.utils.WebDriverUtil;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月12日 下午4:06:55
 */
public class SimpleTest {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		test();
	}

	public static void test() throws IOException, InterruptedException {
		WebDriver driver = WebDriverUtil.getChromeDriver();
		login(driver);
	}

	public static void login(WebDriver driver) throws InterruptedException {

		driver.get("http://192.168.10.35:8040/EntCredit/monitor.htm");
		while (true) {
			Thread.sleep(5000);
			driver.navigate().refresh();
		}

	}
}
