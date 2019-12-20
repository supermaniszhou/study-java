<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-12-20
  Time: 上午 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/ajax.js"></script>
    <script>
        /*
		<provinces>
		  <province code="37" name="山东省">
		    <city code="1" name="济南市"/>
		    <city code="2" name="青岛市"/>
		    <city code="3" name="淄博市"/>
		  </province>
		  <province code="42" name="湖北省">
		    <city code="1" name="武汉市"/>
		    <city code="2" name="黄冈市"/>
		    <city code="3" name="襄阳市"/>
		  </province>
		  <province code="41" name="河南省">
		    <city code="1" name="郑州市"/>
		    <city code="2" name="开封市"/>
		    <city code="3" name="洛阳市"/>
		  </province>
		</provinces>
		*/
        var xmlDoc;
        window.onload = function () {
            var xhr = getXhr();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        xmlDoc = xhr.responseXML;
                        //给省份赋值：xml dom和html dom
                        //1、解析XML文档，得到所有的province元素
                        var xmlProvinces = xmlDoc.getElementsByTagName("province");
                        //2、遍历province元素，得到他的属性code 和name的值
                        for (var i = 0; i < xmlProvinces.length; i++) {
                            var codeValue = xmlProvinces[i].getAttribute("code");
                            var nameValue = xmlProvinces[i].getAttribute("name");
                            //3、创建HTML中的option对象，给id=p1的元素添加子元素
                            var o = new Option(nameValue, codeValue);
                            document.getElementById("provice").add(o);
                        }
                    }
                }
            }
            xhr.open("GET", "${pageContext.request.contextPath}/demo4?time=" + new Date().getTime());
            xhr.send(null);
        }

        function getCitys(provinceObj) {
            var selectValue = provinceObj.value;
            //清除城市下拉内容
            document.getElementById("city").length = 1;
            var xmlProvinces = xmlDoc.getElementsByTagName("province");
            for (var i = 0; i < xmlProvinces.length; i++) {
                if (selectValue == xmlProvinces[i].getAttribute("code")) {
                    var xmlCitys = xmlProvinces[i].getElementsByTagName("city");
                    for (var j = 0; j < xmlCitys.length; j++) {
                        var value = xmlCitys[j].getAttribute("code");
                        var name = xmlCitys[j].getAttribute("name");
                        var op = new Option(name, value);
                        document.getElementById("city").add(op);
                    }
                }
            }
        }

    </script>
</head>
<body>
省份:<select id="provice" onchange="getCitys(this)">
    <option value="">--请选择--</option>
</select>
城市:<select id="city">
    <option value="">--请选择--</option>
</select>
</body>
</html>
