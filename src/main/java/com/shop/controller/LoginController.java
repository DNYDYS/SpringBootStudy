package com.shop.controller;

import com.shop.entity.User;
import com.shop.service.TidDSUserService;
import com.shop.service.impl.TidDSUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);

    //将Service注入Web层
    @Autowired
    TidDSUserService tidDSUserService;

    @Autowired
    private WeatherController weatherController;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        User user = tidDSUserService.loginIn(name,password);
        String s = weatherController.QueryWeather();
        if(user !=null){
            return "success";
        }else {
            return "error";
        }
    }



}
