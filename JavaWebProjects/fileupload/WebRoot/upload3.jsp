<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <title>文件上传</title>
  </head>
  
  <body>
  <!--  -->
    <form action="${pageContext.request.contextPath }/upload3" method="post" enctype="multipart/form-data">
        <input type="text" name="content"><br>
        <input type="file" name="f"><br>
        <input type="submit" value="上传">
    </form>
  </body>
</html>












