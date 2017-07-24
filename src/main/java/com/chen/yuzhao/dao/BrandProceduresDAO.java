package com.chen.yuzhao.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.jade.annotation.ShardBy;
import com.chen.yuzhao.model.BrandProcedures;
import java.util.List;

@DAO
public interface BrandProceduresDAO {

	@ReturnGeneratedKeys
	@SQL("insert into brand_procedures (business_name,procedure_date,register_num,class_num,conclusion,add_time,uuid,section_name,brand_name) values (:t.business_name,:t.procedure_date,:t.register_num,:t.class_num,:t.conclusion,:t.add_time,:t.uuid,:t.section_name,:t.brand_name)")
	public int add(@SQLParam("t") BrandProcedures test);
}