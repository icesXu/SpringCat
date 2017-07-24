/**
 * 
 */
package com.chen.yuzhao.spiders;

import java.io.File;
import java.util.List;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

import redis.clients.jedis.Jedis;
import cn.wanghaomiao.xpath.exception.NoSuchFunctionException;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;

import com.alibaba.fastjson.JSON;
import com.chen.product.dao.EntNameDAO;
import com.chen.yuzhao.dao.GovernDataDAO;
import com.chen.yuzhao.model.GovernData;
import com.chen.yuzhao.parsers.Parser;
import com.chen.yyzyhc.dao.MyTestDAO;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午1:48:52
 */
public class DataDeal {
	private static WebDriver driver;

	private static Jedis redisUtil = new Jedis("192.168.10.35", 6379);

	private static Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args) throws Exception {
		RoseAppContext ctx = new RoseAppContext();

		EntNameDAO entNameDAO = ctx.getBean(EntNameDAO.class);

		List<String> list = entNameDAO.getNameList(0, 100);

		for (String ele : list) {
			redisUtil.lpush("localBrands", ele);
		}

	}

	public void process() throws Exception {

		RoseAppContext ctx = new RoseAppContext();

		GovernDataDAO governDataDAO = ctx.getBean(GovernDataDAO.class);

		File file = new File("C:/Users/YYZYHC/Desktop/AllCities");
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File innerFile : files) {
				Document parse = Jsoup.parse(innerFile, "UTF-8");
				Element tbody = parse.select("tbody").first();

				String name = innerFile.getName();
				name = name.substring(0, name.indexOf("."));

				List<Object> list = new Parser().parse(tbody, GovernData.class);
				for (Object object : list) {
					GovernData data = (GovernData) object;
					System.out.println(JSON.toJSONString(data));
				}
			}
		}
	}
}
