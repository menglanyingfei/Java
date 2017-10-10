package org.lxy.web.servlet.demo4;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.domain.User;
import org.lxy.service.UserService;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8412248427308664924L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// 1. 得到请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2. 登录
		UserService service = new UserService();
		try {
			User user = service.login(username, password);
			if (user != null) {
				// 登录成功
				
				String autologin = request.getParameter("autologin");
				if ("ok".equals(autologin)) {
					// 勾选了
					Cookie cookie = new Cookie("autologin", URLEncoder.encode(username, "utf-8") + "::" + password);
					// 存储10天
					cookie.setMaxAge(10 * 24 * 60 * 60);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/demo4/success.jsp");
				return;
			} else {
				request.setAttribute("login.message", "用户名或密码错误");
				request.getRequestDispatcher("/demo4/login.jsp").forward(request,
						response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("login.message", "登录失败");
			request.getRequestDispatcher("/demo4/login.jsp").forward(request,
					response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
