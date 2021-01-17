package com.testgradution.testgradution.config;

import com.testgradution.testgradution.domain.Admin;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *学习springboot拦截器的使用，只需要拦截loginStatus这个url即可
 */
@Component
public class Intpertor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 即springmvc中的前置拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
//            Admin user=(Admin) request.getSession().getAttribute("username");
            Object user=request.getSession().getAttribute("username");
            if(user==null){
                request.getSession().setAttribute("msg","请先登录");
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }
}
