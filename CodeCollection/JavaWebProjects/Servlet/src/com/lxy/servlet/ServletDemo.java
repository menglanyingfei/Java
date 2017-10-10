package com.lxy.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 实现Servlet接口，重写5个方法
 * 在web.xml进行配置
 * @author 15072
 *
 */
public class ServletDemo implements Servlet {

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.getWriter().write("hello demo...");
	}
	
	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		
	}

	

}
