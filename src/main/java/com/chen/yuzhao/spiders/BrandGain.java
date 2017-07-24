/**
 * 
 */
package com.chen.yuzhao.spiders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chen.utils.WebDriverUtil;
import com.chen.yuzhao.model.BrandDetail;
import com.chen.yuzhao.model.BrandProcedures;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年7月4日 下午5:44:54
 */
public class BrandGain {

	private static final Integer THREAD_NUM = 5;

	public static void main(String[] args) {

		// 自己思考的整体步骤：
		// 1：从数据库里获取数据
		// 2：制作消息队列。
		// 3：每天监控消息队列的数量，并且随时告诉另外一个地方进行存储
		// 4：错误和是否错误的判断
		process();

	}

	/**
	 * 
	 * @description:主体的处理逻辑
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月4日 下午5:54:29
	 */
	public static void process() {

		List<String> list = new ArrayList<String>();
		int size = list.size();

		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
		for (int i = 0; i < size; i++) {
			final String name = list.get(i);
			pool.execute(new Runnable() {
				final String applicantName = name;

				@Override
				public void run() {
					gain(applicantName);
				}
			});
		}
	}

	/**
	 * 
	 * @description:根据
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月4日 下午6:09:32
	 */
	public static void gain(String name) {
		WebDriver driver = WebDriverUtil.getPhantomjsDriver();

		try {

		} catch (Exception e) {

		} finally {
			driver.quit();
		}

	}

	/**
	 * 
	 * @description:对于一个商标，先获取其列表页
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月4日 下午5:51:50
	 */
	public static List<String> getBrandList(String name) {
		List<String> list = new ArrayList<String>();

		// 先查询到第一页，记录总页数

		// 遍历每一页。

		return list;
	}

	/**
	 * 
	 * @description:用于商标流程的解析
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月4日 下午6:26:34
	 */
	public static JSONArray parseProcedures(Document doc, String uuid) {
		JSONArray jsa = new JSONArray();
		Elements ztwz = doc.select(".ztwz");
		if (null != ztwz && ztwz.size() != 0) {
			Element div = ztwz.first();
			Elements trs = div.select("tr");

			if (null != trs && trs.size() != 0) {
				for (Element tr : trs) {

					BrandProcedures procedure = new BrandProcedures();

					procedure.setBusiness_name(tr.select("td").get(0).text()
							.trim());
					procedure.setSection_name(tr.select("td").get(1).text()
							.trim());
					procedure.setConclusion(tr.select("td").get(2).text()
							.trim());
					procedure.setProcedure_date(tr.select("td").get(3).text()
							.trim());

					// 将该数据进行插入

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
	public static JSONObject parseDetails(Document doc, String uuid) {
		JSONObject json = new JSONObject();
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
		return json;
	}
}
