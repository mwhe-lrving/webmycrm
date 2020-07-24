<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录页面</title>
  </head>
  <body>
  <form name="frmlogin" method="post" action="${pageContext.request.contextPath}/doLogin">
    用户名：<input name="username" value="1" type="text"/></br>
    密 码：<input name="password" value="1" type="password"/></br>
    <input name="resetbtn" type="reset" value="重置"/>
    <input name="loginbtn" type="submit" value="登录"/>
    <%=Thread.currentThread().getName()%>
  </form>

  </body>
</html>
