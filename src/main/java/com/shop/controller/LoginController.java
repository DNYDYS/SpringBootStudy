package com.shop.controller;

import com.shop.entity.UserBean;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    //将Service注入Web层
    @Autowired
    UserService userService;

    @Autowired
    private QueryWeatherController queryWeatherController;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserBean userBean = userService.loginIn(name,password);
        String s = queryWeatherController.QueryWeather();
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }



}
