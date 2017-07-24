/**
 * 
 */
package com.chen.yuzhao.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.chen.yuzhao.model.First;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月9日 上午11:21:46
 */
@DAO
public interface FirstDAO {
	@ReturnGeneratedKeys
	@SQL("insert into yuzhao_test (id_number,msg) values (:t.id_number,:t.msg)")
	public int addFirst(@SQLParam("t") First first);

}
