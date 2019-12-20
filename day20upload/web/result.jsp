<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-19
  Time: 上午 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/loginOut">退出</a>
<a href="${pageContext.request.contextPath}/login.jsp">返回登录页</a>
<table>
    <%
        List<String> list = (List) application.getAttribute("onlineUserList");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
    %>
    <tr>
        <td><%=name%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
