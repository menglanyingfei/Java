<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 14:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>22</title>
</head>
<body>
    <c:if test="${param.score>90}">
        <c:out value="成绩优秀"/>
    </c:if>
     <%--if-else if - else --%>
    <c:choose>
        <c:when test="${param.score>100||param.score<0}">
            分数不正确
        </c:when>
        <c:when test="${param.score>90}">
            成绩优秀
        </c:when>
        <c:when test="${param.score>60}">
            成绩一般
        </c:when>
        <c:otherwise>
            成绩很差
        </c:otherwise>
    </c:choose>



</body>
</html>












