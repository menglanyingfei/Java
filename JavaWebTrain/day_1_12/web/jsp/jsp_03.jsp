<%--
  User: menglanyingfei
  Date: 2018/1/12
  Time: 8:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>JSP03</title>
</head>
<body>
    <%--
        打印表格
    --%>
    <table border="1" width="500px" align="center">
        <caption>
            学生信息
        </caption>
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>

        </tr>
            <%
                for (int i = 0; i < 10; i++ ) { %>
                <tr>
                    <td><%= "狗娃" + i%></td>
                    <td><%= i+1%></td>
                    <td>
                        <%
                            if (i % 2 == 0) {
                                out.print("男");
                            } else {
                                out.print("女");
                            }
                        %>
                    </td>

                </tr>
            <%
                }
            %>
    </table>
</body>
</html>




