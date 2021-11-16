package com.bjpowernode.controller;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyUserException;
import com.bjpowernode.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller

public class MyController {


    @RequestMapping(value ="/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {

        // 抛出异常
        if(!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }
        if(age == null || age.intValue() > 80){
            throw new AgeException("年龄太大了");
        }

        System.out.println("执行了some.do请求的doSome()方法");
        ModelAndView mv = new ModelAndView();
        // 添加数据
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv ;
    }

}
