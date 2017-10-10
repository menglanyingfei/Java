package com.lxy.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 extends GenericServlet {

	public void init() throws ServletException {		
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init...");
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

	}

}
