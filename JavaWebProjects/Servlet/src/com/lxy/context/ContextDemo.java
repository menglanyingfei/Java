package com.lxy.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取全局初始化参数
 * @author 15072
 *
 */
public class ContextDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取ServletContext对象
		ServletContext context = getServletContext();
		// 获取初始化参数
		String encoding = context.getInitParameter("encoding");
		System.out.println("编码：" + encoding);
		
		Enumeration<String> e = context.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			// 通过name获取值
			String value = context.getInitParameter(name);	
			System.out.println(name + " : " + value);
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
