package org.lxy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.exception.AccountException;
import org.lxy.service.AccountService;

/**
 * @author menglanyingfei
 * @date 2017-5-4
 */
public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 7039984088901066862L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 1. 得到请求参数
		String accountIn = request.getParameter("accountin");
		String accountOut = request.getParameter("accountout");
		
		double money = Double.parseDouble(request.getParameter("money"));
		
		// 2. 调用service, 完成汇款操作
		AccountService service = new AccountService();
		
		try {
			service.account(accountIn, accountOut, money);
			response.getWriter().write("转账成功");
			return;
		} catch (AccountException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}













