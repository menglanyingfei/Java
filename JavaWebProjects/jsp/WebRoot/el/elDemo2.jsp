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
<h4>EL的运算</h4>
<%
    request.setAttribute("n1", 10);
    request.setAttribute("n2", 20);
    request.setAttribute("n3", 30);
    request.setAttribute("n4", 40);
%>
<h4>加法运算</h4>
${ n1 + n2 }

<h3>关系运算</h3>
<h4>大于</h4>
${ n1 > n2 }    ${ n1 gt n2 }
<h4>小于</h4>
${ n1 < n2 }    ${ n1 lt n2 }
<h4>等于</h4>
${ n1 == n2 }    ${ n1 eq n2 }
<h4>不等于</h4>
${ n1 != n2 }    ${ n1 ne n2 }
<h4>大于等于</h4>
${ n1 >= n2 }    ${ n1 ge n2 }
<h4>小于等于</h4>
${ n1 <= n2 }    ${ n1 le n2 }

<h3>逻辑运算</h3>
<h4>与</h4>
${ n1 > n2 && n3 > n4 }    ${ n1 > n2 and n3 > n4 }

<h4>或</h4>
${ n1 > n2 || n3 > n4 }    ${ n1 > n2 or n3 > n4 }

<h4>非</h4>
${ !(n1 > n2) }    ${ not (n1 > n2) }


</body>
</html>