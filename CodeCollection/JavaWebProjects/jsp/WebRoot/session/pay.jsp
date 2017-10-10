<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h3>结算页面</h3>

<%
    // 获取购物车，把购物车中的商品信息和数量显示到页面上
    Map<String, Integer> cart = (Map<String, Integer>) request.getSession().getAttribute("cart");
    // 购物车不为空，循环遍历
    if (cart != null) {
    	// 循环遍历
    	Set<String> keys = cart.keySet();
    	// 循环keys，拿到商品的名称
    	for (String key : keys) {
%>
        <h3>亲，您购买的商品是<%= key %>，数量是<%= cart.get(key) %></h3>
<%   		
    	}	
    } else {
%>      	
    	<h3>亲，您还没有购物，请您去<a href="/jsp/session/cartList.jsp">败家</a></h3>
<%
    }
%>

</body>
</html>