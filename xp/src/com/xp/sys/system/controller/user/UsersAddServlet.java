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

@WebServlet("/system/addUser")
public class UsersAddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127076753614890606L;
	
	IUsersService usersServiceImp = new UsersServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取数据 使用工具类来获取
		//注意   HTml form 中的 input 中的name的值 必须和实体类的属性值一致   (默认: get set 去掉 首字母小写）
		Users user = RequestBeanUtils.requestToBean(req, Users.class);
				
		//seriver
		
		try {
			boolean addUsers = usersServiceImp.addUsers(user);
			//添加成功
			if(addUsers){
				req.setAttribute("info", "添加成功");
				req.setAttribute("users", user);
			}else{
				//没有异常但是添加失败
				req.setAttribute("info", "添加失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//添加失败
			req.setAttribute("info", "添加失败");
			req.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(req, resp);
		}
		
		req.getRequestDispatcher("/view/system/user/userinfo_add.jsp").forward(req, resp);
		
	}
}
