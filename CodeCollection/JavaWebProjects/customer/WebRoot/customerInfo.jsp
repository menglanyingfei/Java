<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my"  uri="http://www.lxy.org/tag"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>修改</title>
</head>
<body>

    <form action="${pageContext.request.contextPath }/update" method="post">
        <input type="hidden" name="id" value="${c.id }">
        客户姓名:<input type="text" name="name" value="${c.name }"><br>
        
        客户性别:<%--<input type="radio" name="gender" value="${c.gender }"><br>--%>
        <%--<c:if test="${c.gender=='男' }">
            <input type="radio" name="gender" value="男" checked="checked">男
            <input type="radio" name="gender" value="女">女
        </c:if>
         <c:if test="${c.gender!='男' }">
            <input type="radio" name="gender" value="男">男
            <input type="radio" name="gender" value="女" checked="checked">女
        </c:if>
        --%>
        
        <my:sex gender="${c.gender }"/>
        
        <br>
        客户生日:<input type="text" name="birthday" value="${c.birthday }"><br>
        客户电话:<input type="text" name="cellphone" value="${c.cellphone }"><br>
        客户邮箱:<input type="text" name="email" value="${c.email }"><br>
        客户爱好:<input type="text" name="preference" value="${c.preference }"><br>
        客户类型:<input type="text" name="type" value="${c.type }"><br>
        客户备注:<input type="text" name="description" value="${c.description }"><br>
        <input type="submit" value="修改">
    </form>

</body>
</html>









