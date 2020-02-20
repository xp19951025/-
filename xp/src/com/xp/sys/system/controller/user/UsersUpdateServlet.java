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

@WebServlet("/system/updateUser")
public class UsersUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUsersService usersSerivce = new UsersServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		//获取修改数据的id
		Users users = RequestBeanUtils.requestToBean(req, Users.class);
		//通过id进行查询并返回给jsp
		try {
			List<Users> queryUsers = usersSerivce.queryUsers(users);
			Users users2 = queryUsers.get(0);
			req.setAttribute("user", users2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("/view/system/user/userinfo_list.jsp");
		}
		
		
		req.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Users users = RequestBeanUtils.requestToBean(req, Users.class);
		
		try {
			usersSerivce.updateUsers(users);
			req.setAttribute("tip", "修改成功");
			req.setAttribute("user", users);
			req.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "修改失败");
			req.getRequestDispatcher("/view/system/user/userinfo_update.jsp").forward(req, resp);
		}
		
	}

}
