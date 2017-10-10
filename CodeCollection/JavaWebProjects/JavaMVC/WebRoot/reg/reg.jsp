<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <script type="text/javascript">
        // 完成校验 run()  返回false
        function run() {
        // 用户名不能为空
        var username = document.form1.username.value;
        if (username == "" || username.length == 0) {
        	alert("用户名不能为空");
        	return false;
        }
        // 密码不能为空, 不能少于6位
        var password = document.form1.password.value;
        if (password == "" || password.length < 6) {
            alert("密码至少6位");
            return false;
        }
        // 确认密码和密码一致
         var repassword = document.form1.repassword.value;
        if (repassword == "" || repassword != password) {
            alert("两次密码不一致");
            return false;
        }
        // 昵称不能为空
         var nickname = document.form1.nickname.value;
        if (nickname == "" || nickname.length == 0) {
            alert("昵称不能为空");
            return false;
        }
        // 邮箱正确的格式
         var email = document.form1.email.value;
        if (!/.+@.+\.[a-zA-Z]{2,4}$/.test(email)) {
            alert("邮箱格式不正确");
            return false;
        }
        // 可以提交了
        
        }
    </script>

</head>
<body>

    <font color="red">${ requestScope.msg }</font>
    <form name="form1" action="/JavaMVC/reg" method="post" onsubmit="return run()" >
        <table border="1" width="60%">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" /></td>
            </tr> 
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" /></td>
            </tr> 
             <tr>
                <td>确认密码</td>
                <td><input type="password" name="repassword" /></td>
            </tr>
             <tr>
                <td>昵称</td>
                <td><input type="text" name="nickname" /></td>
            </tr>
             <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" /></td>
              </tr>
              <tr>
                <td>验证码</td>
                <td>
                    <input type="text" name="code" />
                    <a href="#" onclick="show(); return false;"><img id="imgId" src="${ pageContext.request.contextPath }/checkcode" /></a>
                </td>
            </tr>
             <tr>
                <td colspan="2">
                    <input type="submit" value="注册"/>
                </td>
            </tr>
        </table>
    </form>
</body>

    <script type="text/javascript">
        function show() {
        	var image = document.getElementById("imgId");
        	image.src = "${pageContext.request.contextPath}/checkcode?" + new Date().getTime();
        }
    
    
    </script>
</html>