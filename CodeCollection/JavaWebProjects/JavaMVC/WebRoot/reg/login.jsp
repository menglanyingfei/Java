<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://www.lxy.org/0318/myfn"  prefix="myfn"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="run()">
<h4>登录页面</h4>

<%
    // 获取cookie  %E6%9D%8E%E6%98%9F%E9%98%B3
    // URLDecoder.decode(username, "UTF-8");

    // 编写自定义EL函数
%>

<form action="${ pageContext.request.contextPath }/login" method="POST">
    <!-- 不能记住中文的用户名 -->
    <!-- 输入姓名:<input type="text" name="username" value="${ cookie.username.value }" /><br> -->
    <!-- 记住中文的用户名 -->
    <!--  输入姓名:<input type="text" name="username" value="${ myfn:decode(cookie.username.value) }" /><br>-->
    输入姓名:<input type="text" id="nameId" name="username" /><br>
    输入密码:<input type="password" name="password" /><br>
    <input type="checkbox" name="remember" value="remember" >记住用户名<br>
    <input type="submit" value="登录">
</form>

</body >
    <!-- 法三 -->
    <script type="text/javascript">
        function run() {
        	// 接收cookie的值
        	var str = "${ cookie.username.value }";
        	// 解码
        	var newstr = decodeURI(str);
        	// 赋值给文本框
        	document.getElementById("nameId").value = newstr;
        }
    </script>

</html>













