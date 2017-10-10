package org.lxy.web.servlet;

import java.io.File;
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
 * @date 2017-5-21
 */
@SuppressWarnings( "all" )
public class Upload3Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1362569619490566792L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		// 1. 创建DiskFileItemFactory
		// 使用默认的
		// DiskFileItemFactory factory = new DiskFileItemFactory();

		// 获取temp目录部署到tomcat下的绝对磁盘路径
		File file = new File(this.getServletContext().getRealPath("/temp"));
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 100, file);

		// 2. 创建ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 用于判断是否是上传操作
		boolean flag = upload.isMultipartContent(request);

		if (flag) {
			// 解决上传文件名称中文乱码
			upload.setHeaderEncoding("utf-8");
			// 设置上传文件大小 10M
			//upload.setSizeMax(10 * 1024 * 1024);
			
			try {
				// 解决request, 得到所有的上传项FileItem
				List<FileItem> items = upload.parseRequest(request);

				for (FileItem item : items) {
					if (item.isFormField()) {
						// 非上传组件
						System.out.println("组件名称:" + item.getFieldName());
						// 解决乱码问题
						System.out.println("内容:" + item.getString("utf-8"));
					} else {
						// 上传组件
						System.out.println("组件名称:" + item.getFieldName());
						System.out.println("上传文件名称:" + item.getName());
						// 上传文件名称
						String name = item.getName();
						
						name = name.substring(name.lastIndexOf("\\") + 1);

						IOUtils.copy(item.getInputStream(),
								new FileOutputStream(
										"f:/repository/JavaWeb/upload/" + name));
						
						// 删除临时文件
						item.delete();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {
			response.getWriter().write("不是上传操作");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
