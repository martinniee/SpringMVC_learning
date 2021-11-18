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
    /**
     * 方法说明: preHandle()
     *  - 作用: 此方法是预先处理请求的方法,用于决定请求是否执行
     *  - 参数:
     *      - Object handler: 表示被拦截的控制器对象,如'MyController
     *  - 返回值: boolean
     *      - true: 当返回值为 true时表示请求正确,可以被controller处理
     *
     *  - 执行时间: 预处理方法的执行时间是在控制器方法执行前执行
     *  - 作用场景: 此方法可以对请求做处理,如登录检查,权限判断,统计数据等
     *
     *
     *
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========MyInterceptor拦截器的第一个方法preHandler===========");
        // 当返回值为为false时,请求被拦截,需要给用户提示信息
        // 手动响应视图
//        request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("===========MyInterceptor拦截器的第二个方法postHandle===========");
        // 对请求做第二次拦截

        if(mv !=null){
            // 修改数据
            mv.addObject("mydate",new Date());
            // 修改视图
            mv.setViewName("other");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========MyInterceptor拦截器的第三个方法afterCompletion===========");

        // 完整返回视图后,的收尾工作

        // 1、获取数据
        HttpSession session = request.getSession();
        Object attr = session.getAttribute("attr");
        System.out.println("attr= " + attr);

        // 2、删除数据
        session.removeAttribute("attr");

        // 3、删除后检查是否删除成功
        attr = session.getAttribute("attr");
        System.out.println("删除后,再次检查数据是否存在: " + attr);
    }
}
