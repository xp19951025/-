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
import com.xp.sys.expense.serivce.IExpemseService;
import com.xp.sys.expense.serivce.imp.ExpemseServiceImpl;
import com.xp.utils.DateFormat;

@WebServlet("/expense/queryExpenses")
public class ExpenseQueryServlet extends HttpServlet{
	
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
		//查询
		//查询条件获取数据
		//创建时间的容器
		ConvertUtils.register(new DateFormat(), Date.class);
		Expemse expemse = RequestBeanUtils.requestToSimpleBean(req, Expemse.class);
		
		//service
		try {
			List<Expemse> queryExpemse = expemseService.queryExpemse(expemse);
			req.setAttribute("expenseList",queryExpemse);
			req.setAttribute("expense",expemse);
			req.getRequestDispatcher("/view/expense/expense/expense_list.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
