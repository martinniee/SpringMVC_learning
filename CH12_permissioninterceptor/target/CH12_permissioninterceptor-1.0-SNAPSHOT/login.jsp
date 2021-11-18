<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录操作</title>
</head>
<body>

<h3>登录操作</h3>
<%--使用session设置数据,模拟登录--%>
<%
    session.setAttribute("username","zhangsan");
%>
</body>
</html>
