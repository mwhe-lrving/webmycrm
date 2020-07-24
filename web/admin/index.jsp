<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Title</title>
    <meta charset="utf-8" />
    <title>网页</title>
    <frameset rows="20,80" cols="*" frameborder="yes" border="1" framespacing="1">
        <frame src="top.jsp" name="top" scrolling="no" noresize>
        <frameset cols="10,85" frameborder="yes" border="1" framespacing="1">
            <frame src="left.jsp" name="left" scrolling="no" noresize>
            <frame src="main.jsp" name="main_page" scrolling="no" noresize>
        </frameset>
    </frameset>
</head>

<%--<frames rows="25%,*">--%>
<%--    <iframe src="${pageContext.request.contextPath}/admin/top.jsp"/>--%>
<%--    <frames columns="25%,*">--%>
<%--        <iframe src="${pageContext.request.contextPath}/admin/left.jsp"/>--%>
<%--        <iframe src="${pageContext.request.contextPath}/admin/main.jsp" name="main"/>--%>
<%--    </frames>--%>
<%--</frames>--%>
<body>

<%--<h1>--%>
<%--    欢迎${sessionScope.loginemp.realname}--%>
<%--    <a href="${pageContext.request.contextPath}/admin/cust_list.html">首页</a>--%>
<%--    <a href="cust_add.jsp">添加</a>--%>

<%--</h1>--%>
</body>
</html>
