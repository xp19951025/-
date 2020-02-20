package com.xp.sys.system.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Users;
import com.xp.sys.system.service.IUsersService;
import com.xp.sys.system.service.imp.UsersServiceImp;

@WebServlet("/system/deleteUsers")
public class UsersDelServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUsersService usersSerivce = new UsersServiceImp();
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
			usersSerivce.delUsers(user);
			req.setAttribute("info", "用户删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("info", "用户删除失败");
			req.getRequestDispatcher("/system/queryUsers").forward(req, resp);
		}
		req.getRequestDispatcher("/system/queryUsers").forward(req, resp);
		
	}

}
