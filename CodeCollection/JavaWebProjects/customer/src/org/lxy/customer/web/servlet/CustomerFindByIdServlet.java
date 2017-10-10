package org.lxy.customer.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.customer.domain.Customer;
import org.lxy.customer.service.CustomerService;

/**
 * @author menglanyingfei
 * @date 2017-5-11
 */
public class CustomerFindByIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3469583447252529545L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 	1. 得到要查询的id
		String id = request.getParameter("id");
		
		// 2. 调用service中根据id查询的方法
		CustomerService service = new CustomerService();
		
		try {
			Customer c = service.findById(id);
			
			request.setAttribute("c", c);
			request.getRequestDispatcher("/customerInfo.jsp").forward(request, response);
			
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("根据id查询失败");
			return;
		}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
