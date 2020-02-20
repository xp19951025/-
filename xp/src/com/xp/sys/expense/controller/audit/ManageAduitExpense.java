package com.xp.sys.expense.controller.audit;

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

@WebServlet("/expense/manageAduitExpense")
public class ManageAduitExpense extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService serivce = new CostServiceImp();
	IExpemseService expemseService = new ExpemseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		req.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Expemse expemse = RequestBeanUtils.requestToBean(req, Expemse.class);
		try {
			expemseService.addExpemseDetail(expemse);
			req.setAttribute("tip", "审核成功");
			req.setAttribute("expense", expemse);
			//回显数据	
			
			//获取明细
			List<ExpemseDetail> detailList = serivce.queryCostById(expemse.getExpemseId());
			req.setAttribute("detailList", detailList);
			
			//获取审核明细
			List<AuditRecnd> queryExpemseDetail = expemseService.queryExpemseDetail(expemse.getExpemseId());
			req.setAttribute("list", queryExpemseDetail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "审核失败");
			req.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/view/expense/managerAudit/expense_audit.jsp").forward(req, resp);
	}

}
