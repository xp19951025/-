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

@WebServlet("/system/updateMyUser")
public class ShowUsersServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUsersService usersSerivce = new UsersServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取session的值
		Users user = (Users)req.getSession().getAttribute("users");
		
		try {
			List<Users> queryUsers = usersSerivce.queryUsers(user);
			Users users = queryUsers.get(0);
			req.setAttribute("userInfo", users);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		Users users = RequestBeanUtils.requestToBean(req, Users.class);	
		try {
			usersSerivce.updateUsersInfo(users);
			req.setAttribute("tip", "用户修改成功");
			req.setAttribute("userInfo", users);
			//重新组装session中的当前账号信息
			req.getSession().setAttribute("userInfo", users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("tip", "用户修改失败");
			req.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(req, resp);
		}
		
		req.getRequestDispatcher("/view/system/user/userinfo_show.jsp").forward(req, resp);
	}

}
