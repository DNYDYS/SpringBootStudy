package com.shop.util;

import com.alibaba.fastjson.JSONObject;
import com.shop.service.impl.TidDSUserServiceImpl;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class QueryWeatherUtil {
    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);
    private static String APPID = "48212483";
    private static String APPSECRET = "4nrJutXf";

    public String getTemDay(){

        RestTemplate restTemplate =new RestTemplate();
        String apiURL = "https://www.tianqiapi.com/free/day?appid="+APPID+"&appsecret="+APPSECRET+"&unescape=1";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);
        if (200 == responseEntity.getStatusCodeValue()) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            Object tem_day = jsonObject.get("tem_day");
            System.out.println(tem_day);
            Map<String,Object> map = (Map<String,Object>)jsonObject;    //json对象转Map
            /**
             * Map{
             *              "tem_day":"24",//白天温度(高温)
             *              "update_time":"21:12",
             *              "wea":"多云", //天气情况
             *              "win_meter":"7km/h",//风速
             *              "city":"郑州",
             *              "wea_img":"yun", //天气对应图标
             *              "tem_night":"19", //	白天温度(低温)
             *              "win_speed":"2级", //风力等级
             *              "cityid":"101180101",
             *              "air":"31",//空气质量
             *              "tem":"21",//实时温度
             *              "win":"东北风"//风向
             *     }
             *
             */
            //获取当天最高气温
            int temDay = (int) map.get("tem_day");
            return responseEntity.getBody();
        } else {
            return "error with code : " + responseEntity.getStatusCodeValue();
        }
    }

}
