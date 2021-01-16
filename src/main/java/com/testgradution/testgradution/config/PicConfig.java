package com.testgradution.testgradution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位用户头像地址
 */
@Configuration
public class PicConfig implements WebMvcConfigurer {

    public  void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("img/peoplePic/*").addResourceLocations(
                "file"+System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"peoplePic"+System.getProperty("file.separator")
        );

    }
}
