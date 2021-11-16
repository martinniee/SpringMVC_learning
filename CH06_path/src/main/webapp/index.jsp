<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
    + ":" + request.getServerPort() + request.getContextPath() + "/" ;

    // https://localhost:8080/CH06_path/

%>


<html>
<head>
    <title>请求方式</title>
    <base href="<%=basePath%>">

</head>
<body>
    <p>测试请求路径首字符"/"的情况</p>
<%--    <a href="${pageContext.request.contextPath}/test/some.do">发起请求test/some.do</a>--%>
    <a href="test/some.do">发起请求test/some.do</a>
    <br/>
    <a href="http://www.baidu.com" >我是有协议开头的地址</a>
</body>
</html>
