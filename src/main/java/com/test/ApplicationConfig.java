package com.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.beans.BeanProperty;

//configuration  of the SpringMVC features for this app
@Configuration
@ComponenetScan(basePackages= "com.test")
public class ApplicationConfig extends WebMvcConfigurationSupport{
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistr registry){
        registry.addResourceHandlers("css/**", "images/**").addResourceLocations("classpat:/css/", "classpath:/images/");
         //tell spring where to pick the STATIC content
    }

    @Bean
    public InternalReourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return  viewResolver;
    }
}
