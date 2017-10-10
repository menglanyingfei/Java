package org.lxy.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class Upload2Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7116833508626261642L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 创建DiskFileItemFactory
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 2. 创建
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 底层通过request获取数据, 进行解析, 将解析的数据封装到List<FileItem>
			List<FileItem> items = upload.parseRequest(request);

			// 3. 遍历集合
			for (FileItem item : items) {
				if (item.isFormField()) {
					// 这就是得到了<input type="text" name="content">这样的组件
					String fieldName = item.getFieldName();
					System.out.println(fieldName);
					String name = item.getName();
					System.out.println(name);

					String msg = item.getString();
					System.out.println(msg);
				} else {
					// 这就是得到了<input type="file">这样的组件
					String fieldName = item.getFieldName();
					System.out.println("上传组件的名称:" + fieldName);
					String name = item.getName();
					System.out.println("上传组件:" + name);

					name = name.substring(name.lastIndexOf("\\") + 1);

					String msg = item.getString();
					System.out.println(msg);

					// 获取上传文件内容, 完成文件上传操作

					// InputStream is = item.getInputStream();
					// byte[] b = new byte[1024];
					// int len = -1;
					//
					FileOutputStream fos = new FileOutputStream(
							"f:/repository/JavaWeb/upload/" + name);
					// while ((len = is.read(b)) != -1) {
					// fos.write(b, 0, len);
					// }
					// fos.close();
					// is.close();

					IOUtils.copy(item.getInputStream(), fos);

				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
