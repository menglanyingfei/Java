package org.lxy.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/**
 * @author menglanyingfei
 * @date 2017-5-21
 */
public class DownloadServlet extends HttpServlet {

	/**
	 * 注意IE浏览器下载时文件名称显示依旧存在问题
	 */
	private static final long serialVersionUID = 6781018136653367789L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 得到要下载的文件名称
		String filename = request.getParameter("filename");

		// 解决中文名称问题
		filename = new String(filename.getBytes("iso8859-1"), "utf-8");

		// 2. 判断文件是否存在
		File file = new File("F:/repository/JavaWeb/upload/" + filename);
		if (file.exists()) {
			// 完成存在, 完成下载

			// 下载注意事项1: 设置下载文件的mimeType
			String mimeType = this.getServletContext().getMimeType(filename);
			response.setContentType(mimeType);

			// 解决下载时文件名称显示问题
			String agent = request.getHeader("user-agent");
			System.out.println(agent);
			if (agent.contains("Trident")) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			} else if (agent.contains("Firefox")) {
				// 火狐浏览器
				BASE64Encoder base64Encoder = new BASE64Encoder();
				filename = "=?utf-8?B?"
						+ base64Encoder.encode(filename.getBytes("utf-8"))
						+ "?=";
			} else {
				// 其它浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			}

			// 下载注意事项2: 永远是下载
			response.setHeader("content-disposition", "attachment;filename="
					+ filename);

			// 读取要下载文件的内容
			FileInputStream fis = new FileInputStream(file);
			// 将要下载的文件内容通过输出流写回到浏览器端
			OutputStream os = response.getOutputStream();
			int len = -1;
			byte[] b = new byte[100 * 1024];

			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
				os.flush();
			}
			os.close();
			fis.close();
		} else {
			throw new RuntimeException("下载资源不存在.");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
