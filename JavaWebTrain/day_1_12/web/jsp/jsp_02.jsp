<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 8:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>JSP02</title>
</head>
<body>
    <%--
        通过request对象, 获取request域中的数据
    --%>
    <%
        String name = (String) request.getAttribute("name");
        out.print(name + "\n");
    %>
    <%= name%>

</body>
</html>




