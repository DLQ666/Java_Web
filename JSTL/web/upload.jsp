<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2021-1-15
  Time: 下午 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/JSTL/uploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username" id="username"><br>
        头像：<input type="file" name="photo" id="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
