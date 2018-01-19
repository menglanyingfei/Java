<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 15:30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>333</title>
</head>
<body>
    <%-- 循环遍历
        forEach:
            end: 结束
            begin: 开始
            step: 每次增长的幅度

            for (int i = 0; i <= 10; i++)
            55 = 1 + 2 + 3 + ... + 9 + 10
    --%>
    <c:set var="sum" value="0"></c:set>

    <c:forEach end="10" begin="0" step="1" var="i">
        <c:set var="sum" value="${sum+i}"></c:set>
    </c:forEach>

    <c:out value="${sum}"></c:out>
</body>
</html>




















