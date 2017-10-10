package com.lxy.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统计网站的访问次数
 * @author 15072
 *
 */
public class CountServlet extends HttpServlet {

	/**
	 * 实例被创建，调用init方法进行初始化
	 * 在域对象存入一个变量，赋值为0
	 */
	public void init() throws ServletException {
		// 获取ServletContext对象
		getServletContext().setAttribute("count", 0);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取ServletContext对象
		ServletContext context = getServletContext();
		// 获取count的值，自增
		Integer count = (Integer) context.getAttribute("count");
		// 存入到域对象中
		context.setAttribute("count", ++count);
		
		// 向页面输出内容
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h3>欢迎访问！！！</h3>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
