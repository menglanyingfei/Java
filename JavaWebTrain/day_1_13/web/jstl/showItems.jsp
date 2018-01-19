<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 15:50
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>商品列表</title>
</head>
<body>

    <table border="1" cellspacing="0" align="center" width="50%">
        <caption>商品信息展示</caption>
        <tr>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <%--
            var: 集合被遍历以后每个元素的名称
            items: 域中被保存的变量的变量名
            --%>
        <c:forEach var="ite" items="${requestScope.itemsList}">
            <tr>
                <th>${ite.name}</th>
                <th>${ite.price}</th>
                <th>${ite.count}</th>
                <th>${ite.detail}</th>
                <th>
                    <a href="#">修改</a>
                    <a href="#">删除</a>
                </th>
            </tr>
        </c:forEach>
    </table>



</body>
</html>



