<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 8:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>JSP01</title>
</head>
<body>
    <%--
    采用jsp的注释

        jsp中java脚本
        <%= %>
        输出一个变量和常量
    --%>

    <%= "helloworld"%>

    <%
        int i = 10;
        int j = 200;

    %>
    <%!
        int i = 100;
        int k = 200;
    %>

    <%= i %>
    <%= this.i %>
    <%=  j++ %>
    <%= k++ %>

    <%= "==================="%>
    <%
        out.print("我喜欢JSP!");
    %>
















</body>
</html>




