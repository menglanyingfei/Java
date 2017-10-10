<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <a href='${pageContext.request.contextPath }/download?filename=a.txt'>a.txt</a><br>
    <a href='${pageContext.request.contextPath }/download?filename=中文.docx'>中文.docx</a><br>
    <a href='${pageContext.request.contextPath }/download?filename=java.jpg'>java.jpg</a><br>
  </body>
  
</html>
