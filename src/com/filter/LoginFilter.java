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
 * ��¼����������֤����ʱ�Ƿ��ǵ�¼״̬
 * ��¼�����з��ʣ������ض��򵽵�¼ҳ��
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��ʼ����¼��֤������");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		System.out.println("����URI:"+uri);
		if(uri.endsWith("userLogin.action")){
			chain.doFilter(servletRequest, servletResponse);
		}else{
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
		System.out.println("���ٵ�¼��֤������");
	}

}
