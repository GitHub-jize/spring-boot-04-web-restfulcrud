package com.ji.springboot.controller;

import com.ji.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice   //成为异常处理器
public class MyExceptionHandler {

    /*
     * 1.写一个自定义的异常类
     * 2.@ControllerAdvice   成为异常处理器
     * 3.写一个@ExceptionHandler（处理的异常）
     * 3.return map
     * */

    //游览器客户端返回的都是json,达不到自适应效果
    /*@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public  Map<String,Object> handlerException( Exception e){
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code","sdasdasd");
        map.put("message",e.getMessage());
        return map;
    }*/


    //自适应
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map =new HashMap<String,Object>();
        //-----------传入我们自己的错误状态码 4xx 5xx
        request.setAttribute("javax.servlet.error.status_code",500);
        // request.setAttribute存入你要放的错误信息，并在自己定义的错误消息MyErrorAttributes中取出数据
        map.put("code","sdasdasd");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        //-----------转发到error页面
        return "forward:/error";
    }
}
