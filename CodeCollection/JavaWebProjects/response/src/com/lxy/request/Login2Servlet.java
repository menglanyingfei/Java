package com.lxy.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用转发到登陆页面
 * @author 15072
 *
 */
public class Login2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 先获取用户输入的内容（request对象）
		 * 判断姓名和密码是否都是admin，如果有一个不是，重定向到登陆页面，如果都是，就登陆成功
		 */
		// 获取用户输入的内容
		String username = request.getParameter("username");
		// 获取密码
		String password = request.getParameter("password");
		// 判断
		if ("admin".equals(username) && "admin".equals(password)) {
			// 登陆成功
			// 重定向到登陆页面
//			response.getWriter().write("success");
			response.sendRedirect("/response/response/refresh.html");
		} else {
			// 在request域存入内容
			request.setAttribute("msg", "用户名或者密码错误！");
			
			
			// 重定向到登陆页面
			// 设置302的状态码
//			response.setStatus(302);
			// 设置地址
//			response.setHeader("location", "/response/response/login.html");
			
			// 重定向
//			response.sendRedirect("/response/response/login.html");
			
			
			request.getRequestDispatcher("/request/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
