<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 14:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>07</title>
</head>
<body>
    <%--
        cookie.getValue()
    --%>
    Cookie: ${cookie.name}
        ${cookie.name.value}
            ${cookie.name.name}
    <br>
    <%

        out.print(request.getCookies()[0]);
        out.print(request.getCookies()[0].getValue());
        out.print(request.getCookies()[0].getName());

    %>
</body>
</html>
