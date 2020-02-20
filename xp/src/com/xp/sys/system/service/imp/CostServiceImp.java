package com.xp.sys.system.service.imp;

import static com.xp.utils.ThisAsser.getIsNotNull;

import java.util.List;

import com.xp.pojo.Cost;
import com.xp.pojo.ExpemseDetail;
import com.xp.sys.system.dao.ICostDao;
import com.xp.sys.system.dao.imp.CostDaoImp;
import com.xp.sys.system.service.ICostService;

public class CostServiceImp implements ICostService {

	ICostDao costDao = new CostDaoImp();
	@Override
	public boolean addCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		//断言
		getIsNotNull(cost.getCostName(), "费用名称不能为空！");
		return costDao.addCost(cost);
	}

	@Override
	public boolean updateCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		
		return costDao.updateCost(cost);
	}

	@Override
	public boolean delCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		return costDao.delCost(cost);
	}

	@Override
	public List<Cost> queryCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		return costDao.queryCost(cost);
	}

	@Override
	public List<ExpemseDetail> queryCostById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
		return costDao.queryCostById(id);
	}

}
