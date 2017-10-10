package com.lxy.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {

	private static final long serialVersionUID = 5499372588077629030L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// session域对象
		HttpSession session = request.getSession();
		session.setAttribute("username", "小李");
		System.out.println(session.getId());
		// 596DFECFD936B4E7109B9D8320440630
		response.sendRedirect("/jsp/session2");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
