/**
 * 
 */
package com.ccx.credit.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2018年2月12日 下午1:51:00
 */
public class HbaseTest1 {
	static Configuration config = null;
	private Connection connection = null;
	private Table table = null;

	@Before
	public void init() throws Exception {
		config = HBaseConfiguration.create();
		// 配置zookeeper的地址
		config.set("hbase.zookeeper.quorum", "master1ha,master2,master2ha");
		// 配置zookeeper的端口地址
		config.set("hbase.zookeeper.property.clientport", "2181");
		// 创建连接，从连接池内提取连接
		connection = ConnectionFactory.createConnection(config);
		table = connection.getTable(TableName.valueOf("user"));
	}

	/**
	 * 
	 * @description how to create a new table
	 * @author yuzhao.yang
	 * @param
	 * @return
	 * @time 2018年2月12日 下午2:05:36
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void createTable() throws Exception {
		HBaseAdmin admin = new HBaseAdmin(config);
		TableName tableName = TableName.valueOf("test1");
		HTableDescriptor desc = new HTableDescriptor(tableName);
		HColumnDescriptor family1 = new HColumnDescriptor("info1");
		desc.addFamily(family1);
		HColumnDescriptor family2 = new HColumnDescriptor("info2");
		desc.addFamily(family2);
		admin.createTable(desc);
	}

	/**
	 * 
	 * @description how to delete a table
	 * @author yuzhao.yang
	 * @param
	 * @return
	 * @time 2018年2月12日 下午2:08:48
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void deleteTable() throws Exception {
		HBaseAdmin admin = new HBaseAdmin(config);
		admin.disableTable("test1");
		admin.deleteTable("test1");
		admin.close();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void insertData() throws Exception {
		// 第一条是rowkey，必须要写的
		Put put = new Put(Bytes.toBytes("yangyuzhao"));
		put.add(Bytes.toBytes("info1"), Bytes.toBytes("name"),
				Bytes.toBytes("yangyuzhao"));
		put.add(Bytes.toBytes("info1"), Bytes.toBytes("sex"),
				Bytes.toBytes("man"));
		put.add(Bytes.toBytes("info1"), Bytes.toBytes("address"),
				Bytes.toBytes("safasa"));
		table.put(put);
	}
}
