package com.chen.yuzhao.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.jade.annotation.ShardBy;

import com.chen.yuzhao.model.ContactAddr;

import java.util.List;

@DAO
public interface ContactAddrDAO {

	@ReturnGeneratedKeys
	@SQL("insert into yiliangcuishou_contactoraddr_copy (contactorName,address,relation,UUID,isAddrEffect,sendLetterTimes,ADD_TIME,addressType,visitTimes,isResolved,companyName) values (:t.contactorName,:t.address,:t.relation,:t.UUID,:t.isAddrEffect,:t.sendLetterTimes,:t.ADD_TIME,:t.addressType,:t.visitTimes,:t.isResolved,:t.companyName")
	public int add(@SQLParam("t") ContactAddr test);
}