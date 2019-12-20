<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-19
  Time: 下午 05:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/ajax.js"></script>
    <script>
        window.onload = function () {
            document.getElementById("bt1").onclick = function () {
                var xhr = getXhr();
                //2、注册状态变化监听器
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            // alert("服务器已经响应结束了，去看看吧");
                            var resp=xhr.response;
                            console.log(resp)
                        }
                    }
                }
                xhr.open('GET', '${pageContext.request.contextPath}/demo1?time=' + new Date().getTime());
                xhr.send(null);
            }
        }
    </script>
</head>
<body>
<input type="button" id="bt1" value="点我啊"/>
</body>
</html>
