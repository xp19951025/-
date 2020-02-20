package com.xp.sys.expense.serivce;

import java.util.List;

import com.xp.pojo.AuditRecnd;
import com.xp.pojo.Expemse;


public interface IExpemseService {

	//添加数据
	boolean addExpemse(Expemse expemse)throws Exception;
	boolean addExpemseDetail(Expemse expemse)throws Exception;
	
	//修改
	boolean updateExpemse(Expemse expemse)throws Exception;
	
	//删除
	boolean delExpemse(Expemse expemse)throws Exception;	
	
	//查询所有
	List<Expemse> queryExpemse(Expemse expemse)throws Exception;
	//查询审核明细
	List<AuditRecnd> queryExpemseDetail(Integer id)throws Exception;
}
