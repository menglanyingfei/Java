package com.lxy.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 生命周期
 * @author 15072
 *
 */
public class ServletDemo1 implements Servlet {

	/**
	 * Servlet实例被创建后，调用init方法进行初始化
	 * 不是服务器一启动时，实例被创建；第一次访问的时候，实例才被创建
	 * 只被调用一次
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init...");
	}
	
	/**
	 * 有一次请求，调用一次service方法
	 */
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("service...");
	}
	
	/**
	 * 服务器关闭，手动移除；Servlet实例被销毁
	 * 只调用一次
	 */
	public void destroy() {
		System.out.println("destroy...");
	}

	
	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
	
}
