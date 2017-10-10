package com.lxy.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxy.utils.MyCookieUtil;

/**
 * 记录上次的访问时间
 * @author 15072
 *
 */
public class LastServlet extends HttpServlet {

	private static final long serialVersionUID = -6060237242359965335L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 1.获取所有的cookie，判断是否是第一次访问
		 * 2.如果是第一次访问
		 * 		* 输出欢迎，记录当前的时间，回写到浏览器
		 * 3.如果不是第一次访问
		 * 		* 获取时间，输出到浏览器，记录当前的时间，回写到浏览器
		 * 记录当前的时间，回写到浏览器
		 */
		
		// 设置字符中文乱码的问题
		response.setContentType("text/html;charset=UTF-8");
		// 获取所有的cookie
		Cookie [] cookies = request.getCookies();
		// 通过指定cookie名称来查找cookie		Cookie c = new Cookie("last", "当前的时间");
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "last");
		// 判断，如果cookie==null，说明是第一次访问
		if (cookie == null) {
			// 输出欢迎，记录当前的时间，回写到浏览器
			response.getWriter().write("<h3>亲，欢迎再来哦！！</h3>");
		} else {
			// 获取cookie的值，输出浏览器，记录当前的时间，回写到浏览器
			String value = cookie.getValue();
			// 输出浏览器
			response.getWriter().write("<h3>亲，您又来了，上次的时间是" + value + "</h3>");
		}
		// 记录当前的时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(date);
		// 回写到浏览器
		// 使用cookie回写
		Cookie c = new Cookie("last", sDate);
		
		// 设置有效时间
		c.setMaxAge(60 * 60); // 秒
		
		// 设置有效路径
		c.setPath("/jsp");
		// 回写
		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
