package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author nathan
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========MyInterceptor111111111拦截器的第一个方法preHandler===========");

        String username="";
        // 获取登录的账号信息
        Object attr = request.getSession().getAttribute("username");
        // 判断账号信息非空,则将Object类型强转为String类型
        if( attr != null){
            username = (String)attr; // 强转
        }
        // 判断账号
        if("zhangsan".equals(username)){
            return true;
        }else {
            // 当账号没有通过拦截,提示用户信息
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("===========MyInterceptor111111111111拦截器的第二个方法postHandle===========");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========MyInterceptor1111111111111拦截器的第三个方法afterCompletion===========");

    }
}
