package com.lxy.response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 禁用浏览器的缓存
 * @author 15072
 *
 */
public class CEPServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * Cache-Control: no-cache
		 *	Expires: -1
		 *	Pragma: no-cache
		 */
		// 设置三个头信息
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", -1);
		
		// 向页面输出当前的时间
		// 获取当前的时间
		Date date = new Date();
		// 修改格式  yyyy-MM-dd HH:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);		
		// 输出
		response.getWriter().write(str);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
