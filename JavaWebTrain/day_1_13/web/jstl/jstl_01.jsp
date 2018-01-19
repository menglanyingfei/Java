<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 14:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>11</title>
</head>
<body>
    <%--<c:out value="gouwa"></c:out>--%>
    <c:set var="name" value="haha" scope="session"></c:set>
    <c:out value="${name}" default="xxx"></c:out>

    <%--从域中删除一个属性, 那么全域删除 --%>
    <c:remove var="name" scope="session"></c:remove>

    <%-- 项目名:/day_1_13/ --%>
    ${pageContext.request.contextPath}
    <c:url value="/"></c:url>
</body>
</html>
