<%@page import="com.lxy.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>传统方式</h4>
<%
    request.setAttribute("name", "美美");
    request.removeAttribute("name");
%>

<h4>JSTL方式</h4>
<c:set var="name" value="小凤" scope="page"></c:set>
${ name }

<c:remove var="name" scope="page"/>





















</body>
</html>