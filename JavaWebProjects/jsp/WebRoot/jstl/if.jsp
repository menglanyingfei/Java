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
    int a = 10;
    if (a >= 10) {
    	out.print("a >= 10");
    } else {
    	out.print("a < 10");
    }
%>

<h4>JSTL方式</h4>
<c:set var="i" value="9" scope="page"></c:set>
<c:if test="${ i ge 10}" var="x" scope="page">
    i >= 10
</c:if>
<c:if test="${ i lt 10}">
    i &lt; 10
</c:if>
${ x }



















</body>
</html>