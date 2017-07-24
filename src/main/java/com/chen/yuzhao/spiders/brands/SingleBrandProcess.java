/**
 * 
 */
package com.chen.yuzhao.spiders.brands;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chen.utils.PropertiesUtil;
import com.chen.utils.WebDriverUtil;
import com.chen.yuzhao.dao.BrandDetailDAO;
import com.chen.yuzhao.dao.BrandProceduresDAO;
import com.chen.yuzhao.model.BrandDetail;
import com.chen.yuzhao.model.BrandProcedures;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年7月5日 上午10:59:13
 */
public class SingleBrandProcess {

	private static Jedis redisUtil = new Jedis("192.168.10.35", 6379);

	public static String[] allIpAndPorts = { "202.107.245.56:20822",
			"118.119.102.51:20282", "fs.vpsnb.com:30322", "58.57.62.227:20372",
			"171.11.232.4:20142",
			"122.5.0.82:20322",
			"157.122.243.165:20324",
			"113.59.34.55:20226",
			"221.10.137.9:20072",
			"125.64.91.84:20342",
			"183.58.26.61:20162",
			"aslt1.leyuyun.com:20326",
			"113.59.34.55:20268",
			"121.63.178.246:21382",
			"59.53.192.46:20442",
			"60.169.78.60:20240",// new Start
			"60.175.118.78:20244", "lydx1.leyuyun.com:20258",
			"lhlt1.leyuyun.com:20074", "222.175.75.26:20040",
			"222.174.243.59:20522", "222.187.196.139:20318",
			"58.218.250.102:20044", "nbdx1.leyuyun.com:20248",
			"122.228.18.227:20018", "222.76.204.164:20082",
			"58.23.89.42:20136", "58.222.197.50:20214", "58.221.59.82:20042",
			"yzdx1.leyuyun.com:20158", "222.89.114.110:20182",
			"123.55.73.53:20196" };

	private static Logger logger = LogManager.getLogger("mylog");

	public static RoseAppContext ctx = new RoseAppContext();

	public static void main(String[] args) throws Exception {

		try {
			logger.info("开始查询");
			process("中诚信征信有限公司");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询有误!");
		} finally {

		}
	}

	/**
	 * 
	 * @description:通过WebDriver获取
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月6日 下午3:03:23
	 */
	public static void process() throws Exception {

		String key = PropertiesUtil.get("singleBrandRedisKey", "brandsTest");

		String name = redisUtil.rpop(key);

		// 当能够取到名称的时候，线程就继续执行
		while (StringUtils.isNoneBlank(name)) {

			// 内部最好放置一个try，保证该线程一直存活下去
			// 每次都随机取出一个代理
			int size = allIpAndPorts.length;
			int index = new Random().nextInt(size);
			String proxy = allIpAndPorts[index];

			// 线程内部开辟出一个driver
			WebDriver driver = WebDriverUtil
					.getFirefoxWebDriverWithProxy(proxy);
			try {
				driver.get("http://sbj.saic.gov.cn/sbcx/");
				Thread.sleep(3000);
				List<WebElement> list = driver.findElements(By.tagName("a"));
				for (WebElement webElement : list) {
					String attr = webElement.getAttribute("href");
					if (StringUtils.isNoneBlank(attr)) {
						if (attr.equals("http://wsjs.saic.gov.cn/")) {
							webElement.click();
							break;
						}
					}
				}

				System.out.println(driver.manage().getCookies());
				list = driver.findElements(By.tagName("p"));
				for (WebElement webElement : list) {
					String text = webElement.getText();
					if (StringUtils.isNoneBlank(text)) {
						if (text.equals("商标综合查询")) {
							webElement.click();
							break;
						}
					}
				}
				Thread.sleep(3000);
				WebElement element = driver.findElement(By.name("request:hnc"));
				element.sendKeys(name);
				Thread.sleep(3000);
				driver.findElement(By.id("_searchButton")).click();
				// 跳转到最新的窗口

				Document document = Jsoup.parse(driver.getPageSource());

				// 收获其中的列表，并且进行循环

				// 在每个循环的过程中，进行数据插入

			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				driver.quit();
			}
		}
	}

	/**
	 * 
	 * @description:
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @time:2017年7月5日 上午10:59:51
	 */
	public static void process(String name) throws Exception {

		// 每次都随机取出一个代理
		int size = allIpAndPorts.length;
		int index = new Random().nextInt(size);
		String proxy = allIpAndPorts[index];

		// 线程内部开辟出一个driver
		WebDriver driver = WebDriverUtil.getFirefoxWebDriver();

		driver.get("http://sbj.saic.gov.cn/sbcx/");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (WebElement webElement : list) {
			String attr = webElement.getAttribute("href");
			if (StringUtils.isNoneBlank(attr)) {
				if (attr.equals("http://wsjs.saic.gov.cn/")) {
					webElement.click();
					break;
				}
			}
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list = driver.findElements(By.tagName("p"));
		for (WebElement webElement : list) {
			String text = webElement.getText();
			if (StringUtils.isNoneBlank(text)) {
				if (text.equals("商标综合查询")) {
					webElement.click();
					break;
				}
			}
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.name("request:hnc"));
		element.sendKeys(name);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.findElement(By.id("_searchButton")).click();
		// 跳转到最新的窗口

		Document document = Jsoup.parse(driver.getPageSource());
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(document.text());
	}

	/**
	 * 
	 * @description:每个商标可能有多个查询结果，需要针对每个查询结果进行加工和处理
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月5日 下午3:34:00
	 */
	public static void dealWithSingleResult(WebDriver driver) {
		Document doc = Jsoup.parse(driver.getPageSource());

		// 每一条结果生成一个UUID
		String uuid = UUID.randomUUID().toString();

		// 将该条数据插入到数据库中，并且加以处理
		// 返回值是当前的这个detail
		BrandDetail detail = parseDetails(doc, uuid);

		// 需要通过点击之后，继续轮换
		parseProcedures(doc, detail);

	}

	/**
	 * 
	 * @description:用于商标流程的解析，并且插入数据库
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月4日 下午6:26:34
	 */
	public static JSONArray parseProcedures(Document doc, BrandDetail detail) {
		JSONArray jsa = new JSONArray();
		Elements ztwz = doc.select(".ztwz");
		if (null != ztwz && ztwz.size() != 0) {
			Element div = ztwz.first();
			Elements trs = div.select("tr");
			if (null != trs && trs.size() != 0) {
				for (Element tr : trs) {
					BrandProcedures procedure = new BrandProcedures();

					procedure.setBrand_name(detail.getBrand_name());
					procedure.setUuid(detail.getUuid());
					procedure.setAdd_time(new Date());
					procedure.setRegister_num(tr.select("td").first().text()
							.trim());
					procedure.setBusiness_name(tr.select("td").get(1).text()
							.trim());
					procedure.setSection_name(tr.select("td").get(2).text()
							.trim());
					procedure.setConclusion(tr.select("td").get(3).text()
							.trim());
					procedure.setProcedure_date(tr.select("td").get(4).text()
							.trim());

					// 将该数据进行插入
					ctx.getBean(BrandProceduresDAO.class).add(procedure);
				}
			}
		}
		return jsa;
	}

	/**
	 * 
	 * @description:从页面文档中解析出细节详情
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月5日 上午10:10:53
	 */
	public static BrandDetail parseDetails(Document doc, String uuid) {
		BrandDetail detail = new BrandDetail();
		Elements tds = doc.select("td");
		for (int i = 0; i < tds.size(); i++) {
			Element td = tds.get(i);
			if (td.text().contains("商品/服务")) {
				detail.setService_content(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("类似群")) {
				detail.setLike_groups(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请/注册号")) {
				detail.setApply_num(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请日期")) {
				detail.setApply_date(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("国际分类")) {
				detail.setClass_num(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请人名称（中文）")) {
				detail.setApplicant_name_cn(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请人名称（英文）")) {
				detail.setApplicant_name_en(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请人地址（中文）")) {
				detail.setApplicant_address_cn(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请人地址（英文）")) {
				detail.setApplicant_address_en(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("初审公告期号")) {
				detail.setInit_notice_num(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("注册公告期号")) {
				detail.setRegister_notice_num(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("是否共有商标")) {
				detail.setIf_common_brand(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("初审公告日期")) {
				detail.setInit_notice_date(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("注册公告日期")) {
				detail.setRegister_notice_date(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("商标类型")) {
				detail.setBrand_type(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("专用权期限")) {
				detail.setEx_right_period(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("国际注册日期")) {
				detail.setInter_register_date(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("后期指定日期")) {
				detail.setLatter_point_date(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("优先权日期")) {
				detail.setPriority_date(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("代理人名称")) {
				detail.setAgent_name(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("商标流程")) {
				detail.setProcedures("");
				continue;
			}
			if (td.text().contains("商标状态图标")) {
				detail.setStatus_icon(tds.get(i + 1).text().trim());
				continue;
			}
		}
		detail.setAdd_time(new Date());
		detail.setUuid(uuid);

		// detail完善，进行数据插入
		ctx.getBean(BrandDetailDAO.class).add(detail);

		return detail;
	}
}
