<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 10:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>el_01</title>
</head>
<body>
    <%
        Cookie cookie = new Cookie("name", "haha");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
    %>


</body>
</html>






























