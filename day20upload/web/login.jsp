<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-19
  Time: 上午 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username"/>
    <br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
