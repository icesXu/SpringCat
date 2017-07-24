/**
 * 
 */
package com.chen.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月9日 上午10:50:31
 */
public class GbkToChinese {
	public static void main(String[] args) throws Exception {
	}

	public static String transfer(String text)
			throws UnsupportedEncodingException {
		text = URLEncoder.encode(text, "gbk");
		text = URLDecoder.decode(text, "utf-8");

		return text;
	}
}
