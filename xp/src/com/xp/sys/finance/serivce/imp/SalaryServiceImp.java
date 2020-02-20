package com.xp.sys.finance.serivce.imp;

import java.util.List;

import com.xp.pojo.Salary;
import com.xp.pojo.SalaryChar;
import com.xp.sys.finance.dao.SalaryDao;
import com.xp.sys.finance.dao.imp.SalaryDaoImp;
import com.xp.sys.finance.serivce.SalaryService;

public class SalaryServiceImp implements SalaryService {

	SalaryDao salaryDao = new SalaryDaoImp();
	@Override
	public boolean addSalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		return salaryDao.addSalary(salary);
	}

	@Override
	public List<Salary> querySalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		return salaryDao.querySalary(salary);
	}

	@Override
	public List<SalaryChar> querySalaryChar() throws Exception {
		// TODO Auto-generated method stub
		return salaryDao.querySalaryChar();
	}

}
