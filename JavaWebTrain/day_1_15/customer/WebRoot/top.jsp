<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base target="main">
    <title>My JSP 'top.jsp' starting page</title>
  </head>
  
  <body style="text-align: center;">
  	<h1>客户关系管理系统</h1>
    <a href="<c:url value='/add.jsp'/>">添加客户</a> 　|　
    <a href="${pageContext.request.contextPath}/CustomerServlet?method=findAllCustomer">查询客户</a>　|　
    <a href="<c:url value='/query.jsp'/>">高级搜索</a>　　
  </body>
</html>
