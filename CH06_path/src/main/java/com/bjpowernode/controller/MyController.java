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

    @RequestMapping(value ="test/some.do")
    public ModelAndView doSome(){

        System.out.println("执行了Mycontroller的doSome()方法");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.jsp");
        return mv; // 返回视图

    }
}
