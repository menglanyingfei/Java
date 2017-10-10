package com.netease.course.web.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.netease.course.TokenUserData;
import com.netease.course.entity.User;
import com.netease.course.service.impl.UserAccountValidateService;
import com.netease.course.utils.CookieUtil;
import com.netease.course.utils.KeyGenerator;
import com.netease.course.utils.StringUtil;

@Controller
@RequestMapping(value = "/validate")
public class UserLoginServlet {

	private UserAccountValidateService userAccountValidateService = new UserAccountValidateService();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void UserLogindoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String origUrl = req.getParameter("origUrl");
		req.setAttribute("origUrl", origUrl);

		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		System.out.println("login doGet want to login");

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void UserLogin(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException {
		WebApplicationContext ctx=(WebApplicationContext)req.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		this.userAccountValidateService = ctx.getBean("userAccountValidateService", UserAccountValidateService.class);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("first into login");
		String origUrl = req.getParameter("origUrl");
		User user = null;

		try {
			user = userAccountValidateService.findUserByAccount(username);

			if (user != null) {
				if (user.getPassword().equals(password)) {
					// 生成uid
					String token = KeyGenerator.generate();
					// 存入uid
					TokenUserData.addToken(token, user);
					Cookie haslogin = new Cookie("token", token);
					haslogin.setMaxAge(1200);
					haslogin.setPath("/");
					haslogin.setHttpOnly(true);
					resp.addCookie(haslogin);
					System.out.println("check cookie");

					if (StringUtil.isEmpty(origUrl)) {
						origUrl = "login_success";
					} else {
						origUrl = URLDecoder.decode(origUrl, "utf-8");
					}
					req.setAttribute("user", username);
					// resp.sendRedirect(origUrl);
					req.getRequestDispatcher("/WEB-INF/view/loginsuccess.jsp").forward(req, resp);
					System.out.println("第一次登录，我要直接调用jsp");
				} else {
					backToLoginPage(req, resp, user, origUrl, "密码不正确");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			backToLoginPage(req, resp, user, origUrl, "发生系统错误！");
		}
	}

	private void backToLoginPage(HttpServletRequest req, HttpServletResponse resp, User user, String origUrl,
			String string) throws SQLException, IOException, ServletException {
		req.setAttribute("account", user);
		req.setAttribute("origUrl", origUrl);
		req.setAttribute("errInfo", string);

		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}

	@RequestMapping(value = "/logout")
	public void UserLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String token = CookieUtil.getCookie(req, "token");
		if (token != null) {
			TokenUserData.removeToken(token);
		}

		CookieUtil.removeCookie(resp, "token", "/", null);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("<p style='color:\"blue\"'>logout success</p>" + "<a href=\"./login\">首页</a>");
	}

	@RequestMapping(value = "/login_success")
	public void UserLogSuccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean alreadylogin = false;
		String username = null;
		String cookiename = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookiename = cookie.getName();
			if ("token".equals(cookiename)) {
				String uid = cookie.getValue();
				User user = TokenUserData.validateToken(uid);
				System.out.println("user in success " + user);
				if (user != null) {
					username = user.getUsername();
					alreadylogin = true;
				}
			}
		}
		if (!alreadylogin) {
			response.sendRedirect(request.getContextPath() + "/login.html");
			System.out.println("please login");
			System.out.println("直接访问用户页面，但是失败了。");
		} else {
			request.setAttribute("user", username);
			request.getRequestDispatcher("/WEB-INF/view/loginsuccess.jsp").forward(request, response);
			System.out.println("用户验证通过，继续下面逻辑");
		}
	}

}
