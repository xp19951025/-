package com.xp.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.xp.pojo.Users;

@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		
		Users users = (Users)request.getSession().getAttribute("users");
		
		String requestURI = request.getRequestURI();
		if(users != null){
			arg2.doFilter(arg0, arg1);
		}else if(requestURI.contains("doLogin")){
			arg2.doFilter(arg0, arg1);
		}else if(requestURI.contains("resource")){
			arg2.doFilter(arg0, arg1);
		}else if(requestURI.contains("login.jsp")){
			arg2.doFilter(arg0, arg1);
		}else{
			request.getRequestDispatcher("/view/login_info.jsp").forward(request, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
