
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>show</title>
</head>
<body>

<h1>/WEB-INF/view/other.jsp用于显示request作用域中的数据</h1>

<h2>方式2: 使用get请求方式中的param参数集合对象获取第二次请求中的参数值</h2>
<h3>myname: ${param.myname}</h3>
<h3>myage: ${param.myage}</h3>
<h2>方式1： 使用第二次请求的Get方式中的参数作为返回结果数据</h2>
<h3><%=request.getParameter("myname")%> </h3>

</body>
</html>
