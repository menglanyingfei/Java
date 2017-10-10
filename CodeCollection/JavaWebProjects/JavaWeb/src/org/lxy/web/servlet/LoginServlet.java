package org.lxy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.domain.User;
import org.lxy.exception.LoginException;
import org.lxy.service.UserService;

/**
 * @author menglanyingfei
 * @date 2017-4-27
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 得到用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 2. 封装属性到JavaBean
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		
		// 3. 调用service中登录方法
		UserService service = new UserService();
		
		User existUser = null;
		
		try {
			existUser = service.login(user);
			
			if (existUser == null) { // 代表用户名或密码, 存储错误信息在request域, 请求转发到login.jsp
				request.setAttribute("login.message", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			} else {
				request.getSession().setAttribute("user", existUser);
				response.sendRedirect(request.getContextPath() + "/success.jsp");
				return;
			}
		} catch (LoginException e) {
			e.printStackTrace();
			request.getSession().setAttribute("login.message", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/success.jsp");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}




