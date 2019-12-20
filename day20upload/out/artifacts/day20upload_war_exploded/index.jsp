<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    username:<input type="text" name="username"/>
    file1:<input type="file" name="file1"/>
    file2:<input type="file" name="file1"/>
    <input type="submit" value="submit">
</form>
</body>
</html>
