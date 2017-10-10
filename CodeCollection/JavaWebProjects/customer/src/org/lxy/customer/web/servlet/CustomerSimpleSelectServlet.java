package org.lxy.customer.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.customer.domain.Customer;
import org.lxy.customer.service.CustomerService;

/**
 * @author menglanyingfei
 * @date 2017-5-13
 */
public class CustomerSimpleSelectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6024947559826102451L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		// 1. 得到请求参数
		// 字段名称
		String field = request.getParameter("field");
		// 字段值
		String msg = request.getParameter("msg");
		
		// 2. 调用service完成查询操作
		CustomerService service = new CustomerService();
		
		try {
			List<Customer> cs = service.simpleSelect(field, msg);
			// 存储转发
			request.setAttribute("cs", cs);
			request.getRequestDispatcher("/showCustomer.jsp").forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("条件查询失败");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
