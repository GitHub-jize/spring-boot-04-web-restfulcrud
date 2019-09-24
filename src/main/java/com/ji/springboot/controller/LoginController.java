package com.ji.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

    @Controller
    public class LoginController {

        //@RequestMapping(value =" /user/login",method = RequestMethod.POST)
        @PostMapping( value = "/user/login")
        public String Login(@RequestParam("username")String username,
                            @RequestParam("password")String password,
                            Map map,HttpSession session){

            if(!StringUtils.isEmpty(username) && "123456".equals(password)){
                session.setAttribute("LoginUser",username);
                return "redirect:/main.html"; //防止表单重复提交 F5  进行重定向
            }else {
                map.put("msg","密码错误");
                return "index";
            }
        }
}
