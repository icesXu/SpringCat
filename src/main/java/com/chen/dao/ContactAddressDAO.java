/**
 * 
 */
package com.chen.dao;

import com.chen.model.ContactAddress;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午3:15:29
 */
@DAO
public interface ContactAddressDAO {
	String table = "yiliangcuishou_contactoraddr_copy";

	@ReturnGeneratedKeys
	@SQL("insert into yiliangcuishou_contactoraddr_copy (UUID,contactorName,companyName,relation,address,isResolved,addressType,isAddrEffect,sendLetterTimes,visitTimes,ADD_TIME) values (:t.UUID,:t.contactorName,:t.companyName,:t.relation,:t.address,:t.isResolved,:t.addressType,:t.isAddrEffect,:t.sendLetterTimes,:t.visitTimes,:t.ADD_TIME)")
	public int insertTest(@SQLParam("t") ContactAddress test);

}
