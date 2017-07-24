/**
 * 
 */
package com.chen.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author yuzhao.yang
 * @description:用于语音合成
 * @time:2017年6月11日 上午12:13:30
 */
public class TextToVoiceUtil {

	private static WebDriver driver;

	/**
	 * 
	 * @description:返回当前正在操作的driver
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月11日 上午12:26:36
	 */
	public static WebDriver getWebDriver() {
		return driver;
	}

	public static void main(String[] args) {
		// 前往百度语音合成页面
		toVoicePage(driver);
		generateVoice(driver, "龙王传说");
		generateVoice(driver, "龙王传说");
	}

	public static void toVoicePage(WebDriver driver) {
		driver.get("http://yuyin.baidu.com/#try");
	}

	/**
	 * 
	 * @description:将文字转化成语音
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月11日 上午12:20:57
	 */
	public static void generateVoice(WebDriver driver, String text) {
		WebElement element = driver.findElement(By.className("speech-input"));
		element.clear();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		element.sendKeys(text);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.findElement(By.className("playbtn")).click();

	}
}
