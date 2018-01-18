<%@ page import="java.net.URLDecoder" %>
<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 10:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录</title>
</head>
<body>
    <%-- 获取浏览器发送过来的Cookie
    --%>
    <%
        String value = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 判断Cookie的名称是否等于"username"
                if ("username".equals(cookie.getName())) {
                    value = cookie.getValue();
                    // 解码
                    value = URLDecoder.decode(value, "utf-8");
                }
            }
        }
    %>
    <form action="/day_1_12/loginServlet" method="post">

        用户名:<input type="text" name="username" value="<%= value%>">
        <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>









