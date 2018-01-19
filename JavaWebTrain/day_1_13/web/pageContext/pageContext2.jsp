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
    --%>
    <%
        // 通过pageContext对象获取数据
        String name = (String) pageContext.getAttribute("name", PageContext.REQUEST_SCOPE);
        out.print(name); // null haha

    %>

</body>
</html>
















