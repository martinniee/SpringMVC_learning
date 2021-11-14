<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求方式</title>
</head>
<body>
    <form action="receive-property.do" method="post">

        姓名: <input type="text" name="name">  <br/>
        年龄: <input type="text" name="age">   <br/>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <br>
    <p>逐个接收请求参数: 请求中参数名和控制器方法中形参值不一致的情况</p>
    <form action="receive-param.do" method="post">

        姓名: <input type="text" name="rname">  <br/>
        年龄: <input type="text" name="rage">   <br/>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <br>
    <p>对象接收请求参数: 请求中参数名和控制器方法中形参值一致</p>
    <form action="receive-object.do" method="post">

        姓名: <input type="text" name="name">  <br/>
        年龄: <input type="text" name="age">   <br/>
        <input type="submit" value="对象接收参数">
    </form>

</body>
</html>
