<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.wtu.entity.Item" %>
<%--
  User: menglanyingfei
  Date: 2018/1/13
  Time: 16:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>444</title>
</head>
<body>
    <%
        Map<String, Integer> map = new HashMap<>();
        map.put("name", 123);
        map.put("name1", 123);
        map.put("name2", 123);
        map.put("name3", 123);

        Map<String, Item> map1 = new HashMap<>();
        Item item1 = new Item(1, "小米", 1500.0, 10, "非常好用");
        Item item2 = new Item(2, "华为", 1800.0, 10, "非常好用");
        Item item3 = new Item(3, "苹果手机", 5500.0, 10, "非常好用");

        map1.put("haha", item1);
        map1.put("li", item2);
        map1.put("yang", item3);

        pageContext.setAttribute("map", map);
        pageContext.setAttribute("map1", map1);

        // forEach遍历map集合, 得到的是Entry对象
        /*
            var: entry对象(键值对)
            items: 保存在域中的集合对象
         */
    %>

    <%--<c:forEach var="m" items="${map}">--%>
        <%--${m.key} --- ${m.value}--%>
    <%--</c:forEach>--%>

    <c:forEach var="m" items="${map1}">
        ${m.key} --- ${m.value.id}
    </c:forEach>
</body>
</html>



















