/**
 * 
 */
package com.chen.utils;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月9日 下午3:46:27
 */
public class WebDriverUtil {

	/**
	 * 
	 * @description:获取火狐浏览器
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月5日 下午2:03:26
	 */
	public static WebDriver getFirefoxWebDriver() {
		File file = new File(PropertiesUtil.get("firefox.path", ""));
		System.setProperty("webdriver.firefox.bin", file.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	/**
	 * 
	 * @description:
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月5日 下午2:03:42
	 */
	public static WebDriver getFirefoxWebDriverWithProxy(String proxy)
			throws Exception {

		String filePath = PropertiesUtil.get("firefox.path", "");

		if (StringUtils.isEmpty(filePath)) {
			throw new Exception("浏览器文件路径有误！");
		}

		File file = new File(filePath);
		System.setProperty("webdriver.firefox.bin", file.getAbsolutePath());
		FirefoxProfile profile = new FirefoxProfile();

		if (StringUtils.isEmpty(proxy)) {
			throw new Exception("代理为空!");
		}
		String[] splits = proxy.split(":");

		profile.setPreference("network.proxy.http", splits[0]);
		profile.setPreference("network.proxy.http_port", splits[1]);
		WebDriver driver = new FirefoxDriver(profile);

		return driver;
	}

	public static WebDriver getPhantomjsDriver() {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities
				.phantomjs();
		desiredCapabilities.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:/Users/YYZYHC/Java/phantomjs-1.9.2-windows/phantomjs.exe");
		// desiredCapabilities.setCapability(
		// PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
		// "/usr/bin/phantomjs");
		return new PhantomJSDriver(desiredCapabilities);
	}

	public static WebDriver getChromeDriver() {
		File file = new File("C:/Users/YYZYHC/Java/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--user-data-dir=C:/Users/YYZYHC/AppData/Local/Google/Chrome/User Data/Default");
		//
		// 通过配置参数删除“您使用的是不受支持的命令行标记：--ignore-certificate-errors。稳定性和安全性会有所下降。”提示
		options.addArguments("--start-maximized",
				"allow-running-insecure-content", "--test-type");
		WebDriver driver = new ChromeDriver(options);

		return driver;
	}

	@Deprecated
	public static WebDriver getChromeDriverWithProxy(String proxyString) {

		File file = new File("C:/Users/YYZYHC/Java/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		ChromeOptions options = new ChromeOptions();

		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyString);
		proxy.setSslProxy(proxyString);
		options.addArguments();

		options.addArguments("--user-data-dir=C:/Users/YYZYHC/AppData/Local/Google/Chrome/User Data/Default");
		//
		// 通过配置参数删除“您使用的是不受支持的命令行标记：--ignore-certificate-errors。稳定性和安全性会有所下降。”提示
		options.addArguments("--start-maximized",
				"allow-running-insecure-content", "--test-type");
		WebDriver driver = new ChromeDriver(options);

		return driver;

	}
}
