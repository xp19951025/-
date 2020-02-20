package com.xp.sys.expense.controller.expense;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.AuditRecnd;
import com.xp.pojo.Cost;
import com.xp.pojo.Expemse;
import com.xp.pojo.ExpemseDetail;
import com.xp.sys.expense.serivce.IExpemseService;
import com.xp.sys.expense.serivce.imp.ExpemseServiceImpl;
import com.xp.sys.system.service.ICostService;
import com.xp.sys.system.service.imp.CostServiceImp;

@WebServlet("/expense/expenseUpdate")
public class ExpenseUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService costSerivce = new CostServiceImp();
	IExpemseService expemseService = new ExpemseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取参数
		Expemse expemse = RequestBeanUtils.requestToBean(req, Expemse.class);
		try {
			List<Expemse> queryExpemse = expemseService.queryExpemse(expemse);
			Expemse expemse2 = queryExpemse.get(0);
			req.setAttribute("expense", expemse2);
			
			//费用明细
			List<Cost> queryCost = costSerivce.queryCost(new Cost());
			req.setAttribute("costList", queryCost);
			
			//获取报销单的明细
			List<ExpemseDetail> detailList = costSerivce.queryCostById(expemse2.getExpemseId());
			req.setAttribute("detailList", detailList);
			
			//获取审核明细
			List<AuditRecnd> queryExpemseDetail = expemseService.queryExpemseDetail(expemse2.getExpemseId());
			req.setAttribute("list", queryExpemseDetail);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/view/expense/expense/expense_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Expemse expemse = RequestBeanUtils.requestToBean(req, Expemse.class);
		//service
		try {
			expemseService.updateExpemse(expemse);
			req.setAttribute("tip", "报销单修改成功");
			
			//回显数据
			List<Expemse> queryExpemse = expemseService.queryExpemse(expemse);
			Expemse expemse2 = queryExpemse.get(0);
			req.setAttribute("expense", expemse2);
			
			//费用明细
			List<Cost> queryCost = costSerivce.queryCost(new Cost());
			req.setAttribute("costList", queryCost);
			
			//获取报销单的明细
			List<ExpemseDetail> detailList = costSerivce.queryCostById(expemse2.getExpemseId());
			req.setAttribute("detailList", detailList);
			
			//获取审核明细
			List<AuditRecnd> queryExpemseDetail = expemseService.queryExpemseDetail(expemse2.getExpemseId());
			req.setAttribute("list", queryExpemseDetail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "报销单修改失败");
			req.getRequestDispatcher("/view/expense/expense/expense_update.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/view/expense/expense/expense_update.jsp").forward(req, resp);
	}

}
