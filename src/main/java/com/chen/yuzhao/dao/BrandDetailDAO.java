package com.chen.yuzhao.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.jade.annotation.ShardBy;
import com.chen.yuzhao.model.BrandDetail;
import java.util.List;

@DAO
public interface BrandDetailDAO {

	@ReturnGeneratedKeys
	@SQL("insert into brand_details (status_icon,init_notice_num,brand_name,if_common_brand,register_notice_date,latter_point_date,service_content,apply_date,inter_register_date,brand_type,init_notice_date,ex_right_period,procedures,applicant_address_en,priority_date,applicant_address_cn,register_notice_num,like_groups,apply_num,brand_form,class_num,applicant_name_cn,applicant_name_en,add_time,uuid,agent_name) values (:t.status_icon,:t.init_notice_num,:t.brand_name,:t.if_common_brand,:t.register_notice_date,:t.latter_point_date,:t.service_content,:t.apply_date,:t.inter_register_date,:t.brand_type,:t.init_notice_date,:t.ex_right_period,:t.procedures,:t.applicant_address_en,:t.priority_date,:t.applicant_address_cn,:t.register_notice_num,:t.like_groups,:t.apply_num,:t.brand_form,:t.class_num,:t.applicant_name_cn,:t.applicant_name_en,:t.add_time,:t.uuid,:t.agent_name)")
	public int add(@SQLParam("t") BrandDetail test);
}