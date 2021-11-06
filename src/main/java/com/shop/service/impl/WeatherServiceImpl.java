package com.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shop.codes.EnumStatusCode;
import com.shop.config.WeatherConfig;
import com.shop.entity.Weather;
import com.shop.service.WeatherService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    private Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);
    //对接中国天气网。查询天气
    private final String apiURL = "https://www.tianqiapi.com/free/day?appid=48212483&appsecret=4nrJutXf&unescape=1";

    @Autowired
    private WeatherConfig weatherConfig;

    @Override
    public Map queryWeather() {
//        String apiURL = "https://www.tianqiapi.com/free/day?appid=48212483&appsecret=4nrJutXf&unescape=1";

        Map map = new HashMap();
        ResponseEntity<String> responseEntity = weatherConfig.restTemplate().getForEntity(apiURL, String.class);
        if (200 == responseEntity.getStatusCodeValue()) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            Weather weather = JSON.parseObject(String.valueOf(jsonObject), Weather.class);
            map.put("weather",weather);
            map.put("code", EnumStatusCode.SUCCESS.getCode());
            map.put("desc", EnumStatusCode.SUCCESS.getDesc());
            return map;
        } else {
            map.put("code", EnumStatusCode.FAILD.getCode());
            map.put("desc", EnumStatusCode.FAILD.getDesc());
//            return "error with code : " + responseEntity.getStatusCodeValue();
            return map;
        }
    }
}
