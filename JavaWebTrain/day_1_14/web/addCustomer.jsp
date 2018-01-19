<%--
  User: menglanyingfei
  Date: 2018/1/14
  Time: 8:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>增加</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/CustomerServlet" method="post">
        <!-- 提交时默认带上, 区分具体做什么操作 -->
        <input type="hidden" name="method" value="addCustomer">
        <input type="submit" value="添加">
    </form>
</body>
</html>
