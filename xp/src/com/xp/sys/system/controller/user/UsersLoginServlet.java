package com.xp.sys.system.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Menu;
import com.xp.pojo.SalaryChar;
import com.xp.pojo.Users;
import com.xp.sys.finance.serivce.SalaryService;
import com.xp.sys.finance.serivce.imp.SalaryServiceImp;
import com.xp.sys.system.service.IUsersService;
import com.xp.sys.system.service.imp.UsersServiceImp;

@WebServlet("/system/doLogin")
public class UsersLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 883227026983853902L;
	IUsersService usersSerivce = new UsersServiceImp();
	SalaryService salaryService = new SalaryServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Users user = RequestBeanUtils.requestToBean(req, Users.class);
				
		//serivce
		try {
			Users doLoginUsers = usersSerivce.doLoginUsers(user);
			req.getSession().setAttribute("users", doLoginUsers);
			
			//显示权限菜单
			List<Menu> queryMenu = usersSerivce.queryMenu(doLoginUsers.getRoleId());
			req.getSession().setAttribute("menuList",queryMenu);
						
			//调用数据图形报表
			List<SalaryChar> querySalaryChar = salaryService.querySalaryChar();
			req.getSession().setAttribute("salaryChar", querySalaryChar);
			
			req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			req.setAttribute("info", e.getMessage());
			req.setAttribute("user", user);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}	
		
	}

	
}
