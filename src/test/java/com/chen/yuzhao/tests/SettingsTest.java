/**
 * 
 */
package com.chen.yuzhao.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月13日 上午10:49:01
 */
public class SettingsTest {
	static Properties prop;

	static {
		try {
			prop = PropertiesLoaderUtils
					.loadAllProperties("settings.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String get(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}

	public static void main(String[] args) {
		System.out.println(SettingsTest.get("testKey", ""));
	}
}
