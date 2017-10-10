package org.lxy.web.servlet.demo5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class BookDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4871216691470624846L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("book delete...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
