package org.lxy.web.filter.demo5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.domain.User;
import org.lxy.exception.PrivilegeException;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */

// 权限过滤器
public class PrivilegeFilter implements Filter {

	private List<String> users;
	private List<String> admins;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.admins = new ArrayList<String>();
		this.users = new ArrayList<String>();
		
		fillPath("user", users);
		fillPath("admin", admins);
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 1. 强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 2. 操作
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		if (admins.contains(path) || users.contains(path)) {
			// 判断用户是否登录了
			User user = (User) request.getSession().getAttribute("user");
			
			if (user == null) {
				throw new PrivilegeException();
			}
			// 判断用户的角色, 是否可以访问当前资源路径
			if ("admin".equals(user.getRole())) {
				// 这是admin角色
				if (!(admins.contains(path))) {
					throw new PrivilegeException();
				}
			} else {
				// 这是user角色
				if (!(users.contains(path))) {
					throw new PrivilegeException();
				}
			}
		}
		
		// 3. 放行
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	private void fillPath(String baseName, List<String> list) {
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		String path = bundle.getString("url");
		
		String[] paths = path.split(",");
		
		for (String p : paths) {
			list.add(p);
		}
	}
}

















