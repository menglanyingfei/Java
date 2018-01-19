package com.wtu.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");//处理响应编码
		req.setCharacterEncoding("UTF-8");
		/*
		 * 通过反射来实现，
		 * 1获取方法名
		 * 2.获取当前类Class对象  this.getClass();
		 * 3.获取与该方法名对应的Method对象   getMethod(String name, Class<?>... parameterTypes) 
			String name:方法名
			Class<?>... parameterTypes：方法的参数类型   HttpServletRequest.class  HttpServletResponse.class
		 * 4.通过Method对象来调用invoke(this,req,resp)    就相当于调用了   methodName()
		 *   假设获取的methodName  为  addCustomer
		 */
		//获取请求方法 ,在请求参数中  附带一个额外的参数   ：该参数是一个方法名
		String methodName = req.getParameter("method");
		//获取当前类的Class对象
		Class cl = this.getClass();
		//获取与methodName 对应的Method对象、
		Method method = null;
		try {
			method = cl.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("不能获取"+methodName+"的Method对象");
		} 
		
		String path = null;
		try {
			//通过method对象来调用invoke() 方法 该方法的返回值就是执行methodName()返回值
			//this.methodName(req,resp);
			path = (String)method.invoke(this, req, resp);//采用反射调用
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if (path == null) {
			System.out.println("什么也不做！！！");
			return ;
		}
		/*
		 * 在此处转发或者重定向
		 */
		String[] arr = path.split(":");
		/*
		 * 判断arr[0]如果是redirect 那么久重定向，如果是forward  那么久转发  如果是null 那就什么都不做
		 * 如果是其他那么久抛个异常，提示不能进行此操作
		 */
		if("redirect".equals(arr[0])){
			resp.sendRedirect(req.getContextPath()+arr[1]);
		}else if("forward".equals(arr[0])){
			req.getRequestDispatcher(arr[1]).forward(req, resp);
		}else {
			throw new RuntimeException("操作有误，只能转发或者重定向，或者什么也不做");
		}
	}
}
