package com.chen.yuzhao.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.jade.annotation.ShardBy;
import com.chen.yuzhao.model.GovernData;
import java.util.List;

@DAO
public interface GovernDataDAO {

	@ReturnGeneratedKeys
	@SQL("insert into stats_gov_data (region,y2011,y2010,y2009,pointer,y2006,y2015,y2014,y2008,y2013,y2007,y2012) values (:t.region,:t.y2011,:t.y2010,:t.y2009,:t.pointer,:t.y2006,:t.y2015,:t.y2014,:t.y2008,:t.y2013,:t.y2007,:t.y2012)")
	public int add(@SQLParam("t") GovernData test);
}