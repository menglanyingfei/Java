<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>home.page</h1>
	<a href="index1.html">首页
	</a>
	<br />
	<button
		onclick="javascript:window.location.href=('./api/validate/login')">登录</button>
	<p></p>
	<button
		onclick="javascript:window.location.href=('./api/validate/login_success')">验证</button>
</body>
</html>