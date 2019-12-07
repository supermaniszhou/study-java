<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    rememberMe:<input type="checkbox" name="remember"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
