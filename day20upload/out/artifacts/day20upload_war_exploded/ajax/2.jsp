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
            document.getElementById("username").onblur = function () {
                if (this.value == "") {
                    alert("请输入用户名");
                    this.focus();//恢复焦点
                    return;
                }
                var xhr = getXhr();
                //2、注册状态变化监听器
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            // alert("服务器已经响应结束了，去看看吧");
                            var resp = xhr.responseText;
                            console.log(resp);
                            document.getElementById("msg").innerHTML = resp;
                        }
                    }
                }
                xhr.open('POST', '${pageContext.request.contextPath}/demo2?time=' + new Date().getTime());
                //设置请求头的meta类型
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xhr.send("username="+this.value);
            }
        }
    </script>
</head>
<body>
<form action="" method="post">
    用户名：<input type="text" id="username" name="username"/><span id="msg"></span><br/>
    密码:<input type="password" id="password" name="password"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
