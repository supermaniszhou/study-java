<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-20
  Time: 下午 01:55
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
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            var text = xhr.responseText;//文本
                            var json = eval('(' + text + ')');
                            document.getElementById("table").innerHTML = "<table id='t1' border='1' width='438'><tr><th>编号</th><th>名称</th><th>价格</th></tr></table>";
                            for (var i = 0; i < json.length; i++) {
                                var p = json[i];
                                var tableObj = document.getElementById("t1");
                                //得到表格对象:HTML DOM
                                //调用insertRow插入一行，返回TableRow
                                var trObj = tableObj.insertRow(tableObj.rows.length);
                                //TableRow的insertCell，返回TableCell
                                var idTdobj = trObj.insertCell(trObj.cells.length);
                                idTdobj.innerHTML = p.id;
                                var nameTdObj = trObj.insertCell(trObj.cells.length);
                                nameTdObj.innerHTML = p.name;
                                var priceTdObj = trObj.insertCell(trObj.cells.length);
                                priceTdObj.innerHTML = p.price;
                            }
                        }
                    }
                }
                xhr.open("GET", "${pageContext.request.contextPath}/demo5?time=" + new Date().getTime());
                xhr.send(null);
            }
        }
    </script>
</head>
<body>
<input type="button" id="bt1" value="显示商品"/>
<hr/>
<div id="table"></div>
</body>
</html>
