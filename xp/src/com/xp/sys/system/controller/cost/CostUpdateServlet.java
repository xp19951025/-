package com.xp.sys.system.controller.cost;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Cost;
import com.xp.sys.system.service.ICostService;
import com.xp.sys.system.service.imp.CostServiceImp;

@WebServlet("/system/updateCost")
public class CostUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICostService costSerivce = new CostServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//查询
		//获取数据
		Cost cost = RequestBeanUtils.requestToBean(req, Cost.class);
		try {
			List<Cost> queryCost = costSerivce.queryCost(cost);
			Cost cost2 = queryCost.get(0);
			req.setAttribute("cost", cost2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("/system/queryCosts");
		}
		req.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cost cost = RequestBeanUtils.requestToBean(req, Cost.class);
		try {
			costSerivce.updateCost(cost);
			req.setAttribute("tip", "修改成功");
			req.setAttribute("cost", cost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(req, resp);
			req.setAttribute("tip", "修改失败");
		}
		req.getRequestDispatcher("/view/system/cost/cost_update.jsp").forward(req, resp);
	}

}
