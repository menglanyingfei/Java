<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h3 align="center">客户列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>客户姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c:forEach var="customer" items="${requestScope.pageBean.list }">
		<input type="hidden" value="${customer.cid }" id="cid"/>
		<input type="hidden" value="${customer.cname }" id="cname">
	<tr>
		<td>${customer.cname }</td>
		<td>${customer.gender }</td>
		<td>${customer.birthday }</td>
		<td>${customer.cellPhone }</td>
		<td>${customer.email }</td>
		<td>${customer.description }</td>
		<td>
			<a href="${pageContext.request.contextPath }/CustomerServlet?method=findCustomerById&cid=${customer.cid}">编辑</a>
			<a href="javascript:_delete('${customer.cid }')">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>
<center style="font-size:2em;">
	第${pageBean.cp }页/共${pageBean.tp }页
	
	<a href = "${pageContext.request.contextPath }/CustomerServlet?method=findAllCustomer&cp=1"/>首页</a>
	
	
	<%--如果当前页为1  那么 不能够在上一页 --%>
	<c:choose>
		<c:when test="${pageBean.cp>1 }">
			<a href = "${pageContext.request.contextPath }/CustomerServlet?method=findAllCustomer&cp=${pageBean.cp-1}"/>上一页</a>
		</c:when>
		<c:otherwise>
			上一页
		</c:otherwise>
	</c:choose>



	<%--如果总页数小于10 那么第一个数字为  1  最后一个数字为总页数 --%>
	<c:if test="${pageBean.tp<=10 }">
		<c:set var="begin" value="1"/>
		<c:set var="end" value="${pageBean.tp }"/>
	</c:if>
	<%--
		如果总页数大于10 那么第一个数字为  cp-5  最后一个数字为cp+4
		
     --%>
	<c:if test="${pageBean.tp>10 }">
		<c:set var = "begin" value="${pageBean.cp-5 }"/>
		<c:set var = "end" value = "${pageBean.cp+4 }"/>
		<c:if test="${begin<1 }">
			<c:set var="begin" value="1"/>
			<c:set var="end" value="10"/>
		</c:if>
		<c:if test="${end>pageBean.tp }">
			<c:set var="begin" value="${pageBean.tp-9}"/>
			<c:set var="end" value="${pageBean.tp }"/>
		</c:if>
	</c:if>
	
	<c:forEach begin="${begin }" end="${end }" var="i">
		<c:choose>
			<c:when test="${pageBean.cp eq i }">
				${i}
			</c:when>
			<c:otherwise>
				<a href = "${pageContext.request.contextPath }/CustomerServlet?method=findAllCustomer&cp=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	
	
	<%-- 如果当前页等于总页数  那么不能再下一页 --%>
	<c:choose>
		<c:when test="${pageBean.cp < pageBean.tp }">
			<a href = "${pageContext.request.contextPath }/CustomerServlet?method=findAllCustomer&cp=${pageBean.cp+1}"/>下一页</a>
		</c:when>
		<c:otherwise>
			下一页
		</c:otherwise>
	</c:choose>
	<a href = "${pageContext.request.contextPath }/CustomerServlet?method=findAllCustomer&cp=${pageBean.tp}"/>尾页</a>
</center>

<script type="text/javascript">
	function _delete(cid){
		var flag = window.confirm("确认要删除吗 ！！！");
		if (flag == true) {
			location.href = "${pageContext.request.contextPath}/CustomerServlet?method=deleteCustomerById&cid="+cid;
		}
	}
	
</script>
  </body>
</html>
