<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 10:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>el_01</title>
</head>
<body>
    <%
        pageContext.setAttribute("name", "haha");
        request.setAttribute("name", "haha1");
        session.setAttribute("name", "haha2");

        application.setAttribute("name", "haha3");
    %>
    ${"hello"}
<br>
${45}
<br>
<%-- 全域查找
    查找顺序: pageContext, request, session, application

    指定域:
    ${域名.变量名}

--%>
    ${name}
    ${pageScope.name}
    ${requestScope.name}
    ${sessionScope.name}
    ${applicationScope.name}
</body>
</html>






























