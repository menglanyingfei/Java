package com.lxy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置Servlet启动时加载
 * @author 15072
 *
 */
public class ServletDemo4 extends HttpServlet {

	/**
	 * 默认的情况下第一次访问的时候init被调用
	 */
	public void init() throws ServletException {
		System.out.println("init...");
		// 初始化数据库的链接
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 写的内容
		// 获取表单输入的内容
		// 自己逻辑，通过名称查询数据库，把张三的姓名查到了
		// 把张三返回浏览器
		System.out.println("doGet...");
		response.getWriter().write("hello demo4...");		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
