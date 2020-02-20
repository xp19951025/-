package com.xp.sys.expense.serivce.imp;

import static com.xp.utils.StaticCode.AUOT_STAY_CODE;
import static com.xp.utils.StaticCode.FINAN_AUOT_OK_CODE;
import static com.xp.utils.StaticCode.FINAN_AUOT_OK_CODE_NUMBER;
import static com.xp.utils.StaticCode.FINAN_AUOT_ON_CODE;
import static com.xp.utils.StaticCode.FINAN_AUOT_ON_CODE_NUMBER;
import static com.xp.utils.StaticCode.MANAGEER_AUOT_OK_CODE;
import static com.xp.utils.StaticCode.MANAGEER_AUOT_OK_CODE_NUMBER;
import static com.xp.utils.StaticCode.MANAGEER_AUOT_ON_CODE;
import static com.xp.utils.StaticCode.MANAGEER_AUOT_ON_CODE_NUMBER;
import static com.xp.utils.StaticCode.MANAGEER_AUOT_STAY_CODE;

import java.util.ArrayList;
import java.util.List;

import com.xp.pojo.AuditRecnd;
import com.xp.pojo.Expemse;
import com.xp.sys.expense.dao.IExpemseDao;
import com.xp.sys.expense.dao.imp.ExpemseDaoImpl;
import com.xp.sys.expense.serivce.IExpemseService;

public class ExpemseServiceImpl implements IExpemseService {

	IExpemseDao dao = new ExpemseDaoImpl();
	@Override
	public boolean addExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		return dao.addExpemse(expemse);
	}

	@Override
	public boolean updateExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateExpemse(expemse);
	}

	@Override
	public boolean delExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Expemse> queryExpemse(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		List<Expemse> queryExpemse = dao.queryExpemse(expemse);
		ArrayList<Expemse> arrayList = new ArrayList<>();
		
		for(Expemse expemse2 : queryExpemse){
			switch (expemse2.getExpemseMark()) {
			case FINAN_AUOT_ON_CODE_NUMBER:
				expemse2.setExpemseMark("<button type='button' class='btn btn-warning'>"+FINAN_AUOT_ON_CODE+"</button>");
				expemse2.setUpdateUrl("<a href='expense/expenseUpdate?expemseId="+expemse2.getExpemseId()+"' class='btn btn-info' role='button'>修改 </a>");
				break;
				
			case FINAN_AUOT_OK_CODE_NUMBER:
				expemse2.setExpemseMark("<button type='button' class='btn btn-primary'>"+FINAN_AUOT_OK_CODE+"</button>");
				expemse2.setUpdateUrl("<a href='expense/showExpenseDetail?expemseId="+expemse2.getExpemseId()+"' class='btn btn-link' role='button'>查询详情 </a>");
				break;
				
			case MANAGEER_AUOT_ON_CODE_NUMBER:
				expemse2.setExpemseMark("<button type='button' class='btn btn-danger'>"+MANAGEER_AUOT_ON_CODE+"</button>");
				expemse2.setUpdateUrl("<a href='expense/expenseUpdate?expemseId="+expemse2.getExpemseId()+"' class='btn btn-info' role='button'>修改 </a>");
				break;
				
			case MANAGEER_AUOT_OK_CODE_NUMBER:
				expemse2.setExpemseMark("<button type='button' class='btn btn-success'>"+MANAGEER_AUOT_OK_CODE+"</button>");
				expemse2.setUpdateUrl("<a href='expense/showExpenseDetail?expemseId="+expemse2.getExpemseId()+"' class='btn btn-link' role='button'>查询详情 </a>");
				break;
				
			case AUOT_STAY_CODE:
				expemse2.setExpemseMark("<button type='button' class='btn btn-default'>"+MANAGEER_AUOT_STAY_CODE+"</button>");
				expemse2.setUpdateUrl("<a href='expense/expenseUpdate?expemseId="+expemse2.getExpemseId()+"' class='btn btn-info' role='button'>修改 </a>");
				break;

			default:
				break;
			}
			
			arrayList.add(expemse2);
		}
		
		return arrayList;
	}

	@Override
	public List<AuditRecnd> queryExpemseDetail(Integer id) throws Exception {
		// TODO Auto-generated method stub
		List<AuditRecnd> queryExpemseDetail = dao.queryExpemseDetail(id);
		ArrayList<AuditRecnd> arrayList = new ArrayList<>();
		for(AuditRecnd auditRecnd : queryExpemseDetail){
			switch (auditRecnd.getAuditState()) {
			case FINAN_AUOT_ON_CODE_NUMBER:
				auditRecnd.setAuditState("<button type='button' class='btn btn-warning'>"+FINAN_AUOT_ON_CODE+"</button>");
				break;
				
			case FINAN_AUOT_OK_CODE_NUMBER:
				auditRecnd.setAuditState("<button type='button' class='btn btn-primary'>"+FINAN_AUOT_OK_CODE+"</button>");
				break;
				
			case MANAGEER_AUOT_ON_CODE_NUMBER:
				auditRecnd.setAuditState("<button type='button' class='btn btn-danger'>"+MANAGEER_AUOT_ON_CODE+"</button>");
				break;
				
			case MANAGEER_AUOT_OK_CODE_NUMBER:
				auditRecnd.setAuditState("<button type='button' class='btn btn-success'>"+MANAGEER_AUOT_OK_CODE+"</button>");
				break;
				
			case AUOT_STAY_CODE:
				auditRecnd.setAuditState("<button type='button' class='btn btn-default'>"+MANAGEER_AUOT_STAY_CODE+"</button>");
				break;

			default:
				break;				
			
		}
			arrayList.add(auditRecnd);
		}
		return arrayList;
	}

	@Override
	public boolean addExpemseDetail(Expemse expemse) throws Exception {
		// TODO Auto-generated method stub
		return dao.addExpemseDetail(expemse);
	}

}
