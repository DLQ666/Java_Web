<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2021-1-18
  Time: 下午 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8080/tmp/registServlet" method="get">
    用户名：<input type="text" name="username" ><br>
    验证码：<input type="text" name="code" ><img src="http://localhost:8080/tmp/kaptcha.jpg"><br>
    <input type="submit" value="登录">
  </form>
  </body>
</html>
