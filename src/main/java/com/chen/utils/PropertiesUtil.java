/**
 * 
 */
package com.chen.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.meidusa.amoeba.sqljep.function.In;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月13日 上午10:54:37
 */
public class PropertiesUtil {

	static Properties prop;

	static {
		prop = new Properties();
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
}
