<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>一个拦截器</title>
</head>
<body>
    <a href="doforward.do">发起doforward.do的请求</a>
    <br/>
    <br/>
    <p>一个拦截器</p>

<form action="some.do" method="post">
    姓名: <input type="text" name="name"> <br/>
    年龄: <input type="text" name="age"> <br/>
    提交: <input type="submit" value="提交"> <br/>
</form>
</body>
</html>
