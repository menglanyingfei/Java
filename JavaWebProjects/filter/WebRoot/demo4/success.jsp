<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
        当前用户:${user.username }
        <br>
        <a href="${pageContext.request.contextPath }/book_add">book add</a>
        <br>
        <a href="${pageContext.request.contextPath }/book_update">book update</a>
        <br>
        <a href="${pageContext.request.contextPath }/book_delete">book delete</a>
        <br>
        <a href="${pageContext.request.contextPath }/book_search">book search</a>
  </body>
</html>











