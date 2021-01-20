//package com.testgradution.testgradution.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class IntepertorConfig implements WebMvcConfigurer {
//    @Autowired
//    Intpertor intpertor;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //addInterceptor添加拦截规则  /**表示拦截所有请求
//        //   excludePathPatterns表示排除拦截，登录界面我们不需要拦截。
//        registry.addInterceptor(intpertor).addPathPatterns("/**").excludePathPatterns("/admin/loginStatus");
//    }
//}
