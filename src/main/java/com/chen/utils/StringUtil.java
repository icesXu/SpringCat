package com.chen.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * 此方法用于将汉字字符串转为URL编码（按gbk编码）
	 * 
	 * @param str
	 *            需要编码的汉字字符串
	 * @return
	 */
	public static String strEncode(String str) {
		try {
			str = URLEncoder.encode(str, "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 将post请求cookie字符串整合到map对象中
	 * 
	 * @param cookie
	 * @return
	 */
	public static Map<String, String> cookieToMap(String cookie) {
		Map<String, String> cookies = new HashMap<String, String>();
		String[] strs = cookie.split(";");
		for (int i = 0; i < strs.length; i++) {
			String[] keyVal = strs[i].split("=");
			if (keyVal.length > 1) {
				cookies.put(keyVal[0], keyVal[1]);
			} else {
				cookies.put(keyVal[0], "");
			}
		}
		return cookies;
	}

	/**
	 * 从URL中获取id，此方法主要用于获取公司行业id的时候使用
	 * 
	 * @param url
	 *            包含公司行业id的URL
	 * @return行业id
	 */
	public static String urlGetId(String url) {
		String[] str = url.split("/");
		String id = null;
		if (str.length > 0) {
			id = str[str.length - 1].split(".h")[0];
			id = id.replace("-", "").trim();
		}
		return id;
	}

	/**
	 * 从字符串中获取带小数点的数字
	 * 
	 * @param str
	 * @return
	 */
	public static String getDigitalFromStr(String str) {
		StringTokenizer fenxi = new StringTokenizer(str, " ,"); // 以空格和逗号分
		StringBuffer temps = new StringBuffer();
		while (fenxi.hasMoreTokens()) {
			String s = fenxi.nextToken();
			char sr[] = s.toCharArray();
			for (int i = 0; i < sr.length; i++) {
				if (Character.isDigit(sr[i]) || (sr[i] == '.'))
					temps.append(sr[i]);
			}
		}
		return new String(temps);
	}

	/**
	 * 处理公司URL 有些公司首页的URL
	 * http://tzzylw88.1688.com/?spm=0.0.0.0.xseBnN&tracelog=p4p包含参数
	 * ，但是我们在后面使用的时候不需要这些参数，因此需要处理掉 如果没有参数的则直接返回
	 * 
	 * @param url
	 *            公司URL
	 * @return处理后的URL
	 */
	public String getUrl(String url) {
		String[] str = url.split("\\?");
		if (str.length > 0) {
			url = str[0];
		}
		if (url.contains(":80")) {
			url = url.replace(":80", "");
		}
		return url;
	}

	/**
	 * 此方法用于从公司黄页中获取公司的memberId，memberId用于后面公司基本信息，联系方式等等信息的获取
	 * http://corp.1688.com
	 * /page/index.htm?memberId=b2b-1719140046&fromSite=company_site
	 * &tracelog=gsda_huangye
	 * 
	 * @param url
	 *            公司黄页URL
	 * @return 公司的memberId
	 */
	public String getCompanyIdFromUrl(String url) {
		String[] str = url.split("\\?")[1].split("&");
		String id = null;
		for (String string : str) {
			if (string.contains("memberId")) {
				id = string.split("=")[1];
				break;
			}
		}
		return id;
	}

	/**
	 * 此方法用于从供应等级或者交易勋章中获取 等级和勋章个数字段
	 * 
	 * @param url
	 *            供应等级获取交易勋章的URL
	 * @return 包含等级或者交易勋章个数的字段信息
	 */
	public String getGradeFromUrl(String url) {
		String[] str = url.split("/");
		String grade = str[str.length - 1];
		return grade;
	}

	/**
	 * 此方法用于从包含日期的字符串中获取年月日，去掉时分秒 2015-04-13 09:30:06保留为2015-04-13
	 * 
	 * @param date
	 *            包含日期信息的字符串
	 * @return处理后的日期字符串
	 */
	public String getDate(String date) {
		date = date.split(" ")[0].trim();
		return date;
	}

	/**
	 * 根据传进的行业字符获取行业名
	 * 
	 * @param str
	 *            行业字符
	 * @return行业名
	 */
	public static String getIndustroy(String str) {
		String[] arr = str.split("->");
		if (arr.length == 1) {
			str = arr[0];
		} else if (arr.length == 2) {
			str = arr[1];
		}
		return str;
	}

	public static String generateIp() {
		Random r = new Random();
		return r.nextInt(254) + "." + r.nextInt(254) + "." + r.nextInt(254)
				+ "." + r.nextInt(254);
	}

	public static String getCommonPreString(String str1, String str2) {

		if (StringUtils.isBlank(str1) || StringUtils.isEmpty(str2)) {
			throw new IllegalArgumentException("param error");
		}

		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int length = c1.length < c2.length ? c1.length : c2.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (c1[i] != c2[i]) {
				break;
			}
			sb.append(c1[i]);
		}
		return sb.toString();
	}

	public static String getCommonEndString(String str1, String str2) {
		str1 = StringUtils.reverse(str1);
		str2 = StringUtils.reverse(str2);
		return StringUtils.reverse(getCommonPreString(str1, str2));
	}

	/**
	 * 去掉url中的路径，留下请求参数部分
	 * 
	 * @param strURL
	 *            url地址
	 * @return url请求参数部分
	 */
	private static String TruncateUrlPage(String strURL) {
		String strAllParam = null;
		String[] arrSplit = null;

		strURL = strURL.trim();

		arrSplit = strURL.split("[?]");
		if (strURL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}

		return strAllParam;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, String> URLRequest(String URL) {
		Map<String, String> mapRequest = new HashMap<String, String>();

		String[] arrSplit = null;

		String strUrlParam = TruncateUrlPage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组 www.2cto.com
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");

			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}
}
