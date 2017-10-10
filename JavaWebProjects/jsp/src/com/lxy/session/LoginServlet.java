package com.lxy.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验验证码
 * @author 15072
 *
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -533615878304809629L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决post请求中文乱码的问题
		request.setCharacterEncoding("UTF-8");
		
		// 获取session中验证码
		String code1 = (String) request.getSession().getAttribute("code");
		// 获取表单中的验证码
		String code2 = request.getParameter("code");
		// 是否相同
		if (code2 != null && code1.equals(code2)) {
			response.getWriter().write("success");
		} else {
			// 如果不相同，返回错误的信息
			// 转发
			request.setAttribute("msg", "验证码输入错误");
			request.getRequestDispatcher("/session/login.jsp").forward(request, response);
		}
//		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
