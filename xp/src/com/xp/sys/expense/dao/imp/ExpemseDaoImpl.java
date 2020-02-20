package com.xp.sys.expense.dao.imp;

import static com.xp.utils.StaticCode.AUOT_STAY_CODE;
import static com.xp.utils.StaticCode.MANAGEER_AUOT_ON_CODE_NUMBER;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xp.pojo.AuditRecnd;
import com.xp.pojo.Expemse;
import com.xp.sys.expense.dao.IExpemseDao;
import com.xp.utils.C3p0Util;
import com.xp.utils.StaticCode;
import com.xp.utils.ThisAsser;

public class ExpemseDaoImpl implements IExpemseDao{

	@Override
	public boolean addExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = C3p0Util.getConn();
		int update = 0;
		try{
			conn.setAutoCommit(false);
			QueryRunner queryRunner = new QueryRunner();
			//添加报销单
			String sql = "insert into t_expemse (usersId,expemseName,expemseDesc,expemseToltel,expemseDate,expemseState)  values(?,?,?,?,now(),?)";
			update = queryRunner.update(conn,sql,expemse.getUsersId(),expemse.getExpemseName(),expemse.getExpemseDesc(),expemse.getExpemseToltel(),expemse.getExpemseState());
				
				//获取报销单的编号
			String sqlId = "Select last_insert_id()";
				//如果Long报错，就使用BigInteger
			BigInteger queryId = queryRunner.query(conn, sqlId, new ScalarHandler<BigInteger>());
			int intValue = queryId.intValue();
			
			//添加报销明细
			Integer[] costIds = expemse.getCostIds();
			String[] detailDescs = expemse.getDetailDescs();
			String[] detailMoneys = expemse.getDetailMoneys();
						
			String sql_detail = "insert into t_expemse_detail (expemseId,costId,detailDesc,detailMoney)  values (?,?,?,?)";
			for (int i = 0; i < costIds.length; i++) {
				update = queryRunner.update(conn,sql_detail,intValue,costIds[i],detailDescs[i],detailMoneys[i]);
				
			}
			conn.commit();
			conn.setAutoCommit(true);			
			
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();			
		}
		return ThisAsser.getIsNumber(update, "报销单添加失败");		
	}

	@Override
	public boolean updateExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		//事务
		Connection conn = C3p0Util.getConn();
		int update = 0;
		try{
			conn.setAutoCommit(false);
			QueryRunner queryRunner = new QueryRunner();
			
			//修改报销单
			String sql = "update t_expemse set expemseName=?, expemseDesc=?, expemseToltel=?, expemseState=? where expemseId=? ";
			update += queryRunner.update(conn,sql,expemse.getExpemseName(),expemse.getExpemseDesc(),expemse.getExpemseToltel(),expemse.getExpemseState(),expemse.getExpemseId());		
			
			
			//修改报销明细
				//删除该报销单的明细
			String sql1 = "delete from t_expemse_detail where expemseId=? ";
			queryRunner.update(conn,sql1, expemse.getExpemseId());
					
				//添加新的报销明细
			String sql2 = "insert into t_expemse_detail (expemseId,costId,detailDesc,detailMoney)  values (?,?,?,?)";
			
			Integer[] costIds = expemse.getCostIds();
			String[] detailDescs = expemse.getDetailDescs();
			String[] detailMoneys = expemse.getDetailMoneys();
			
			for (int i = 0; i < costIds.length; i++) {
				update = queryRunner.update(conn,sql2,expemse.getExpemseId(),costIds[i],detailDescs[i],detailMoneys[i]);
				
			}
			
			conn.commit();
			conn.setAutoCommit(true);			
			
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();			
		}
		
		return ThisAsser.getIsNumber(update, "报销单修改失败");
	}

	@Override
	public boolean delExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Expemse> queryExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(" SELECT * FROM t_expemse te,t_users tu where te.usersId=tu.usersId and tu.usersMark = ?");
		
		ArrayList<Object> arrayList = new ArrayList<>();
		
		arrayList.add(StaticCode.OBJ_CODE);	
		
		//加条件
		if(expemse.getUsersName() != null && !"".equals(expemse.getUsersName())){
			sql.append(" and tu.usersName like ?");
			arrayList.add("%"+ expemse.getUsersName() +"%");
		}
		if(expemse.getStartDate() != null && !"".equals(expemse.getStartDate())){
			sql.append(" and te.expemseDate >= ?");
			arrayList.add(expemse.getStartDate());
		}
		if(expemse.getEndDate() != null && !"".equals(expemse.getEndDate())){
			sql.append("  and te.expemseDate <= ?");
			arrayList.add(expemse.getEndDate());
		}
		if(expemse.getExpemseName() != null && !"".equals(expemse.getExpemseName())){
			sql.append("  and te.expemseName like ?");
			arrayList.add("%"+ expemse.getExpemseName() +"%");
		}
		if(expemse.getExpemseMark() != null && !"".equals(expemse.getExpemseMark())){
			if(expemse.getExpemseMark() != AUOT_STAY_CODE ){
				sql.append("  and te.expemseMark = ?");			
				arrayList.add(expemse.getExpemseMark());
			}
			
			if(expemse.getExpemseMark() == AUOT_STAY_CODE ){
				sql.append("  and te.expemseMark != ?");			
				arrayList.add(expemse.getExpemseMark());
			}			
		}
		if(expemse.getExpemseMark2() == MANAGEER_AUOT_ON_CODE_NUMBER ){
			sql.append("  and te.expemseMark != ?");			
			arrayList.add(expemse.getExpemseMark2());
		}
		
		//添加
		//查询某个报销单的详情
		if(expemse.getExpemseId() != null && expemse.getExpemseId()!=0){
			sql.append("  and te.expemseId = ?");
			arrayList.add(expemse.getExpemseId());
		}
		//查询个人报销单
		if(expemse.getUsersId() != null && expemse.getUsersId()!=0){
			sql.append("  and te.usersId = ?");
			arrayList.add(expemse.getUsersId());
		}
		
		
		return C3p0Util.queryList(sql.toString(), Expemse.class, arrayList.toArray());
	}

	@Override
	public List<AuditRecnd> queryExpemseDetail(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_audit_recnd tar,t_users tu where tar.usersId = tu.usersId and tar.expemseId = ?";
				
		return C3p0Util.queryList(sql, AuditRecnd.class, id);
	}

	@Override
	public boolean addExpemseDetail(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		//事务
		Connection conn = C3p0Util.getConn();
		int update = 0;
		try{
			conn.setAutoCommit(false);
			QueryRunner queryRunner = new QueryRunner();
		
			//修改报销单的状态码
			String sql = "update t_expemse set expemseMark=? where expemseId=? ";
			update += queryRunner.update(conn,sql,expemse.getExpemseMark(),expemse.getExpemseId());
							
			//添加审核记录明细
			String sql1 = "insert into t_audit_recnd (expemseId,usersId,auditState,auditSugg,auditDate) "
					+ "  values(?,?,?,?,now())";
					
			update += queryRunner.update(conn,sql1,expemse.getExpemseId(),expemse.getUsersId(),expemse.getExpemseMark(),expemse.getAuditSugg());
						
			conn.commit();
			conn.setAutoCommit(true);			
			
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();			
		}
		return ThisAsser.getIsNumber(update, "报销单审核失败");			
	}

}
