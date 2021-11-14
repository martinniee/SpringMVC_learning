package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller

public class MyController {
    /*
     控制器方法String返回值,表示逻辑名称,需要在项目中配置视图解析器
     */

    @RequestMapping(value ="/return-string-view.do")
    public String doReturnStringView1(HttpServletRequest request, String name, Integer age){

        System.out.println("执行了Mycontroller的doReturnStringView1()方法name= " + name + " age=" + age);
        // 使用request来处理数据
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        // 返回结果,forward到show.jsp
        return "show" ;

    }


    /**
     *控制器方法返回是void,响应ajax请求,使用HttpServletReponse输出数据
     */

    @RequestMapping("/return-void-ajax.do")
    public void returnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("处理void返回类型, name= " + name + ",age= " + age);

        // 调用service得到结果对象
        Student student = new Student();
        student.setName(name+"同学");
        student.setAge(age);

        // 转化对象为json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(student);
        System.out.println("服务器端对象转为json===="+ json);

        // 输出json,响应ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }






    /*
          需求: 控制器方法返回值为student,转化为json响应给浏览器
          Content-Type: application/json;charset=utf-8

          框架处理过程:
            1、框架根据控制器方法的返回值类型,找到HttpMessageConverter接口,找到对应的实现类对象
                最后找到MappingJackson2HttpMessageConverter处理 Student
            2、使用实现类执行器write()方法,将student转换为json格式
            3、框架使用@ResponseBody注解,将json格式数据给response对象后响应给浏览器

            响应头中数据格式是"application/json;charset=utf-8",但没有进行设置,说明隐式的被设置了
            具体是和MappingJackson2HttpMessageConverter这个类有关

       */
    @RequestMapping("/doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name, Integer age){
        System.out.println("控制器方法返回自定义对象Student,转为json: " + name + "==" + age);

        // 创建对象,设置值
        Student student = new Student();
        student.setName("同学"+ name);
        student.setAge(age);

        return student;
    }

    /*
          需求: 控制器方法返回值为list集合: list<Stuent> ➞ json array

       */
    @RequestMapping("/doListJsonArray.do")
    @ResponseBody
    public List<Student> doAjaxJsonArray(String name, Integer age){
        System.out.println("控制器方法返回List<Student>,转换为jsonarray: " + name + "==" + age);

        // 创建对象,设置值
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(20);
        // 创建对象,设置值
        Student student1 = new Student();
        student1.setName("张三同学"+ name);
        student1.setAge(23);

        // 创建集合
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);

        return list;
    }

    /*
        解决中文: 需要使用@RequestMapping的produces属性
            produces属性: 指定content-type的值


          StringHttpMessageConverter


     */
    @RequestMapping(value = "doStringData.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age){
        System.out.println("控制器方法返回String,是数据");

        return "Hello SpringMVC注解式开发";
    }

}
