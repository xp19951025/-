package com.xp.sys.system.dao.imp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.xp.pojo.Cost;
import com.xp.pojo.ExpemseDetail;
import com.xp.sys.system.dao.ICostDao;
import com.xp.utils.C3p0Util;
import com.xp.utils.StaticCode;
import com.xp.utils.ThisAsser;

public class CostDaoImp implements ICostDao {

	@Override
	public boolean addCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		//添加数据
		String sql="insert into  t_cost  (costName,costIdDesc) "
				+"  values (?,?)";
		int update = C3p0Util.update(sql, cost.getCostName(), cost.getCostIdDesc());
		
		return ThisAsser.getIsNumber(update, "费用添加失败");
	}

	@Override
	public boolean updateCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update t_cost set costName = ?, costIdDesc = ? where costId = ?";
		int update = C3p0Util.update(sql, cost.getCostName(),cost.getCostIdDesc(),cost.getCostId());
				
		return ThisAsser.getIsNumber(update, "费用修改失败");
	}

	@Override
	public boolean delCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = C3p0Util.getConn();
		int update = 0;		
		try{
			conn.setAutoCommit(false);
			
			String sql = "update t_cost set costIdMark = ? where costId = ?";
			QueryRunner queryRunner = new QueryRunner();
			Integer[] ids = cost.getIds();
			
			for(int i = 0; i < ids.length; i++){
				update = queryRunner.update(conn, sql, StaticCode.EXIT_CODE, ids[i]);
				
			}
			
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		return ThisAsser.getIsNumber(update, "费用信息删除失败");
	}

	@Override
	public List<Cost> queryCost(Cost cost) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT * from t_cost where costIdMark = ? ");
		ArrayList<Object> list = new ArrayList<>();
		list.add(StaticCode.OBJ_CODE);
		
		if(cost.getCostId()!= null && cost.getCostId()!= 0){
			sql.append(" and costId = ? ");
			list.add(cost.getCostId());
		}
		if(cost.getCostName() != null && !"".equals(cost.getCostName()) ){
			sql.append(" and costName like ? ");//模糊查询	
			list.add("%"+cost.getCostName()+"%");
		}
		
		return C3p0Util.queryList(sql.toString(), Cost.class, list.toArray());
	}

	@Override
	public List<ExpemseDetail> queryCostById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_expemse_detail ted , t_cost tc  where tc.costId = ted.costId and ted.expemseId=?";
		
		return C3p0Util.queryList(sql, ExpemseDetail.class, id);
	}

}
