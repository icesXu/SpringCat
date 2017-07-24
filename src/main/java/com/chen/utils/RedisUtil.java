/**
 * 
 */
package com.chen.utils;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月9日 下午3:29:05
 */
public class RedisUtil {

	/**
	 * 
	 * @description:括号里的参数为是否是测试的
	 * @author:yuzhao.yang
	 * @param:
	 * @return:
	 * @time:2017年6月9日 下午3:32:16
	 */
	public static JedisCluster init(boolean test) {
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		if (!test) {
			HostAndPort hp = new HostAndPort("192.168.20.22", 6379);
			HostAndPort hp1 = new HostAndPort("192.168.20.23", 6379);
			HostAndPort hp2 = new HostAndPort("192.168.20.24", 6379);
			HostAndPort hp3 = new HostAndPort("192.168.20.25", 6379);
			HostAndPort hp4 = new HostAndPort("192.168.20.26", 6379);
			HostAndPort hp5 = new HostAndPort("192.168.20.27", 6379);
			nodes.add(hp);
			nodes.add(hp1);
			nodes.add(hp2);
			nodes.add(hp3);
			nodes.add(hp4);
			nodes.add(hp5);
		} else {
			HostAndPort hp = new HostAndPort("192.168.10.122", 6379);
			HostAndPort hp1 = new HostAndPort("192.168.10.123", 6379);
			HostAndPort hp2 = new HostAndPort("192.168.10.124", 6379);
			HostAndPort hp3 = new HostAndPort("192.168.10.125", 6379);
			HostAndPort hp4 = new HostAndPort("192.168.10.126", 6379);
			HostAndPort hp5 = new HostAndPort("192.168.10.127", 6379);
			nodes.add(hp);
			nodes.add(hp1);
			nodes.add(hp2);
			nodes.add(hp3);
			nodes.add(hp4);
			nodes.add(hp5);
		}
		JedisCluster jedisCluster = new JedisCluster(nodes);
		return jedisCluster;
	}
}
