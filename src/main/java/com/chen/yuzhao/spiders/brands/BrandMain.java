/**
 * 
 */
package com.chen.yuzhao.spiders.brands;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import net.paoding.rose.scanning.context.RoseAppContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chen.utils.PropertiesUtil;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年7月5日 下午4:47:49
 */
public class BrandMain {

	/**
	 * 使用本地的redis队列，或者不构建队列
	 */
	public static Jedis redisUtil = new Jedis("192.168.10.35", 6379);
	public static RoseAppContext ctx = new RoseAppContext();

	private static final Logger logger = LogManager.getLogger("mylog");

	public static int thread_num = 10;

	static {
		String threads = PropertiesUtil.get("thread_num", "");
		// 线程数量的控制
		if (StringUtils.isNoneBlank(threads)) {
			thread_num = Integer.parseInt(threads);
		}
	}

	private static final String ENT_NAME_KEY = "entname";

	public static void main(String[] args) throws Exception {
		// 尝试直接生成一个4600万的队列，大概需要多长时间，倒是不需要太多时间，但是内存占用非常严重。
		// 初始化URL队列
		// 无需多进程，单进程即可。
		process();
	}

	/**
	 * 
	 * @description:全系列的处理逻辑
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @throws Exception
	 * @time:2017年7月5日 下午5:51:58
	 */
	public static void process() throws Exception {
		// 每个企业名称去搜索
		logger.info("当前开辟了----" + thread_num + "---个线程!");
		ExecutorService pool = Executors.newFixedThreadPool(thread_num);

		String key = PropertiesUtil.get("singleBrandRedisKey", "");
		String errorQueue = PropertiesUtil.get("brandErrorKey", "");

		final CopyOnWriteArrayList<String> onWriteArrayList = new CopyOnWriteArrayList<String>();
		final AtomicInteger errorSize = new AtomicInteger(0);

		List<String> list = redisUtil.lrange(key, 0, thread_num);

		logger.info("初次获取数据---" + thread_num + "---条！");

		int begin = 0;
		int i = 0;
		while (null != list && list.size() != 0) {
			final CountDownLatch count = new CountDownLatch(thread_num);
			for (final String name : list) {
				pool.execute(new Runnable() {
					@Override
					public void run() {
						JSONObject object = JSON.parseObject(name);

						String title = object.getString("entname");

						logger.info(Thread.currentThread().getName()
								+ "正在处理企业----" + title);
						try {
							SingleBrandProcessByJsoupWithoutLogin
									.process(title);
						} catch (Exception e) {
							// 出现异常，输出
							logger.info(title + transfer(e));

							// 错误量递增
							errorSize.addAndGet(1);
							onWriteArrayList.add(title);
						} finally {
							count.countDown();
							logger.info(Thread.currentThread().getName()
									+ "处理企业----" + title + "成功!");
						}
					}
				});
			}
			count.await();
			begin += thread_num;
			list = redisUtil.lrange(key, begin, begin + thread_num);
			i++;

			// 跑的总量，需要放入redis存储
			logger.info("放入跑的总量----" + begin);
			redisUtil.set("fetchedSize", begin + "");
			logger.info("放入跑的错误量----" + errorSize.intValue());
			redisUtil.set("errorSize", errorSize.intValue() + "");

			// 将错误数据放入新的队列
			if (onWriteArrayList.size() == 0) {
				logger.info("第" + i + "次" + thread_num + "全部成功!!!");
			} else {
				logger.info("第" + i + "次" + thread_num + "失败---"
						+ onWriteArrayList.size() + "条!!!");
				for (String element : onWriteArrayList) {
					redisUtil.lpush(errorQueue, element);
				}
			}
			logger.info("第" + i + "次取出" + thread_num + "条数据!");
		}
	}

	/**
	 * 
	 * @description:将输出的异常转换为字符串
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月7日 上午10:27:00
	 */
	public static String transfer(Exception e) {
		// e.printStackTrace();
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		e.printStackTrace(new PrintWriter(buf, true));
		String expMessage = buf.toString();
		try {
			buf.close();
		} catch (Exception e1) {
		}
		if (StringUtils.isNotEmpty(expMessage)) {
			return expMessage;
		} else {
			return null;
		}
	}
}
