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

      使用控制器方法返回值ModelAndView实现转发forward
        格式: ModelAndView对象.setViewName("forward: 视图完整路径")
        实例: mv.setViewName("forward: /WEB-INF/view/show.jsp")

      forward特点: 单独生效,不合视图解析冲突,相当忽略视图解析器

     */

    @RequestMapping(value ="/doforward.do")
    public ModelAndView doForward(){

        System.out.println("执行了doforward.do请求的doForward()方法");
        ModelAndView mv = new ModelAndView();
        // 添加数据
        mv.addObject("msg","处理了some.do请求");
        mv.addObject("fun","执行了doSome()方法");

       // 使用forward显式转视图(因为,不用forward,框架也会进行转发操作)
        mv.setViewName("forward:/WEB-INF/view/show.jsp");

        return mv ;
    }

    /*
      需求: 控制器方法返回值为ModelAndView时实现重定向 redirect
        格式: ModelAndView对象.setViewName("redirect: 视图文件完整路径")
        实例: mv.setViewName("redirect: /WEB-INF/view/show.jsp")
        redirect特点: 和forward类似不和视图解析器工作,如同不存在视图解析器
     */
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age){

        System.out.println("doRedirect, name=" + name + " ,age=" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        // 重定向到视图
        mv.setViewName("redirect:/other.jsp");

        return mv;


    }
}
