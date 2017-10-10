package com.lxy.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载
 * @author 15072
 *
 */
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取到文件，读入输入流中
		// 获取文件的绝对磁盘路径
		String path = getServletContext().getRealPath("/img/小狗.png");
		// 包含文件的名称  D:\apache-tomcat-6.0.48\webapps\response\img\dog.png
		// 截取文件的名称  dog.png
		
		String filename = null;
		// 获取最后一个\的位置
		int index = path.lastIndexOf("\\");
		System.out.println(index);
		
		if (index != -1) {
			filename = path.substring(index + 1);
		}
		System.out.println(filename);
		
		
		// 判断是什么浏览器  Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0
		// Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
		String agent = request.getHeader("User-Agent");
		System.out.println(agent);
		
		if (agent.contains("Trident")) {
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		if (filename != null) {
			// 设置头信息
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			
			System.out.println(request.getRemoteAddr());
			// 10.177.6.155
			System.out.println(path);
			// D:\apache-tomcat-6.0.48\webapps\response\img\dog.png
			
			InputStream in = new FileInputStream(path);
			// 通过response读出到客户端
			OutputStream os = response.getOutputStream();
			// io的拷贝
			byte [] b = new byte[1024];
			int len = 0;
			while ((len = in.read(b)) != -1) {
				os.write(b, 0, len);
			}
			in.close();
			// os.close(); 服务器管理流
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
