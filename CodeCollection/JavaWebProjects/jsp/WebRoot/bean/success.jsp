<%@page import="com.lxy.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>传统方式封装数据</h3>
<%
    // 获取表单的内容
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    // 创建User对象，set设置值
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    
%>
<%=user.getUsername()%>

<!-- 使用jsp的标签封装数据 -->
<jsp:useBean id="u" class="com.lxy.vo.User"></jsp:useBean>
<jsp:setProperty property="username" name="u"/>
<jsp:setProperty property="password" name="u"/>

<jsp:getProperty property="username" name="u"/>
<jsp:getProperty property="password" name="u"/>


</body>
</html>