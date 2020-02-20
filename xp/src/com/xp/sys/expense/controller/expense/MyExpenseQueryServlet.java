package com.xp.sys.expense.controller.expense;

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
import com.xp.pojo.Expemse;
import com.xp.pojo.Users;
import com.xp.sys.expense.serivce.IExpemseService;
import com.xp.sys.expense.serivce.imp.ExpemseServiceImpl;
import com.xp.utils.DateFormat;

@WebServlet("/expense/queryMyExpenses")
public class MyExpenseQueryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IExpemseService expemseService = new ExpemseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取对象当前用户对象
		Users users = (Users)req.getSession().getAttribute("users");
		
		//创建时间的容器
		ConvertUtils.register(new DateFormat(), Date.class);
		Expemse expemse = RequestBeanUtils.requestToSimpleBean(req, Expemse.class);
		expemse.setUsersId(users.getUsersId());
		
		try {
			List<Expemse> queryExpemse = expemseService.queryExpemse(expemse);
			req.setAttribute("queryExpemse", queryExpemse);
			req.setAttribute("expense", expemse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/view/expense/expense/expense_mylist.jsp").forward(req, resp);
	}
	
}
