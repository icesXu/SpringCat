/**
 * 
 */
package com.chen.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.chen.model.UrgeRecord;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年6月8日 下午3:16:54
 */
@DAO
public interface UrgeRecordDAO {
	String table = "yiliangcuishou_urgerecord_copy";

	// 只需要插入语句即可
	@ReturnGeneratedKeys
	@SQL("insert into yiliangcuishou_urgerecord_copy (UUID,urgeUserName,contactorName,ifUrgePromise,phoneNum,urgeTime,nextUrgeTime,urgeType,callStatus,urgeStatus,callType,urgeDesc,ADD_TIME) values (:t.UUID,:t.urgeUserName,:t.contactorName,:t.ifUrgePromise,:t.phoneNum,:t.urgeTime,:t.nextUrgeTime,:t.urgeType,:t.callStatus,:t.urgeStatus,:t.callType,:t.urgeDesc,:t.ADD_TIME)")
	public int insertTest(@SQLParam("t") UrgeRecord test);
}
