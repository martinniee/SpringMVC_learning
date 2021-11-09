package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nathan
 */
/*
1、添加注解 @Controller
 作用: 创建控制器(处理器)对象
 控制器定义: 也称后端控制器(back controller),自定义类处理请求
 位置: 位于类上,表示创建这个类对象,放置在springmvc容器中
 结果: 添加注解 @Controller后,  MyController类作为控制器放置在springmvc容器中
 */

@Controller
public class MyController {

    /*
    2、定义方法
        名称: 控制器方法,能处理请求的方法
        概念: springmvc框架: 使用控制器类中的方法处理请求
        特点:
            方法形参: 表示请求中的参数
            返回值: 表示此时请求的处理结果 ModelAndView


    3、使用注解 @RequestMappng(请求映射注解)
        属性: value,请求中的uri地址，唯一值,以"/"开头
        位置: 方法上(必须),类定义上(可选)
        作用: 将指定的请求交给指定的方法处理,设置的注解的方法就是「指定」的方法,等同url-pattern
        实例分析:
            /some.do: "/" 表示根, "some.do" 表示uri
            如果请求地址访问资源是 http://端口/虚拟目录/some.do,则 根据映射,会调用doSome()方法
            此时的请求是通过超链接 <a href="some.do">发起some.do请求</a> 发起的
     */
    // 此时的doSome() 相当于servlet的 doGet()

    @RequestMapping(value = {"/some.do","first.do"})
    public ModelAndView doSome(){

        /*
        4、创建ModelAndView

         */
        System.out.println("执行了do.some请求的doSome()方法");
        ModelAndView mv = new ModelAndView();
        // 添加数据
        mv.addObject("msg","处理了some.do请求");
        mv.addObject("fun","执行了doSome()方法");

        // 指定显示数据的视图
//        mv.setViewName("/show.jsp");
//        mv.setViewName("/WEB-INF/view/show.jsp");

        /*
         当配置了视图解析器后,就可以使用视图文件的文件名做作为视图名使用,此时的视图名称为「视图逻辑名称」
         使用视图解析器后,框架会使用配置文件将设置的是视图解析器中的前缀和后缀与视图逻辑名称进行拼接
         形成更完整的 视图文件路径
         */
        // /WEB-INF/view/ + show + .jsp
        // 得到了  /WEB-INF/view/show.jsp
        mv.setViewName("show");


        // 返回结果
        return mv ;
        /*
         ModelAndView使用原理:
            当框架调用完doSome()方法后,得到返回的ModelAndView
            框架会在后续的处理逻辑中处理mv对象中的数据和视图
                情况1: 对数据执行 request.setAttribute("msg","处理了some.do请求");
                    即把数据交给了request(放入到request的作用域)
                    【自动的过程】: 当添加数据到ModelAndView,自动将数据放入request作用域
                情况2: 对视图进行转发操作
                    等同request.getRequestDispatcher(".show.jsp").forward(..);

         */
    }
    @RequestMapping(value = {"other.do","/test/second.do"})
    public ModelAndView doOther(){

        System.out.println("执行了other.do请求的doOther()方法");
        ModelAndView mv = new ModelAndView();
        // 添加数据
        mv.addObject("msg","执行了other.do请求");
        mv.addObject("fun","执行了doOther()方法");
        mv.setViewName("other");


        // 返回结果
        return mv ;
    }

}
