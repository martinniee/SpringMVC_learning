<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求方式</title>
<%--    引入jquery--%>
    <script type="text/javascript" src="js/jquery-3.4.1.js" ></script>
<%--    编写触发AJax脚本--%>
    <script type="text/javascript">
        $(function (){
            // 绑定事件
            $("#btnAjax").on("click",function () {
                // 编写Ajax代码
                $.ajax({
                    // 表示请求的映射地址
                    // url:"return-void-ajax.do",
                    // url:"doStudentJson.do",
                    // url:"doListJsonArray.do",
                    url:"doStringData.do",
                    data:{
                        name:"lisi",
                        age:20
                    },
                    // dataType:"json",
                    dataType:"text",
                    success:function (resp){
                        // resp 是自定义的参数,相当于HttpRequest.responseText;
                        // alert("resp==="+resp);
                        // $.each(resp,function (i,n){
                        //     // n表示 {"name":"李四同学","age":26}单个对象
                        //     alert("n name= " + n.name + "===ageg= " + n.age );
                        // })
                        alert("resp==" + resp);
                    }
                })
            })
        })

    </script>

</head>
<body>
    <p>控制器方法返回String逻辑视图名称</p>
    <form action="return-string-view.do" method="post">
        姓名: <input type="text" name="name">
        年龄: <input type="text" name="age">
        <input type="submit" value="对象接收参数">
    </form>

    <br>
    <br>
<%--制作按钮发起Ajax请求--%>
    <button id="btnAjax">发起Ajax请求</button>
</body>
</html>
