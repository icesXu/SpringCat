/**
 * 
 */
package com.chen.yuzhao.spiders.brands;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONObject;
import com.chen.product.dao.EntNameDAO;

/**
 * @author yuzhao.yang
 * @description:从数据库中获取数据
 * @time:2017年7月5日 下午4:41:51
 */
public class DataGain {

	private static Logger logger = LogManager.getLogger("mylog");

	private static Jedis redisUtil = new Jedis("192.168.10.35", 6379);

	private static RoseAppContext ctx;
	static {
		ctx = new RoseAppContext();
	}

	/**
	 * 
	 * @description:按照固定的begin和length，取出数据
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年7月5日 下午5:02:24
	 */
	public static List<String> getNameList(long begin, long length) {
		List<String> list = new ArrayList<String>();

		EntNameDAO entNameDAO = ctx.getBean(EntNameDAO.class);

		// list = entNameDAO.getNameList(begin, length);

		logger.info("数据总数:" + entNameDAO.count());

		return list;
	}

	public static void main(String[] args) {
		initQueue();
		// System.out.println(redisUtil.rpop("test-brands"));
		// getNameList(0, 100);
	}

	public static void initQueue() {

		// 启用十个线程，往redis里插入数据，后续直接从redis进行获取，比较方便

		List<Long> list = new ArrayList<Long>();
		for (long i = 0; i < 460251; i++) {
			list.add(i);
		}

		ExecutorService pool = Executors.newSingleThreadExecutor();

		for (final Long ele : list) {

			pool.execute(new Runnable() {

				@Override
				public void run() {
					initRedisQueue(ele);
				}
			});
		}

	}

	public static void initRedisQueue(long begin) {
		EntNameDAO entNameDAO = ctx.getBean(EntNameDAO.class);

		List<String> nameList = entNameDAO.getNameList(begin, 100);

		for (String name : nameList) {
			JSONObject json = new JSONObject();
			json.put("entname", name);
			// 0代表未开始
			json.put("flag", "0");
			// 1代表爬取失败
			// 2代表爬取成功

			String key = "test-" + begin;

			logger.info(Thread.currentThread().getName() + "插入数据--" + key
					+ "---" + json.toJSONString());

			// redisUtil.lpush("test-brands", json.toJSONString());

			redisUtil.lpush("brandsTest", json.toJSONString());

		}
	}
}
