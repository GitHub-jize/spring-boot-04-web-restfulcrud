package com.ji.springboot.config;
import com.ji.springboot.component.LoginIntercepter;
import com.ji.springboot.component.MyLocalResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       //registry.addViewController("/").setViewName("index");
       // registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

//注册拦截器
 /*   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").    //拦截所有请求
                excludePathPatterns("/","index.html","/user/login");    //排除哪些请求
    }*/

//国际化
    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocalResolver();
    }
}
