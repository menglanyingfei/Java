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
public class BookUpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6084724813300596044L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("book update...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
