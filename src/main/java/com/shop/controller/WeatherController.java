package com.shop.controller;

import com.shop.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/QueryWeather")
@Api(value = "天气接口",tags = "天气相关接口", description = "对接第三方中国天气网查询天气")
public class WeatherController {



    @Autowired
    private WeatherService weatherService;

    @GetMapping("/QueryDayWeather")
    @ApiOperation(value = "查询天气",notes = "查询天气",produces = "application/json")
    public Map QueryWeather() {
        return weatherService.queryWeather();
    }

}
