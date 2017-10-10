<%@page import="com.lxy.vo.User2"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>EL的WEB对象</h4>
${ param.username } 

<h4>获取请求头</h4>
${ header.referer }

<h4>获取全局初始化参数</h4>
${ initParam.username }

<h4>pageContext对象</h4>
${ pageContext.request.remoteAddr }
${ pageContext.request.contextPath }

</body>
</html>