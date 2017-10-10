package org.lxy.customer.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.customer.service.CustomerService;

/**
 * @author menglanyingfei
 * @date 2017-5-11
 */
public class CustomerDelByIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -929663944063054194L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1. 得到要删除的id
		String id = request.getParameter("id");
		
		// 2. 调用service中根据id删除的方法
		CustomerService service = new CustomerService();
		
		try {
			service.delById(id);
			
			// 跳转到CustomerFindAllServlet, 就是要重新查询一次
			response.sendRedirect(request.getContextPath() + "/findAll");
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("删除失败");
			return;
		}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
