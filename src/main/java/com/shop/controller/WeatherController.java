package com.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.shop.service.impl.TidDSUserServiceImpl;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/web/QueryWeather")
public class WeatherController {
    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/QueryDayWeather")
    public String QueryWeather() {
        String apiURL = "https://www.tianqiapi.com/free/day?appid=48212483&appsecret=4nrJutXf&unescape=1";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);
        if (200 == responseEntity.getStatusCodeValue()) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            Map<String,Object> map = (Map<String,Object>)jsonObject;    //json对象转Map
            log.info(""+map);
            log.info(""+map.get("tem_day"));
            return responseEntity.getBody();
        } else {
            return "error with code : " + responseEntity.getStatusCodeValue();
        }
    }

}
