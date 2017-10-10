package com.lxy.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示网站的访问次数
 * @author 15072
 *
 */
public class ShowServlet extends HttpServlet {

	/**
	 * 获取网站的访问次数，输出到客户端
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer count = (Integer) getServletContext().getAttribute("count");
		// 向页面输出
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h2>该网站一共被访问了" + count + "次</h2>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
