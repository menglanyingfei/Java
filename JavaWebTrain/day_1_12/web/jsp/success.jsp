<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 15:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>成功</title>
</head>
<body>
    <%
        // 获取用户信息
        String username = (String) session.getAttribute("username");

        if (username == null) {
            // 保存错误信息到request中, 然后转发到login2.jsp中, 提醒登录
            request.setAttribute("message", "请登录!");

            // 转发到登录页面
            request.getRequestDispatcher("/jsp/login2.jsp").forward(request, response);
        }
    %>
    <h2>欢迎领导:<%= username%></h2>
</body>
</html>
