<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>el_01</title>
</head>
<body>
      <%-- el表达式操作数组和list集合 --%>
    <%
        String[] arr = {"java", "C#", "C++", "python", "PHP", "c"};
        pageContext.setAttribute("arr", arr);

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("345");
        list.add("789");
        pageContext.setAttribute("list", list);

        // map集合
        Map<String, String> map = new HashMap<>();
        map.put("name", "haha");
        map.put("age", "18");
        map.put("school", "wtu");
        pageContext.setAttribute("map", map);
    %>

    ${arr[0]}
    ${list[2]}
    ${pageScope.map.name}
       <%--
       底层实现分析: Map.Entry<K, V>
       getValue()
       --%>
    ${map.age}
</body>
</html>


































