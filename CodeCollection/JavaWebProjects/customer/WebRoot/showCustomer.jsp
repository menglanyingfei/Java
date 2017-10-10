<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>

<script type="text/javascript">
    function del(id) {
    	var flag = window.confirm("确认删除吗");
    	if (flag) {
    		// 确认删除
    		location.href = "${pageContext.request.contextPath}/delById?id=" + id;
    	}
    };
    
    function change() {
    	// 1. 得到id为main的这个checkbox
    	var main = document.getElementById("main");
    	
    	var flag = main.checked;
    	
    	// 2. 得到所有name为ck的checkbox
    	var cks = document.getElementsByName("ck");
    	// 3. 将cks中所有的checkbox的checked值设置为flag
    	for (var i = 0; i < cks.length; i++) {
    		cks[i].checked = flag;
    	}
    };
    
    function sendDel() {
    	// 表单提交
    	document.getElementById("f").submit(); 
    }

</script>
</head>
<body>
    
    <c:if test="${empty cs}">
        无客户信息   
    </c:if>
    
    <c:if test="${not empty cs}">   
	        <div align="center">
	           <form action="${pageContext.request.contextPath }/simpleSelect"  method="post">
		            <select name="field">
		                <option>请选择条件</option>
		                <option value="name">按姓名查询</option>
		                <option value="cellphone">按手机号查询</option>
		                <option value="description">按描述查询</option>
		            </select>
		            <input type="text" name="msg">
		            <input type="submit" value="查询">
	            </form>
	        </div>
        
        
        <br>
        <form action="${pageContext.request.contextPath }/delSelect" method="post" id="f">
        <table border="1" align="center" width="85%">
            <tr>
                <td><input type="checkbox" id="main" onclick="change();"></td>
                <td>客户编号</td>
                <td>客户姓名</td>
                <td>客户性别</td>
                <td>客户生日</td>
                <td>客户电话</td>
                <td>客户邮箱</td>
                <td>客户爱好</td>
                <td>客户类型</td>
                <td>客户备注</td>
                <td>操作</td>
            </tr>
            
            <c:forEach items="${cs}"  var="c">
                <tr>
	                <td><input type="checkbox"  name="ck" value="${c.id }"></td>
	                <td>${c.id}</td>
	                <td>${c.name }</td>
	                <td>${c.gender }</td>
	                <td>${c.birthday }</td>
              <td>${c.cellphone }</td>
	                <td>${c.email }</td>
	                <td>${c.preference }</td>
	                <td>${c.type }</td>
	                <td>${c.description }</td>
	                <!--  <td><a href="${pageContext.request.contextPath }/delById?id=${c.id}">编辑</a>&nbsp;&nbsp;&nbsp;
	                <a>删除</a></td>-->
	                <td><a href="javascript:void(0)" onclick="del('${c.id}')">删除</a>&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/findById?id=${c.id}">编辑</a></td>
                </tr>
            </c:forEach>
            
            <tr>
                <td colspan="10">
                    <a href="javascript:void(0)" onclick="sendDel();">删除选中</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath }/add.jsp">添加</a>
                </td>
            </tr> 
            
        </table>
        </form>
    </c:if>
       
</body>
</html>





