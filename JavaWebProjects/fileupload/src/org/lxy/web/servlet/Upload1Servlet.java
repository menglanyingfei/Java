package org.lxy.web.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class Upload1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1188289884737330501L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("upload1 servlet...");
		
		// 通过request获取一个字节输入流, 将所有的请求正文信息读取到, 打印到控制台
		InputStream is = request.getInputStream();
		
		byte[] b = new byte[1024];
		int len = -1;
		
		while ((len=is.read(b)) != -1) {
			System.out.println(new String(b, 0, len));
		}
		is.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}













