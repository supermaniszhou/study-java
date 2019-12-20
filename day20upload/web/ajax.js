function getXhr() {
    var xmlhttp;
    try {
        xmlhttp = new XMLHttpRequest();
    } catch (e) {
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("你的浏览器不支持ajax");
                return false;
            }
        }
    }
    return xmlhttp;
}
