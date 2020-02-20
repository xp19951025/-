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
import com.xp.pojo.Expemse;
import com.xp.pojo.ExpemseDetail;
import com.xp.sys.expense.serivce.IExpemseService;
import com.xp.sys.expense.serivce.imp.ExpemseServiceImpl;
import com.xp.sys.system.service.ICostService;
import com.xp.sys.system.service.imp.CostServiceImp;

@WebServlet("/expense/showExpenseDetail")
public class ExpenseShowQueryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService serivce = new CostServiceImp();
	IExpemseService expemseService = new ExpemseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		Expemse expemse = RequestBeanUtils.requestToBean(req, Expemse.class);
		
		//service
		try {
			List<Expemse> queryExpemse = expemseService.queryExpemse(expemse);
			Expemse expemse2 = queryExpemse.get(0);
			req.setAttribute("expense", expemse2);
			
			//获取明细
			List<ExpemseDetail> detailList = serivce.queryCostById(expemse2.getExpemseId());
			req.setAttribute("detailList", detailList);
			
			//获取审核明细
			List<AuditRecnd> queryExpemseDetail = expemseService.queryExpemseDetail(expemse2.getExpemseId());
			req.setAttribute("list", queryExpemseDetail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/view/expense/expense/expense_show.jsp").forward(req, resp);
	}
	
}
