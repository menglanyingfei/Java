package org.lxy.customer.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.customer.domain.PageBean;
import org.lxy.customer.service.CustomerService;

/**
 * @author menglanyingfei
 * @date 2017-5-15
 */
public class CustomerFindAllByPageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9051345849275765597L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//System.out.println(request.getRemoteAddr());
		// 127.0.0.1
		
		// 1. 默认访问第一页
		int pageNum = 1;
		
		String _pageNum = request.getParameter("pageNum");
		if (_pageNum != null) {
			pageNum = Integer.parseInt(_pageNum);
		}
		
		// 2. 每页条数, 人为定义
		int currentPage = 2;
		
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage != null) {
			currentPage = Integer.parseInt(_currentPage);
		}
		
		// 3. 调用service, 完成查询当前页数据操作
		CustomerService service = new CustomerService();
		
		try {
			PageBean pb = service.findByPage(pageNum, currentPage);
			
			// 4. 将数据存储到request域, 请求转到页面展示
			request.setAttribute("pb", pb);
			
			request.getRequestDispatcher("/showCustomerByPage.jsp").forward(request, response);
			
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
