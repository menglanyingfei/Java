<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h4>表单提交到JSP的页面</h4>
    <form action="/jsp/bean/success.jsp" method="post">
        姓名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password" /><br>
        <input type="submit" value="登陆">
    </form>
    
    
    <h4>表单提交到Servlet程序</h4>
    <form action="/jsp/user" method="post">
        姓名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password" /><br>
        <input type="submit" value="登陆">
    </form>
    
    
    <h4>表单提交到Servlet(BeanUtils)程序</h4>
    <form action="/jsp/userBeanUtil" method="post">
        姓名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password" /><br>
        余额：<input type="text" name="money" /><br>
        生日：<input type="text" name="birthday" /><br>
        <input type="submit" value="登陆">
    </form>
    
</body>
</html>