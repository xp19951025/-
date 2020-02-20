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

@WebServlet("/system/addCost")
public class CostAddServlet extends HttpServlet{

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
		Cost cost = RequestBeanUtils.requestToBean(req, Cost.class);
		
		try {
			boolean addCost = costSerivce.addCost(cost);
			
			if(addCost){
				req.setAttribute("tip", "费用添加成功");
				req.setAttribute("cost", cost);
			}else{
				req.setAttribute("tip", "费用添加失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "费用添加失败");
			req.getRequestDispatcher("/view/system/cost/cost_add.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/view/system/cost/cost_add.jsp").forward(req, resp);
	}

	
}
