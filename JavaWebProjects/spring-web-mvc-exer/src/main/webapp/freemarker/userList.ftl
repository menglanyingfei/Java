<html>
    <head>
        
        <title>用户列表</title>
    </head>
    <body>
        <table border="1px">
          <thead>
            <tr>
              <td>userId</td>
              <td>userName</td>
            </tr>
          </thead>
          <tbody>
            <#list userList as user> 
                <tr>
                    <td>${user.userId}</td> 
                    <td>${user.userName}</td>
                </tr>
            </#list>
          </tbody>  
        </table>
        
    </body>
</html>