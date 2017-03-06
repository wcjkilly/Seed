package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器，验证访问时是否是登录状态
 * 登录则运行访问，否则重定向到登录页面
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化登录验证拦截器");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		System.out.println("访问URI:"+uri);
		//如果进行登录操作则不作处理直接放行
		if(uri.endsWith("userLogin.action")){
			chain.doFilter(servletRequest, servletResponse);
		}else{
			//执行非登录操作时验证session中的值是否合法，合法则放行，不合法则重定向到login.jsp
			String username = (String) request.getSession().getAttribute("username");
			if(username!=null && !"".equals(username)){
				chain.doFilter(servletRequest, servletResponse);
			}else{
				response.sendRedirect("login.jsp");
			}
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("销毁登录验证拦截器");
	}

}
