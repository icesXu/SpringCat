/**
 * 
 */
package com.chen.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.chen.model.ContactPhone;
import com.chen.model.UrgeRecord;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午3:14:45
 */
@DAO
public interface ContactPhoneDAO {
	String table = "yiliangcuishou_contactorphone_copy";

	@ReturnGeneratedKeys
	@SQL("insert into yiliangcuishou_contactorphone_copy (UUID,contactorName,companyName,relation,phoneNo,phoneType,phoneLocation,isEffect,callTimes,smsTimes,detectMessage,detectDate,ADD_TIME) values (:t.UUID,:t.contactorName,:t.companyName,:t.relation,:t.phoneNo,:t.phoneType,:t.phoneLocation,:t.isEffect,:t.callTimes,:t.smsTimes,:t.detectMessage,:t.detectDate,:t.ADD_TIME)")
	public int insertTest(@SQLParam("t") ContactPhone test);
}
