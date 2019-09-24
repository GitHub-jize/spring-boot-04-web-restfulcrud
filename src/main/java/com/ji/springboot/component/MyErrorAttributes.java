package com.ji.springboot.component;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


@Component   //加入到容器中才起作用
public class MyErrorAttributes extends DefaultErrorAttributes {

   /* @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map =getErrorAttributes(webRequest ,includeStackTrace);
        map.put("code","dsfsafds");
        map.put("info","deadad");
        return map;
    }*/

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map =super.getErrorAttributes(webRequest ,includeStackTrace);
        map.put("dsfds","sdfs");
        //我们异常处理器携带的数据
        Map<String,Object> ext =(Map<String,Object>)webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
