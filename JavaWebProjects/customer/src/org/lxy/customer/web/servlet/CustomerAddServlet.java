package org.lxy.customer.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.lxy.customer.domain.Customer;
import org.lxy.customer.service.CustomerService;
import org.lxy.customer.utils.IdUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-13
 */
public class CustomerAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5211219277827234545L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		// 处理请求编码
		request.setCharacterEncoding("utf-8");
		
		// 1. 得到所有请求参数, 封装到JavaBean
		Customer c = new Customer();
		
		// 这是一个日期类型转换器.
		DateConverter dc = new DateConverter();
		dc.setPattern("yyyy-MM-dd");
		
		
		try {
			ConvertUtils.register(dc, java.util.Date.class);
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// 需要手动将id封装到Customer对象
		c.setId(IdUtils.getUUID());
		
		// 2. 调用service完成添加操作
		CustomerService service = new CustomerService();
		try {
			service.add(c);
			// 添加成功
			response.sendRedirect(request.getContextPath() + "/findAll");
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("add.message", "添加客户信息失败");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}















