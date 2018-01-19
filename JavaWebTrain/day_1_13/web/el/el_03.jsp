<%@ page import="com.wtu.entity.Student" %>
<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 10:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>el_03</title>
</head>
<body>
    <%--
    el表达式操作Java bean
    --%>
   <%
       Student student = new Student("李阳", "18", "女", 59.5);
       pageContext.setAttribute("student", student);
   %>

    ${student.name2}
    <%--  此处访问的不是属性名, 而是相当于调用了student.getName2()方法 --%>
    ${student.age}
    ${student.sex}
    ${student.score}
</body>
</html>






























