package com.xp.sys.finance.controller.salary;

import java.io.IOException;
import java.io.PrintWriter;
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

import net.sf.json.JSONObject;

@WebServlet("/finance/salaryQuery")
public class SalaryQueryOneServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUsersService usersServiceImp = new UsersServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取值（Id）
		Users user = RequestBeanUtils.requestToBean(req, Users.class);
		
		//Service
		try {
			List<Users> queryUsers = usersServiceImp.queryUsers(user);
			Users users = queryUsers.get(0);
			Float usersSalsy = users.getUsersSalsy();
			
			//返回json
			JSONObject jsonObject = new JSONObject();					
			jsonObject.put("userSalary", usersSalsy);				
			
			//返回JSON
			PrintWriter writer = resp.getWriter();
			
			writer.println(jsonObject);
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
