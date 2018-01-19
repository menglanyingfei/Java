<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 8:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/jsp/jsp_02.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- jsp的三大指令 --%>
    <h1>JSP05</h1>
    <%
        request.getRequestDispatcher("/jsp/jsp_02.jsp").forward(request, response);
    %>
</body>
</html>
