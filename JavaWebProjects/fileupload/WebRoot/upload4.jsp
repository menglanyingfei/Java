<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        <title>多文件上传</title>
        
        <script type="text/javascript">
            function addFile() {
            	var div = document.getElementById("content");
            	
            	div.innerHTML += "<div><input type='file' name='f'><input type='button' value='remove file' onclick='removeFile(this)'></div>";
            }
            
            function removeFile(btn) {
            	// alert(btn.value);
            	
            	document.getElementById("content").removeChild(btn.parentNode);
            	
            }
        </script>
  </head>
  
  <body>
  <!--  -->
    <input type="button" value="add File" onclick="addFile();">
    <form action="${pageContext.request.contextPath }/upload4" method="post" enctype="multipart/form-data">
        <input type="file" name="f"><br>
        <div id="content">
        
        </div>
        <input type="submit" value="上传">
    </form>
  </body>
</html>












