package com.xp.sys.system.dao;

import java.util.List;

import com.xp.pojo.Cost;
import com.xp.pojo.ExpemseDetail;

public interface ICostDao {

	//添加数据
	boolean addCost(Cost cost)throws Exception;
	
	//删除
	boolean updateCost(Cost cost)throws Exception;
	
	//修改
	boolean delCost(Cost cost)throws Exception;
	
	//查询所有
	List<Cost> queryCost(Cost cost)throws Exception;
	List<ExpemseDetail> queryCostById(Integer id)throws Exception;
}
