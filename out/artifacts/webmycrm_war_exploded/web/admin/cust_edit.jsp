<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改客户信息</title>
</head>
<body>
<form name="frmadd" method="post" action="${pageContext.request.contextPath}/admin/docust?op=doedit">
    客户名称：<input name="custname" type="text" value="${requestScope.cust.custname}"/></br>
    联系人：<input name="contacts" type="text" value="${requestScope.cust.contacts}"/></br>
    邮箱：<input name="email" type="email" value="${requestScope.cust.email}"/></br>
    电话：<input name="tel" type="tel" value="${requestScope.cust.tel}"/></br>
    <input name="resetbtn" type="reset" value="重置"/>
    <input name="addbtn" type="submit" value="修改"/>
    <input name="custid" type="hidden" value="${requestScope.cust.custid}"/></br>
</form>
</body>
</html>
