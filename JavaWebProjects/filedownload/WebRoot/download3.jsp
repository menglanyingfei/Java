<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>使用队列来完成下载upload目录下所有文件</title>
</head>

<body>
    <!-- 使用递归操作 -->
    <%! // 声明一个方法   
    public void getFile(File file) {
    	if (file.isDirectory()) {
    		// 是目录
    		File[] fs = file.listFiles();
    		
    		for (int i = 0; i < fs.length; i++) {
    			getFile(fs[i]); // 递归调用
    		} 
    	} else if (file.isFile()) {
    		// 是文件
    		System.out.println(file.getName());
    	}
    }    
    %>

    <%
        String path = "F:\\repository\\JavaWeb\\filedownload\\WebRoot\\upload";
        File uploadDirectory = new File(path);
        
        getFile(uploadDirectory);
    %>

</body>

</html>
































