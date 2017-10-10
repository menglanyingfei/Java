package com.lxy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxy.utils.MyCookieUtil;

/**
 * 浏览记录后台
 * @author 15072
 *
 */
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 9115600091510936103L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 1. 获取请求参数
		 * 2. 获取cookie数组，通过指定的名称（自己指定）查找cookie
		 * 3. 如果cookie==null，第一次访问
		 * 		* 如果是第一次访问，创建cookie，回写浏览器
		 * 4. 如果cookie!=null,不是第一次访问
		 * 		* 如果不是第一次访问，说明我的cookie中已经存在id
		 * 			* 判断，当前的id是否已经存在cookie的value中
		 * 			* 如果存在，不用操作
		 * 			* 如果不存在，在后面追加（product=1,2）
		 * 5. 重定向到商品页面
		 */
		
		// 获取请求参数 目的：存入到cookie中
		String id = request.getParameter("id");
		// 先获取所有的cookie，查找指定名称的cookie
		Cookie [] cookies = request.getCookies();
		// 查找指定名称的cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		// 如果cookie==null，我第一次访问，创建cookie，回写
		if (cookie == null) {
			// 我第一次访问，创建cookie，回写
			Cookie c = new Cookie("product", id);
			// 设置有效时间
			c.setMaxAge(7 * 24 * 60 * 60);
			// 设置有效路径
			c.setPath("/");
			// 回写
			response.addCookie(c);
		} else {
			// 如果不是第一次访问
			// 获取cookie的value （value有可能是1,2,3）
			String value = cookie.getValue();  // 1,2,3
			// 判断，当前的商品的id是否包含在value中
			String [] values = value.split(",");
			if (!checkId(values, id)) {
				// 不包含
				cookie.setValue(value + "," + id);
				// 设置有效时间
				cookie.setMaxAge(7 * 24 * 60 * 60);
				// 设置有效路径
				cookie.setPath("/");
				// 回写
				response.addCookie(cookie);
			}
		}
		// 重定向到商品页面
		response.sendRedirect("/jsp/cookie/productList.jsp");
	}

	/**
	 * 判断，当前的id是否包含在values的数组中
	 * @param values
	 * @param id
	 * @return
	 */
	private boolean checkId(String[] values, String id) {
		for (String s : values) {
			if (s.equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
