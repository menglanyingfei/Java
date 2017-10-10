<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
    <table border="1" width="60%">
    <% 
    for (int i = 1; i <= 10; i++) {   
    %>	
    	<tr>
    	<%
    	for (int j = 1; j <= 10; j++) {
    	%>
    	   <td>6</td>
    	<% 
    	}
    	%>
    	</tr>    	    	  	
    <%	
    }
    %>    
    </table>
</body>
</html>