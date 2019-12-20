<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-20
  Time: 上午 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    String.prototype.trim = function () {
        return this.replace(/^(\s*)|(\s*$)/g, "");
    }
    var s1 = "        abc           ";
    alert("|"+s1+"|");
    alert("|"+s1.trim().toUpperCase()+"|");
</script>
</body>
</html>
