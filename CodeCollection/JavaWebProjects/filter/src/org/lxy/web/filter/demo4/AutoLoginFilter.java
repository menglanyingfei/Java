package org.lxy.web.filter.demo4;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.domain.User;
import org.lxy.service.UserService;
import org.lxy.utils.CookieUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class AutoLoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 1. 强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 2. 操作

		// 判断如果用户访问的是登录操作, 不进行自动登录
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		if (!(path.equals("/demo4/login.jsp") || path.equals("/login"))) {

			// 判断用户没有登录, 才进行自动登录
			User u = (User) request.getSession().getAttribute("user");
			if (u == null) {
				// 2.1 得到cookie中的username和password
				Cookie cookie = CookieUtils.findCookieByName(
						request.getCookies(), "autologin");
				if (cookie != null) {
					// 找到了, 进行自动登录
					String username = URLDecoder.decode(cookie.getValue().split("::")[0], "utf-8");
					String password = cookie.getValue().split("::")[1];

					UserService service = new UserService();
					User user;
					try {
						user = service.login(username, password);
						if (user != null) {
							// 查找到了用户, 进行自动登录
							request.getSession().setAttribute("user", user);
							return;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// 3. 放行
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
