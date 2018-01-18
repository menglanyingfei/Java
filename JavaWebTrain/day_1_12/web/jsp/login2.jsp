<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 15:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <%
        // 获取request域中的错误信息
        String message = (String) request.getAttribute("message");
        if (message == null) {
            message = "";
        }
        String mess = (String) request.getAttribute("mess");
        if (mess == null) {
            mess = "";
        }
    %>
    <font color="red"><%= message%></font>
    <form action="/day_1_12/LoginServlet2" method="post">
        用户名:<input type="text" name="username"><font color="red"><%= mess%></font>
        <br>
        密码:<input type="password" name="password">
        <br>
        <input type="submit" value="登录">
    </form>


</body>
</html>
