package com.xp.sys.finance.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.xp.pojo.Salary;
import com.xp.pojo.SalaryChar;
import com.xp.sys.finance.dao.SalaryDao;
import com.xp.utils.C3p0Util;
import com.xp.utils.StaticCode;
import com.xp.utils.ThisAsser;

public class SalaryDaoImp implements SalaryDao {

	@Override
	public boolean addSalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into t_salary_recond (usersId, salaryMonth, salaryDate, salaryBasic, salaryComm) "
				+ "  values(?,?,now(),?,?)";
		
		int update = C3p0Util.update(sql, salary.getUsersId(),salary.getSalaryMonth(),salary.getSalaryBasic(),salary.getSalaryComm());
		
		return ThisAsser.getIsNumber(update, "薪资发放失败");
	}

	@Override
	public List<Salary> querySalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select tsr.*,tu.usersName from t_users tu,t_salary_recond tsr where tu.usersId=tsr.usersId and tu.usersMark = ?");
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add(StaticCode.OBJ_CODE);
		if(salary.getUsersName() != null && !"".equals(salary.getUsersName())){
			sql.append("  and tu.usersName like ?");
			arrayList.add("%"+ salary.getUsersName() +"%");
		}
		if(salary.getSalaryMonth() != null && !"".equals(salary.getSalaryMonth())){
			sql.append("  and tsr.salaryMonth = ?");
			arrayList.add(salary.getSalaryMonth());
		}
		
		if(salary.getUsersId() != null && salary.getUsersId() != 0 ){
			sql.append("  and tsr.usersId = ?");
			arrayList.add(salary.getUsersId());
		}
		
		
		return C3p0Util.queryList(sql.toString(), Salary.class, arrayList.toArray());
	}

	@Override
	public List<SalaryChar> querySalaryChar() throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT salaryMonth,SUM(salaryBasic) as salaryBasicTotal, SUM(salaryComm) as salaryCommTotal FROM t_salary_recond GROUP BY salaryMonth";
				
		return C3p0Util.queryList(sql, SalaryChar.class);
	}

}
