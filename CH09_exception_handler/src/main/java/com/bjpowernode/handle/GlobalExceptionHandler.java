package com.bjpowernode.handle;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 *      注解： @ControllerAdvice
 *      含义: 设置此注解的类表示是用于处理异常的类,是给controller增加功能的
 *      位置: 定义在类的上面
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 任务: 定义处理异常的方法,这个方法是用于当其他类发生异常后,处理异常然后执行此方法
     * 方法参数: public ModelAndView doNameException(Exception e){}
     * 参数说明: Exception e: e表示发生异常的类中抛出的异常对象(用父类接收)
     * 注解使用:
     *      注解: @ExceptionHandler: 设置此注解的方法是用于处理异常的方法
     *      属性: value: 表示异常的类型
     *      位置: 定义在方法上
     *      实例解读: @ExceptionHandler(value = NameException.class)
     *          表示当抛出异常的类抛出的是异常类型是 NameException 就会执行此方法(用此方法处理异常)
     *
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception e){
        /**
         *  发生异常处理内容
         *      1、记录异常,如记录到日志信息中
         *      2、发送通知,如邮件,短信的形式
         *      3、给用户发送友好的提示
         */
        System.out.println("doNameException()处理的被抛出的异常对象: " + e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips","姓名只能是zs");
        mv.setViewName("nameError");
        return mv;
    }
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception e){
        /**
         *  发生异常处理内容
         *      1、记录异常,如记录到日志信息中
         *      2、发送通知,如邮件,短信的形式
         *      3、给用户发送友好的提示
         */
        System.out.println("doAgeException处理的被抛出的异常对象: " + e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips","年龄不能大于80");
        mv.setViewName("ageError");
        return mv;
    }

    /**
     *  任务: 当处理的异常类型不确定时,相应的处理措施
     * @ExceptionHandler: 不填写value值表示处理任何异常类型对象
     *  框架处理逻辑: 先执行用于处理指定异常类型对象的方法,后执行无指定异常对象的方法
     */
    @ExceptionHandler
    public ModelAndView doOtherException(Exception e){
        /**
         *  发生异常处理内容
         *      1、记录异常,如记录到日志信息中
         *      2、发送通知,如邮件,短信的形式
         *      3、给用户发送友好的提示
         */
        System.out.println("doOtherException处理的被抛出的异常对象: " + e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips","请稍后重试");
        mv.setViewName("defaultError");
        return mv;
    }

}
