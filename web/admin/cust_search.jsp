<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理</title>
</head>
<body>

<form name="frmsearch" action="${pageContext.request.contextPath}/admin/docust?op=search" method="post">
    <input type="text" name="custname" value="${requestScope.condition.custname}">
    <input class="btnsearch" type="submit" value="查询">
</form>

<table>
    <tr>
        <th>编号</th>
        <th>客户名</th>
        <th>联系人</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${requestScope.custs}" var="cust">
        <tr>
            <td>${cust.custid}</td>
            <td>${cust.custname}</td>
            <td>${cust.contacts}</td>
            <td>${cust.tel}</td>
            <td>${cust.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/docust?op=toedit&custid=${cust.custid}">修改</a>
                &nbsp;|&nbsp;
                <a onclick="return confirm('是否删除？')" href="${pageContext.request.contextPath}/admin/docust?op=dodel&custid=${cust.custid}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <c:if test="${requestScope.pageindex>1}">
                <a href="${pageContext.request.contextPath}/admin/docust?op=search&custname=${requestScope.condition.custname}&pageindex=1">首页</a>
                <a href="${pageContext.request.contextPath}/admin/docust?op=search&custname=${requestScope.condition.custname}&pageindex=${requestScope.pageindex-1}">上一页</a>
            </c:if>
            <c:if test="${requestScope.pageindex <= 1}">
                首页 上一页
            </c:if>
            <c:if test="${requestScope.pageindex < requestScope.pagecount}">
                <a href="${pageContext.request.contextPath}/admin/docust?op=search&custname=${requestScope.condition.custname}&pageindex=${requestScope.pageindex+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/admin/docust?op=search&custname=${requestScope.condition.custname}&pageindex=${requestScope.pagecount}">末页</a>
            </c:if>
            <c:if test="${requestScope.pageindex >= requestScope.pagecount}">
                下一页 末页
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
