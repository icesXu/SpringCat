/**
 * 
 */
package com.chen.yuzhao.spiders.brands;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.chen.utils.SpiderJsoupUtil;
import com.chen.yuzhao.dao.BrandDetailDAO;
import com.chen.yuzhao.dao.BrandProceduresDAO;
import com.chen.yuzhao.model.BrandDetail;
import com.chen.yuzhao.model.BrandProcedures;

/**
 * @author yuzhao.yang
 * @description:查询，需要登录
 * @time:2017年7月6日 下午3:04:22
 */
public class SingleBrandProcessByJsoup {

	public static RoseAppContext ctx = new RoseAppContext();

	private static final String ROOT_URL = "http://www.tmkoo.com";
	private static final String SEARCH_URL = "http://www.tmkoo.com/search!page.php";

	private static Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args) throws Exception {
		process("易优源");
	}

	public static void process(String name) throws Exception {

		String url = ROOT_URL;
		Map<String, String> data = new HashMap<String, String>();
		Response response = null;

		logger.info("爬取的申请人名称---" + name);

		response = Jsoup.connect(url).timeout(30000).execute();
		Map<String, String> cookies = response.cookies();

		int index = new Random().nextInt(2);
		// if (index == 0) {
		// data.put("j_username", "18810412927");
		// data.put("j_password", "yyz2016...");
		// } else {
		data.put("j_username", "15244665829");
		data.put("j_password", "314159265358");
		// }
		logger.info(name + "---登录账户名:" + data.get("j_username"));
		logger.info(name + "---账户密码:" + data.get("j_password"));

		url = "http://www.tmkoo.com/j_spring_security_check";

		data.put("_spring_security_remember_me", "on");
		response = SpiderJsoupUtil.getContent(url, data, cookies, Method.POST,
				null);
		cookies = response.cookies();
		data.clear();
		data.put("pageNo", "1");
		data.put("l", "");
		data.put("gjfls", "0");
		data.put("gjfl", "0");
		data.put("st", "4");
		data.put("searchKey", name);
		url = "http://www.tmkoo.com/search!ajaxSearch.php";
		response = SpiderJsoupUtil.getContent(url, data, cookies, Method.POST,
				null);

		Document doc = response.parse();
		String success = doc.select("body").text();

		String[] splits = success.split(":");
		if (splits.length == 3) {
			success = splits[1];
			// 通常来说，这种情况下，就代表失败了
		} else {
			throw new Exception("查询次数超标!");
		}
		data.put("l", success);
		url = SEARCH_URL;

		logger.info(Thread.currentThread().getName() + "---下载" + name
				+ "第一页文档!");
		response = SpiderJsoupUtil.getContent(url, data, response.cookies(),
				Method.GET, null);

		// 这是第一页面的文档
		Document document = response.parse();
		processAfter(url, cookies, data, document);
	}

	public static void processAfter(String url, Map<String, String> cookies,
			Map<String, String> data, Document doc) throws Exception {
		List<Document> docList = new ArrayList<Document>();
		docList.add(doc);
		Elements results = doc.select(".result");
		if (null != results && results.size() != 0) {
			// 先记录数目
			Element result = results.first();
			Element pager = result.select(".pager").first();
			String pages = pager.select("span").first().text();
			int allPages = Integer.parseInt(pages);

			// 计算出总页数
			Integer pagesNum = null;
			Elements allPagesElements = pager.select(".prevPage");
			if (null != allPagesElements && allPagesElements.size() != 0) {
				for (Element innerElement : allPagesElements) {
					if (innerElement.hasAttr("href")
							&& innerElement.attr("title").equals("尾页")) {
						String href = innerElement.attr("href");
						pagesNum = getPagesNum(href);
						break;
					}
				}
			}

			// 计算出总页数
			if (null != pagesNum) {
				for (int i = 2; i < pagesNum + 1; i++) {
					try {
						Document document = getDocument(SEARCH_URL, cookies,
								data, i + "");
						docList.add(document);

					} catch (Exception e) {
						logger.info("下载第" + i + "页面文档的时候出现异常--"
								+ e.getMessage());
					}
				}
			}

			if (null != docList && docList.size() != 0) {
				processAllDocs(docList, cookies);
			}
		}
	}

	/**
	 * 
	 * @description:根据pages去下载每一页
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月14日 下午6:30:26
	 */
	public static Document getDocument(String url, Map<String, String> cookies,
			Map<String, String> data, String page) throws Exception {
		data.put("pageNo", page);
		Document doc = SpiderJsoupUtil.getContent(url, data, cookies,
				Method.GET, null).parse();
		return doc;
	}

	/**
	 * 
	 * @description:将下载到的Doc文档，全部进行处理
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @throws IOException
	 * @time:2017年6月14日 下午5:51:45
	 */
	public static void processAllDocs(List<Document> docList,
			Map<String, String> cookies) throws IOException, Exception {

		for (Document doc : docList) {
			Elements elements = doc.select(".result > ul");
			if (null != elements && elements.size() != 0) {
				Elements lis = elements.first().select("li");
				for (Element li : lis) {

					// 因为其中会出现广告，因此要过滤掉，必须出现注册号才可以
					if (li.text().contains("注册号")) {
						// 每一个都是一个搜索结果，需要加以处理

						String uuid = UUID.randomUUID().toString();

						processSingleResult(li, uuid, cookies);
					}
				}

			}
		}
	}

	/**
	 * 
	 * @description:处理获取到的单个结果
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @throws IOException
	 * @time:2017年7月6日 下午3:15:45
	 */
	public static void processSingleResult(Element li, String uuid,
			Map<String, String> cookies) throws IOException, Exception {
		Elements aList = li.select("a");

		BrandDetail detail = new BrandDetail();

		detail.setUuid(uuid);

		// 商标名称
		detail.setBrand_name(li.select(".tmname").text().trim());

		// 商标注册号
		detail.setApply_num(li.select(".regno").text().trim()
				.replace("注册号:", ""));

		// 国际分类
		detail.setClass_num(li.select(".intcls").text().trim().replace("第", "")
				.replace("类", ""));

		// 申请人中文名称
		detail.setApplicant_name_cn(li.select(".highlight").text().trim());

		// 申请日期
		detail.setApply_date(li.select(".csrq").get(0).text().trim()
				.replace("申请日期：", ""));
		// 初审公告期号
		detail.setInit_notice_num(li.select(".cs").first().text().trim()
				.replace("初审公告期号：", ""));
		// 初审公告日期
		detail.setInit_notice_date(li.select(".csrq").get(1).text().trim()
				.replace("初审公告日期：", ""));
		// 注册公告日期
		detail.setRegister_notice_date(li.select(".csrq").last().text().trim()
				.replace("注册公告日期：", ""));
		// 注册公告期号
		detail.setRegister_notice_num(li.select(".cs").last().text().trim()
				.replace("注册公告期号：", ""));
		// 类似群
		detail.setLike_groups(aList.last().text().trim());

		detail.setAdd_time(new Date());

		String detailUrl = ROOT_URL + aList.last().attr("href");

		// 爬取详情
		Document doc = SpiderJsoupUtil.getContent(detailUrl, null, cookies,
				Method.GET, null).parse();

		// 分析该详情，并进行数据插入
		processDetailDoc(doc, detail);

	}

	/**
	 * 
	 * @description:解析具体详情，完成数据插入
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月6日 下午3:25:48
	 */
	public static void processDetailDoc(Document doc, BrandDetail detail) {

		BrandProceduresDAO brandProceduresDAO = ctx
				.getBean(BrandProceduresDAO.class);
		BrandDetailDAO brandDetailDAO = ctx.getBean(BrandDetailDAO.class);

		// 设置商品/服务列表
		Elements contents = doc.select(".goods");
		if (contents.size() != 0) {
			Element content = contents.first();
			Elements trs = content.select("tr");

			StringBuilder sb = new StringBuilder();

			for (Element tr : trs) {
				if (null != tr.select("td") && tr.select("td").size() == 3) {
					Elements tds = tr.select("td");
					sb.append(tds.last().text() + ";");
				}
			}
			detail.setService_content(sb.toString().substring(0,
					sb.toString().length() - 1));
		}

		Elements tds = doc.select("td");
		for (int i = 0; i < tds.size(); i++) {
			Element td = tds.get(i);
			if (td.text().contains("申请人地址(英文)：")) {
				detail.setApplicant_name_en(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("申请人地址(中文)：")) {
				Element innerTd = tds.get(i + 1);
				String aText = innerTd.select("a").first().attr("href");
				aText = aText.substring(aText.indexOf("val('") + 5,
						aText.indexOf("');"));
				detail.setApplicant_address_cn(aText);
				continue;
			}
			if (td.text().contains("申请人地址（英文）")) {
				detail.setApplicant_address_en(tds.get(i + 1).text().trim());
				continue;
			}

			if (td.text().contains("是否共有商标")) {
				detail.setIf_common_brand(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("商标类型")) {
				detail.setBrand_type(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("专用权期限：")) {
				detail.setEx_right_period(tds.get(i + 1).text().trim());
				continue;
			}
			if (td.text().contains("国际注册日期：")) {
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

			if (td.text().contains("商标状态")) {
				Element status = tds.get(i + 1);
				Elements sblcDates = status.select(".sblcDate");
				Elements sblcTitles = status.select(".sblcTitle");

				for (int j = 0; j < sblcDates.size(); j++) {
					BrandProcedures procedure = new BrandProcedures();
					procedure.setAdd_time(new Date());
					procedure.setProcedure_date(sblcDates.get(j).text().trim());
					procedure.setBrand_name(detail.getBrand_name());
					procedure.setBusiness_name("");
					procedure.setClass_num(detail.getClass_num());
					procedure.setConclusion("");
					procedure.setRegister_num(detail.getApply_num());
					procedure.setSection_name(sblcTitles.get(j).text().trim());
					procedure.setUuid(detail.getUuid());

					brandProceduresDAO.add(procedure);
					logger.info("插入数据---商标流程：" + JSON.toJSONString(procedure));
				}
			}
		}
		detail.setProcedures("");
		detail.setStatus_icon("");
		// detail完善，进行数据插入
		logger.info("插入数据---商标详情：" + JSON.toJSONString(detail));
		brandDetailDAO.add(detail);

	}

	/**
	 *
	 * @description:从尾页中解析出总共有多少页
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月14日 下午2:14:33
	 */
	public static Integer getPagesNum(String href) {
		int index1 = href.indexOf("(");
		int index2 = href.indexOf(")");

		String subString = href.substring(index1 + 1, index2);
		return Integer.parseInt(subString);
	}

	/**
	 * 
	 * @description:将输出的异常转换为字符串
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月7日 上午10:27:00
	 */
	public static String transfer(Exception e) throws Exception {
		// e.printStackTrace();
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		e.printStackTrace(new PrintWriter(buf, true));
		String expMessage = buf.toString();
		buf.close();
		if (StringUtils.isNotEmpty(expMessage)) {
			return expMessage;
		} else {
			return null;
		}
	}

}
