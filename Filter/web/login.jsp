<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2021-1-19
  Time: 上午 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    登录页面！！<br>
    <form action="http://localhost:8080/filter/loginServlet" method="get">
      用户名：<input type="text" name="username" ><br>
      密码：<input type="password" name="password" ><br>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
