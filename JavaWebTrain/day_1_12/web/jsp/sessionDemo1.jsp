<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 14:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>session</title>
</head>
<body>
    <%--获取session数据 --%>
    <%
        String name = (String) session.getAttribute("name");
        out.print(name);
    %>

</body>
</html>
