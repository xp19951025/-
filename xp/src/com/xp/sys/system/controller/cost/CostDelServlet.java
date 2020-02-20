package com.xp.sys.system.controller.cost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Cost;
import com.xp.sys.system.service.ICostService;
import com.xp.sys.system.service.imp.CostServiceImp;

@WebServlet("/system/deleteCost")
public class CostDelServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService costSerivce = new CostServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Cost cost = RequestBeanUtils.requestToBean(req, Cost.class);
		
		try {
			costSerivce.delCost(cost);
			req.setAttribute("info", "费用删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("info", "费用删除失败");
			req.getRequestDispatcher("/system/queryCosts").forward(req, resp);
		}
		req.getRequestDispatcher("/system/queryCosts").forward(req, resp);
	}

}
