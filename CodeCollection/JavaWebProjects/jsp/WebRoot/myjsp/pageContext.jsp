<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=request.getParameter("username")%>
<h4>pageContext向其他域中存入值</h4>
<%
    pageContext.setAttribute("name", "美美");
    // 下面这句等价于上面
    pageContext.setAttribute("name", "美美", pageContext.PAGE_SCOPE);  

    request.setAttribute("name", "小凤");
    // 向request域中存入值
    pageContext.setAttribute("name", "小凤", pageContext.REQUEST_SCOPE);  

    // 向session域中存入值
    pageContext.setAttribute("name", "小仓", pageContext.SESSION_SCOPE);
    
    // 向ServletContext域中存入值
    pageContext.setAttribute("name", "小班长", pageContext.APPLICATION_SCOPE);
    
    
%>

<%= pageContext.getAttribute("name", pageContext.SESSION_SCOPE)%>
<%= session.getAttribute("name")%>

${ pageScope.name }
${ requestScope.name }
${ sessionScope.name }
${ applicationScope.name }


</body>
</html>