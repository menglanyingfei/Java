package com.lxy.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户机的内容
 * @author 15072
 *
 */
public class RequestServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 获取IP
		String ip = request.getRemoteAddr();
		// 获取请求方式
		String method = request.getMethod();
		// 获取虚拟路径
		String path = request.getContextPath();
		
		System.out.println("IP地址：" + ip);
		System.out.println("请求方式：" + method);
		System.out.println("虚拟路径名称：" + path);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
