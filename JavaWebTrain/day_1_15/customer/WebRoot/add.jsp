<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
	
<script type="text/javascript">
	$(function() {
		$("#birthday").datepick({dateFormat:"yy-mm-dd"});
	});
	
	function add() {
		$(".error").text("");
		var bool = true;
		if(!$(":text[name=cname]").val()) {
			$("#cnameError").text("客户名称不能为空");
			bool = false;
		}
		if(!$("#male").attr("checked") && !$("#female").attr("checked")) {
			$("#genderError").text("客户性别不能为空");
			bool = false;
		}
		if(!$(":text[name=cellphone]").val()) {
			$("#cellphoneError").text("手机不能为空");
			bool = false;
		}
		if(!$(":text[name=email]").val()) {
			$("#emailError").text("email不能为空");
			bool = false;
		}
		if(bool) {
			$("form").submit();
		}
	}
	
</script>
<style type="text/css">
	.error {color:red;}
</style>
  </head>
  
  <body>
<h3 align="center">添加客户</h3>
<form action="${pageContext.request.contextPath }/CustomerServlet" method="post">
<input type="hidden" name="method" value="addCustomer">
<table border="0" align="center" width="40%" style="margin-left: 100px;">
	<tr>
		<td width="100px">客户名称</td>
		<td width="40%">
			<input type="text" name="cname"/>
		</td>
		<td align="left">
			<label id="cnameError" class="error">&nbsp;</label>
		</td>
	</tr>
	<tr>
		<td>客户性别</td>
		<td>
			<input type="radio" name="gender" value="男" id="male"/>
			<label for="male">男</label>
			<input type="radio" name="gender" value="女" id="female"/>
			<label for="female">女</label>
		</td>
		<td>
			<label id="genderError" class="error">&nbsp;</label>
		</td>
	</tr>
	<tr>
		<td>客户生日</td>
		<td>
			<input type="text" name="birthday" id="birthday" readonly="readonly"/>
		</td>
		<td>
			<label id="birthdayError" class="error">&nbsp;</label>
		</td>
	</tr>
	<tr>
		<td>手机</td>
		<td>
			<input type="text" name="cellphone"/>
		</td>
		<td>
			<label id="cellphoneError" class="error">&nbsp;</label>
		</td>		
	</tr>
	<tr>
		<td>邮箱</td>
		<td>
			<input type="text" name="email"/>
		</td>
		<td>
			<label id="emailError" class="error">&nbsp;</label>
		</td>	
	</tr>
	<tr>
		<td>描述</td>
		<td>
			<textarea rows="5" cols="30" name="description"></textarea>
		</td>
		<td>
			<label id="descriptionError" class="error">&nbsp;</label>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
			<input type="button" value="添加客户" onclick="add()"/>
			<input type="reset" value="重置"/>
		</td>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
  </body>
</html>
