package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller

public class MyController {

    /*
     任务: 逐个接收请求参数
     要求: 请求中参数名和控制器方法的形参名一样,按名称对应接收请求参数
     目的: 指定所要请求的参数名(通过请求控制器方法的参数)
     */
    @RequestMapping(value ="/receive-property.do")
    public ModelAndView doPropertyParam(String name, Integer age){

        System.out.println("执行了Mycontroller的doPropertyParam()方法name= " + name + " age=" + age);
        ModelAndView mv = new ModelAndView();

        // 添加数据
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");
        return mv ;

    }

    /**
     * 案例: 逐个接收请求参数,实参名和形参名不一致
     * @RequestParam: 可以解决由实参和形参不一致导致的获取值为空的情况
     * 具体解决方法是在控制器方法中指定实参名
     *   属性:
     *      value 表示请求中 参数的名称(实参)
     *      required:  boolean类型(默认为true)表示请求中必须带有参数,可以指定required = false,
     *          表示请求中可以不带参数(不填写)
     *   位置: 在形参定义之前注解
     */
    @RequestMapping(value ="/receive-param.do")
    public ModelAndView doReceiveParam(@RequestParam(value = "rname", required = false) String name,
                                       @RequestParam(value ="rage", required = false)    Integer age){

        System.out.println("执行了Mycontroller的doReceiveParam()方法name= " + name + " age=" + age);
        ModelAndView mv = new ModelAndView();

        // 添加数据
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");
        return mv ;

    }


    /**
     * 使用对象接收请求的参数
     * 要求: 参数名和Java对象名保持一致
     *      Java类需要有一个无参构造方法,和一一个设置值的set方法
     *
     *
     * 框架的处理
     *  1.框架使用Student的无参构造创建Student的对象(IOC创对象)
     *  2.框架使用 Student类的set方法通过传入的请求参数值设置对象的值(IOC注入属性)
     *      例如: 参数是name,调用setName()方法传入请求参数值给对象属性name
     */
    @RequestMapping(value ="/receive-object.do")
    public ModelAndView doReceiveObject (Student student){
        System.out.println("MyController中的方法doReceiveObject= " + student);

        // 创建ModelAndView

        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());

        // 转发给视图
        mv.setViewName("show");
        return mv;
    }

}
