package com.xp.sys.system.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.xp.pojo.Users;
import com.xp.sys.system.service.IUsersService;
import com.xp.sys.system.service.imp.UsersServiceImp;

@WebServlet("/system/queryUsers")
public class UsersQueryList extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUsersService usersSerivce = new UsersServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Users users = RequestBeanUtils.requestToBean(req, Users.class);
		
		try {
			List<Users> queryUsers = usersSerivce.queryUsers(users);
			req.setAttribute("usersList", queryUsers);
			req.setAttribute("user", users);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		req.getRequestDispatcher("/view/system/user/userinfo_list.jsp").forward(req, resp);
	}

	
}
