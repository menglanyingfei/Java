package org.lxy.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.lxy.service.RegService;
import org.lxy.vo.User;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -7765091792046970976L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 获取参数列表
		 * 封装数据
		 * 调用JavaBean完成业务
		 * 转发到Servlet
		 */
		request.setCharacterEncoding("UTF-8");
		// 获取参数列表
		@SuppressWarnings("unchecked")
		Map<String, String []> map = request.getParameterMap();
		// 创建User对象
		User user = new User();
		// 封装数据
		try {
			BeanUtils.populate(user, map);
			// 完成登录的功能
			RegService service = new RegService();
			// 登录功能
			User succUser = service.loginUser(user);
			// 如果succUser是null, 说明登录不成功
			if (succUser == null) {
				// 登录不成功, 转发到登录页面
				request.setAttribute("msg", "用户名或者密码不正确");
				request.getRequestDispatcher("/reg/login.jsp").forward(request, response);	
			} else {
				// 完成记住用户名的功能
				// 获取复选框的内容
				String remember = request.getParameter("remember");
				// 判断
				if (remember != null && "remember".equals(remember)) {
					String username = succUser.getUsername();
					// 先把中文的名称编码
					username = URLEncoder.encode(username, "UTF-8");
					
					System.out.println(username);
					//%E6%9D%8E%E6%98%9F%E9%98%B3
					
					// 记住用户名,保存到cookie中
					Cookie cookie = new Cookie("username", username);
					// 设置有效时间
					cookie.setMaxAge(60 * 60);
					// 设置有效路径
					cookie.setPath("/");
					// 回写cookie
					response.addCookie(cookie);
				}
				
				// 登录成功, 跳转到某个页面, 用户信息显示到页面上
				// 重定向到成功的页面
				// 显示用户的信息
				request.getSession().setAttribute("succUser", succUser);
				response.sendRedirect(request.getContextPath() + "/reg/success.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
