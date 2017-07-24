package com.chen.yyzyhc.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.jade.annotation.ShardBy;
import com.chen.yyzyhc.model.MyTest;
import java.util.List;

@DAO
public interface MyTestDAO {

	@ReturnGeneratedKeys
	@SQL("insert into test1 (msg) values (:t.msg)")
	public int add(@SQLParam("t") MyTest test);

	@SQL("select msg from test1 LIMIT :begin,:length")
	public List<String> getLists(@SQLParam("begin") long begin,
			@SQLParam("length") long length);
}