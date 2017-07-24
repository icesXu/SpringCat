/**
 * 
 */
package com.chen.yuzhao.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.chen.utils.TextToVoiceUtil;
import com.chen.utils.WebDriverUtil;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月11日 上午12:30:52
 */
public class TextToVoiceTest {
	public static void main(String[] args) throws IOException {
		test();
	}

	public static void test() throws IOException {

		String line = "严欢春是个坏人，但有时候也是个好人";

		WebDriver driver = null;
		try {
			driver = WebDriverUtil.getFirefoxWebDriver();
			TextToVoiceUtil.toVoicePage(driver);

			TextToVoiceUtil.generateVoice(driver, line.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
