package com.xp.sys.finance.controller.salary;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Salary;
import com.xp.pojo.Users;
import com.xp.sys.finance.serivce.SalaryService;
import com.xp.sys.finance.serivce.imp.SalaryServiceImp;
import com.xp.sys.system.service.IUsersService;
import com.xp.sys.system.service.imp.UsersServiceImp;
import com.xp.utils.DateFormat;

@WebServlet("/finance/addSalary")
public class AddSalaryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IUsersService usersServiceImp = new UsersServiceImp();
	SalaryService salaryService = new SalaryServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Service Users
		try {
			List<Users> queryUsers = usersServiceImp.queryUsers(new Users());
			req.setAttribute("userList", queryUsers);
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		//创建时间的容器
		ConvertUtils.register(new DateFormat("yyyy-MM"), Date.class);
		Salary salary = RequestBeanUtils.requestToSimpleBean(req, Salary.class);
		
		//service
		try {
			salaryService.addSalary(salary);
			req.setAttribute("tip", "薪资发放成功");

			//第二次发放
			List<Users> queryUsers = usersServiceImp.queryUsers(new Users());
			req.setAttribute("userList", queryUsers);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "薪资发放失败");
			req.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/view/finance/salary/salarypayment_add.jsp").forward(req, resp);
		
	}

	
}
