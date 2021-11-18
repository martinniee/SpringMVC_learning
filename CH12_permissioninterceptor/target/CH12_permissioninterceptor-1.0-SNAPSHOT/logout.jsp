
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出操作</title>
</head>
<body>

    <h3>提出系统!!!</h3>
<%--    删除数据,模拟退出账号--%>
    <%
        session.removeAttribute("username");
    %>
</body>
</html>
