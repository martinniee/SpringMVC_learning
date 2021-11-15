package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller

public class MyController {

    @RequestMapping(value ="/some")
    public ModelAndView doReturnStringView1(String name, Integer age){

        System.out.println("执行了Mycontroller的doReturnStringView1()方法name= " + name + " age=" + age);

        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");
        return mv; // 返回视图

    }
}
