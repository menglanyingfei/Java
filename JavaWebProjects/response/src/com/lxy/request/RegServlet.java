package com.lxy.request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求参数
 * @author 15072
 *
 */
public class RegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * request获取中文的乱码
		 * 		post请求(经常使用)
		 * 			setCharacterEncoding(String env)  设置request的缓冲区的编码
		 * 
		 * 		get请求
		 * 			username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		 */
		
		// 设置request缓冲区的编码(一定要在request.getParameter("username");之前)
//		request.setCharacterEncoding("UTF-8");
		
		// 获取内容，做其他操作
		// 获取姓名
		String username = request.getParameter("username");
		// 解析get方式乱码的问题
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		// 获取密码
		String password = request.getParameter("password");
		// 获取性别
		String sex = request.getParameter("sex");
		// 获取城市
		String city = request.getParameter("city");
		// 获取爱好  返回String数组
		String [] loves = request.getParameterValues("love");
		
		System.out.println("用户名：" + username);
		System.out.println("密码：" + password);
		System.out.println("性别：" + sex);
		System.out.println("城市：" + city);
		System.out.println("爱好：" + Arrays.toString(loves));
		
		System.out.println("====================");
		// 获取map集合
		Map<String, String []> map = request.getParameterMap();
		// 循环遍历
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String [] values = map.get(key);
			System.out.println(Arrays.toString(values));
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
