<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
    <form action="api/into/blogger" method="post">  
        <p>Title <input type="text" name="blogTitle" /></p>  
        <p>Content: <input type="text" name="blogContent"/></p>  
        <input type="submit" value="Submit" />  
    </form>
</body>
</html>