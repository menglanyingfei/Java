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

<h4>JSTL方式</h4>
<h4>分隔字符串</h4>
<c:set var="i" value="aa,bb,cc" scope="page"></c:set>
<c:forTokens items="${ i }" delims="," var="x">
    ${ x }
    
</c:forTokens>


















</body>
</html>