<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 9:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Context</title>
</head>
<body>
    <%--
        pageContext的使用:
            1. 作为域对象, 只在当前jsp页面生效
            2. 代替其它三个域对象使用
    --%>
    <%
        // 通过pageContext对象保存数据, 往request中获取数据
//        pageContext.setAttribute("name", "gouwa");
        pageContext.setAttribute("name", "haha", PageContext.REQUEST_SCOPE);
    %>
    <jsp:forward page="pageContext2.jsp"></jsp:forward>
    <%
//        out.print(pageContext.getAttribute("name"));
    %>
</body>
</html>
















