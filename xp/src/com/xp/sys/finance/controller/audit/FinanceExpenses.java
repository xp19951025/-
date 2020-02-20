package com.xp.sys.finance.controller.audit;

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
import com.xp.sys.system.service.ICostService;
import com.xp.sys.system.service.imp.CostServiceImp;
import com.xp.utils.DateFormat;
import com.xp.utils.StaticCode;

@WebServlet("/finance/financeExpenses")
public class FinanceExpenses extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService costSerivce = new CostServiceImp();
	IExpemseService expemseService = new ExpemseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//创建时间的容器
		ConvertUtils.register(new DateFormat(), Date.class);
		Expemse expemse = RequestBeanUtils.requestToSimpleBean(req, Expemse.class);
		
		//service
		expemse.setExpemseMark(StaticCode.AUOT_STAY_CODE);
		expemse.setExpemseMark2(StaticCode.MANAGEER_AUOT_ON_CODE_NUMBER);
		try {
			List<Expemse> queryExpemse = expemseService.queryExpemse(expemse);
			req.setAttribute("expenseList",queryExpemse);
			req.setAttribute("expense",expemse);
			req.getRequestDispatcher("/view/finance/financAaudit/financeaudit_list.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
