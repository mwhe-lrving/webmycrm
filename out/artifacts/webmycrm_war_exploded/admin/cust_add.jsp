<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加客户</title>
</head>
<body>
<form name="frmadd" method="post" action="${pageContext.request.contextPath}/admin/docust?op=doadd">
    客户名称：<input name="custname" type="text"/></br>
    联系人：<input name="contacts" type="text"/></br>
    邮箱：<input name="email" type="email"/></br>
    电话：<input name="tel" type="tel"/></br>
    <input name="resetbtn" type="reset" value="重置"/>
    <input name="addbtn" type="submit" value="添加"/>
</form>
</body>
</html>
