package com.ji.springboot.controller;

import com.ji.springboot.exception.UserNotExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class HelloController {


    @RequestMapping("/")
    public String index(){
        return  "index";
    }

    @RequestMapping("/index.html")
    public String indexT(){
        return  "index";
    }

    /*@RequestMapping("/")
    public ModelAndView modelAndView(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index");
        return mv;
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello( @RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new  UserNotExistException();
        }
        return  "Hello World";
    }



  /*  //查出一些数据，在页面展示
    //classpath:/templates/success.html
    @RequestMapping("/success")
    public  String success(Map<String, Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","liming"));
        return  "success";
    }
*/

}
