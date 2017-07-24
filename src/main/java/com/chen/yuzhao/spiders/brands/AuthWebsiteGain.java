/**
 * 
 */
package com.chen.yuzhao.spiders.brands;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.chen.utils.PageLoadCondition;
import com.chen.utils.SpiderJsoupUtil;
import com.chen.utils.WebDriverUtil;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年7月7日 下午1:32:43
 */
public class AuthWebsiteGain {

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

	private static final String ROOT_URL = "http://wsjs.saic.gov.cn/";

	public static void main(String[] args) throws Exception {
		process("中诚信征信有限公司");
	}

	public static void process(String name) throws Exception {

		// FiveToRun("");
		init();
		//
		// 获取单独结果的详情
		// getSingleSearchResultDetail();

		// 获取单独结果的流程
		// getSingleSearchResultProcedures();
	}

	/**
	 * @description:
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月7日 下午3:35:46
	 */
	public static void getSingleSearchResultProcedures() {
		String url = "http://wsjs.saic.gov.cn/txnDetail2.do";

	}

	/**
	 * 
	 * @description:同时跑五个省份
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月20日 下午6:11:52
	 */
	public static void FiveToRun(final String name) {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						init();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * 
	 * @description:访问初始页面，获取cookie
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @time:2017年7月7日 下午1:34:28
	 */
	public static void init() throws Exception {

		int size = allIpAndPorts.length;
		int index = new Random().nextInt(size);
		String proxy = allIpAndPorts[index];

		WebDriver driver = WebDriverUtil.getFirefoxWebDriverWithProxy(proxy);

		driver.get("http://sbj.saic.gov.cn/sbcx/");

		// 等待第一个我接受的标签

		// 应该一直等到页面内存我接受的这个标签
		// 标签等待十秒
		PageLoadCondition.wait(driver, 10000,
				By.xpath("/html/body/div/div[5]/div[1]/div[1]/div/p[4]/a"));

		driver.findElement(
				By.xpath("/html/body/div/div[5]/div[1]/div[1]/div/p[4]/a"))
				.click();

		// 必须等到url符合标准
		String url = driver.getCurrentUrl();
		int i = 0;
		while (!url.contains("txnT01") && i < 30) {
			try {
				url = driver.getCurrentUrl();
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}

		if (!url.contains("txn")) {
			throw new Exception("爬取页面加载错误!");
		}

		Document doc = Jsoup.parse(driver.getPageSource());
		if (doc.select("#txnS02").size() == 0) {
			throw new Exception("页面加载失败!");
		}

		// 等到商标综合查询的标签

		// 可以使用URL等待的方式，等到url符合要求才停止

		// PageLoadCondition
		// .wait(driver,
		// 30000,
		// By.xpath(".left_side > ul:nth-child(1) > li:nth-child(2) > table:nth-child(1)"));
		// 点击,点击无效果
		// driver.findElement(
		// By.xpath(".left_side > ul:nth-child(1) > li:nth-child(2) > table:nth-child(1)"))
		// .click();

		// 点击该按钮
		driver.findElement(By.id("txnS02")).click();

		Set<Cookie> cookieSet = driver.manage().getCookies();

		Map<String, String> cookies = new HashMap<String, String>();

		for (Cookie cookie : cookieSet) {
			cookies.put(cookie.getName(), cookie.getValue());
		}
		System.out.println(cookies);

		String nowUrl = driver.getCurrentUrl();
		System.out.println("当前的URL:" + nowUrl);

		Response first = SpiderJsoupUtil.getContent(nowUrl, null, cookies,
				Method.GET, null);
		System.out.println(first.body());
		System.out.println(first.cookies());

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Referer", "http://sbj.saic.gov.cn/sbcx/");

		Response content = SpiderJsoupUtil.getContent(ROOT_URL, null, null,
				null, headers);

		// 输出cookie
		System.out.println(content.cookies());
	}

	/**
	 * 
	 * @description:获取查询页面第一页
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月7日 下午2:57:36
	 */
	public void getFirstPage(String name) {

		String url = "http://wsjs.saic.gov.cn/txnRead02.ajax";

		// 有一个隐藏参数
		String MmEwMD = "1WOf1wKy1KYDsP6_e5sX6am2cvn8_G8SFfK4blvqmPWiqzFov3NY0rdLRR08ruNbucI938sVRP49F4k6FdQz1z0szvPse05Vs9ty0YyeIzvJxiA4ToSP84ymBa0E52RV72M7chMgFyu_pRCt2mZIyak0HvXKtJDh.peAB31ExoG4WEG6RG46NmK_upzeY_aogx525phvSsBWIlgX6PLxbeT8kQntJgwlAy6VmsdCRrLU5zG35Tb0sL8NRTZkzod8.3an3XDthLwiJ_hLLyboN.GBPcSCkXkHk82kpkE.aBKLDxd29Nvd1VGMr7YvLot9m6f.KjbCfZhyOC8zwlFd0ws.HqF2WjDNJbsnGjNXhlE1FDGZPR6Z7e45Mkve7RZ8Vx5TL4C4CHdJW8HmNJFsELGMBlD5HYHew3FV";

		Map<String, String> data = new HashMap<String, String>();

		data.put("request:queryType", "");
		data.put("request:queryType", "");
		data.put("request:queryAuto", "");
		data.put("request:queryMode", "");
		data.put("request:queryCom", "");
		data.put("request.mn", "");
		data.put("request.ncs", "");
		data.put("request:nc", "");
		data.put("request:hnc", "中诚信征信有限公司");
		data.put("request:hne", "");
		data.put("request:sn", "");
		data.put("request:imf", "");
		data.put("request:maxHint", "");
		data.put("request:queryExp", "hncc = 中诚信征信有限公司* ");
		// 该变量需要考虑来源
		data.put("request:mi", "44D6853F3EDF85F6D87BF768D16DCDAB");
		// 考虑该变量来源
		data.put("request:tlong",
				"G3wr/vkEelBbcC+x3ROXZ5uXE60SqBuRrXfPakrxlTidiUPnmTWgDmoc2X8sUFW5");
		// 考虑一下
		data.put("attribute-node:record_cache-flag", "false");
		//
		data.put("attribute-node:record_start-row", "1");
		data.put("attribute-node:record_page-row", "50");
		data.put("attribute-node:record_sort-column", "RELEVANCE");
		data.put("attribute-node:record_page", "1");

		// 加上cookie，可以获取到商标的具体查询结果。
		// 但是其中牵涉到四个可变化的量。
	}

	public static void getSingleSearchResultDetail() throws Exception {
		String url = "http://wsjs.saic.gov.cn/txnDetail.do";

		Map<String, String> cookies = new HashMap<String, String>();
		cookies.put("JSESSIONID", "93DD452F3F37AA0468462DF31158EF09");

		Map<String, String> data = new HashMap<String, String>();
		data.put(
				"y7bRbp",
				"qmMLwg5yV470rAx_XCHqdsk2zjzMjRo.LKRYBaEG.pr7D8e6he4fukgJ3LxfP_AYKR5TYPl7DHgIFwSY7UDvQlWr5k0azqL2gzvf31tiFfJsV3AGe43pkoBeqKV_K2KpDqeQnhR65S4AuGkC");
		data.put(
				"c1K5tw0w6_",
				"SRnUmufNCzF.3qWhlQyNyPzHn33w4sy4UU7hLDqVF1FLWdJhAYFUsSIJwI00K.cUiGYOjLGmayrr8yV9jrYgb2lJQO3KaQ1iO5N8smxWYQ.NegR46jMjBsr1LSdmtG5sUat.Jui9EvxQFFr.ilgtVFiP_pmrlxW5Qi5kHCyGPKPYNvteLHFd6Uv80I4UHo_yDd6td9ZWM.WWBtB6XcJ7fRrBDmufjaEzz4I7Ozw_pZlOZz_F7EMr_NG9wugfcHyd");

		data.put("locale", "zh_CN");

		Response content = SpiderJsoupUtil.getContent(url, data, null,
				Method.POST, null);
		System.out.println(content.body());
	}

}