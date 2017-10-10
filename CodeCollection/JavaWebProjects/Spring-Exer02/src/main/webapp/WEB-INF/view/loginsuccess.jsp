<%@page import="com.netease.course.entity.User"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		String username = (String)request.getAttribute("user");
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance(); 
		calendar.setTime(date);  
		int hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		 
		if (hours < 11 && hours >= 0) {
			out.print("早上好，");
		} else if (hours < 14) {
			out.print("中午好，");
		} else if (hours < 18) {
			out.print("下午好，");
		} else {
			out.print("晚上好，");
		}
		out.print(username);
		
	%>

	<p><button onclick="javascript:window.location.href=('./logout')" >退出</button></p>
</body>
</html>