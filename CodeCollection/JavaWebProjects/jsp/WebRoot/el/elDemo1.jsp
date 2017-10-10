<%@page import="com.lxy.vo.User2"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>获取域对象中的值</h4>
<%
    request.setAttribute("name", "美美");
    pageContext.setAttribute("name", "黄海波");
%>
${ pageScope.name }
${ requestScope.name }

<h4>域中数组的值</h4>
<%
    String [] arrs = {"美美", "波波", "东东", "名名"};
    request.setAttribute("arrs", arrs);
%>
${ arrs[2] }

<h4>域中集合的值</h4>
<%
    List<String> list = new ArrayList<String>();
    list.add("美美");
    list.add("小凤");
    list.add("芙蓉");
    request.setAttribute("list", list);
%>
${ list[1] }

<h4>域中Map集合的值</h4>
<%
    Map<String, String> map = new HashMap<String, String>();
    map.put("aa", "美美");
    map.put("bb", "小凤");
    map.put("bb.cc", "小凤");
    request.setAttribute("map", map);
%>
${ map.bb }
${ map["bb.cc"] }

<h4>域中集合中有对象的值</h4>
<%
    List<User2> uList = new ArrayList<User2>();
    uList.add(new User2("banzhang", "123"));
    uList.add(new User2("美美", "abc"));
    request.setAttribute("uList", uList);
%>
${ uList[1].username }











</body>
</html>