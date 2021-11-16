package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author nathan
 */
/*
1、添加注解 @Controller
 作用: 创建控制器(处理器)对象
 控制器定义: 也称后端控制器(back controller),自定义类处理请求
 位置: 位于类上,表示创建这个类对象,放置在springmvc容器中
 结果: 添加注解 @Controller后,  MyController类作为控制器放置在springmvc容器中


@RequestMapping
    属性: value,表示所有请求地址的公共前缀,相当于是模块名称
 */


@Controller

public class MyController {


    /*
    属性
        method:
            表示指定请求的方法,使用RequestMethod类的枚举值
            实例: 如get请求方式,RequestMethod.GET
     */

    // 指定some.do使用get请求方式
    @RequestMapping(value ="/some.do",method = RequestMethod.GET)
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

    // 如果请求方式不一样,则错误码是 405,表示请求方式不支持
    //指定other.do的请求方式为post
    @RequestMapping(value = {"/other.do","/second.do"},method = RequestMethod.POST)
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

    // 不指定Method属性,请求方式无限制
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session){

        System.out.println("执行了doFirst()方法");

        String name = request.getParameter("name");
        ModelAndView mv = new ModelAndView();
        // 添加数据
        mv.addObject("msg","执行了first.do请求,name=" + name);
        mv.addObject("fun","执行了doFirst()方法");
        mv.setViewName("other");


        // 返回结果
        return mv ;
    }

}
