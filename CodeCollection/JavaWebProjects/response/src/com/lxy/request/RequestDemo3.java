package com.lxy.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向和转发
 * @author 15072
 *
 */
public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// request域设置内容
		request.setAttribute("name", "莉莉");
		
		// 完成重定向的工作（客户端绝对路径）
//		response.sendRedirect("/response/request4");
		
		// 转发（路径 服务器端的绝对路径）
		request.getRequestDispatcher("/request4").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
