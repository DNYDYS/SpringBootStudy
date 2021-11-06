package com.shop.controller;

import com.shop.entity.User;
import com.shop.service.TidDSUserService;
import com.shop.service.impl.TidDSUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "登录接口",tags = "登录接口", description = "登录接口")
public class LoginController {
    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);

    //将Service注入Web层
    @Autowired
    TidDSUserService tidDSUserService;

    @Autowired
    private WeatherController weatherController;

    @GetMapping("/login")
    public String show(){
        return "login";
    }

    @PostMapping(value = "/loginIn")
    @ApiOperation(value = "登录接口",notes = "登录接口",produces = "application/json")
    public String login(String name,String password){
        User user = tidDSUserService.loginIn(name,password);
//        String s = weatherController.QueryWeather();
        if(user !=null){
            return "success";
        }else {
            return "error";
        }
    }



}
