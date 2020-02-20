package com.xp.sys.system.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xp.sys.system.service.IUsersService;
import com.xp.sys.system.service.imp.UsersServiceImp;

import net.sf.json.JSONObject;

@WebServlet("/system/checkUser")
public class CheckUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6342955433910948428L;
	
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
		String parameter = req.getParameter("userAccount");
						
		//Serive
		try {
			boolean checkUsersAcc = usersSerivce.checkUsersAcc(parameter);
						
			JSONObject jsonObject = new JSONObject();
			
			if(checkUsersAcc){					
				jsonObject.put("tip", "该用户可用！");
				jsonObject.put("state", 0);
			}else{							
				jsonObject.put("tip", "该用户不可用！");
				jsonObject.put("state", 1);
			}
			
			//返回JSON
			PrintWriter writer = resp.getWriter();
			
			writer.println(jsonObject);
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			JSONObject jsonObject = new JSONObject();
			
				jsonObject.put("tip", "该用户不可用！");
				jsonObject.put("state", 1);
						
			//返回JSON
			PrintWriter writer = resp.getWriter();
			
			writer.println(jsonObject);
			writer.flush();
			writer.close();
		}
		
		
		
	}

	
}
