/**
 * 
 */
package com.chen.product.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author yuzhao.yang
 * @description:用于从报表中获取数据
 * @time:2017年7月5日 下午4:13:27
 */
@DAO
public interface EntNameDAO {
	@SQL("SELECT ENTNAME FROM entname_201703_copy LIMIT :begin,:length")
	public List<String> getNameList(@SQLParam("begin") long begin,
			@SQLParam("length") long length);

	@ReturnGeneratedKeys
	@SQL("SELECT COUNT(1) FROM entname_201703_copy")
	public long count();
}
