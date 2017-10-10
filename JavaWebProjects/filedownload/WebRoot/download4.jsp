<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>使用队列来完成下载upload目录下所有文件</title>
</head>

<body>
	<!-- 使用队列操作 -->
	<%
		String path = "F:\\repository\\JavaWeb\\filedownload\\WebRoot\\upload";
		File uploadDirectory = new File(path);
		
		// 创建一个队列
		Queue<File> queue = new LinkedList<File>();
		
		queue.offer(uploadDirectory);
		
		// 如果队列不为空
		while (!queue.isEmpty()) {
			// 从队列中获取一个File
			File f = queue.poll();
			// 是目录, 将目录下的所有文件遍历出来, 存储在队列中
			if (f.isDirectory()) {
				File[] fs = f.listFiles();
				
				for (int i = 0; i < fs.length; i++) {
					queue.offer(fs[i]);
				}
			} else {
				//System.out.println(f.getName());
				//System.out.println(f.getAbsolutePath());
				String absolutePath = f.getAbsolutePath();
				String p = absolutePath.substring(absolutePath.lastIndexOf("\\upload"));
				System.out.println(p);
				
				out.println("<a href='/filedownload" + p + "'>"+f.getName()+"</a><br>");
			}
		}
	%>
</body>

</html>
































