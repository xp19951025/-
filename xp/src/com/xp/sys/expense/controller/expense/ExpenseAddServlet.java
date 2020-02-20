package com.xp.sys.expense.controller.expense;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Cost;
import com.xp.pojo.Expemse;
import com.xp.sys.expense.serivce.IExpemseService;
import com.xp.sys.expense.serivce.imp.ExpemseServiceImpl;
import com.xp.sys.system.service.ICostService;
import com.xp.sys.system.service.imp.CostServiceImp;

@WebServlet("/expense/addExpense")
public class ExpenseAddServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService costSerivce = new CostServiceImp();
	IExpemseService expemseService = new ExpemseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//查询费用
		try {
			List<Cost> queryCost = costSerivce.queryCost(new Cost());
			req.setAttribute("costList", queryCost);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Expemse expemse = RequestBeanUtils.requestToBean(req, Expemse.class);
		
		//serivce
		try {
			expemseService.addExpemse(expemse);
			req.setAttribute("tip", "报销单添加成功");
			//查询费用
			List<Cost> queryCost = costSerivce.queryCost(new Cost());
			req.setAttribute("costList", queryCost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "报销单添加失败");
			req.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/view/expense/expense/expense_add.jsp").forward(req, resp);
	}

}
