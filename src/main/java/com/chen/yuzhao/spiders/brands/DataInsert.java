/**
 * 
 */
package com.chen.yuzhao.spiders.brands;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年7月6日 下午12:00:41
 */
public class DataInsert {

	private static Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args) {

		Jedis redisUtil = new Jedis("192.168.10.35", 6379);

		List<String> list = redisUtil.lrange("brandsTest", 0, -1);

		System.out.println(list.size());

	}
}
