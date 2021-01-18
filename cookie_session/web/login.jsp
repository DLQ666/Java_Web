<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2021-1-18
  Time: 上午 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/cookie_session/loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
        密码：<input type="password" name="password" ><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
