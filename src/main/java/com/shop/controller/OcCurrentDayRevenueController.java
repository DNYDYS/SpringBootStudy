package com.shop.controller;

import com.shop.service.OcCurrentDayRevenueService;
import com.shop.service.impl.UserServiceImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * (OcCurrentDayRevenue)表控制层
 *
 * @author makejava
 * @since 2021-08-23 16:20:50
 */
@Controller
@RequestMapping("/web/ocCurrentDayRevenue")
public class OcCurrentDayRevenueController {
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * 服务对象
     */
    @Autowired
    private OcCurrentDayRevenueService ocCurrentDayRevenueService;

    @PostMapping("/getAll")
    @ResponseBody
    public Map getAll(){
        Map map = ocCurrentDayRevenueService.getAll();
        return map;
    }

    @PostMapping("/getMoneyBypolylineId")
    @ResponseBody
    public Map getMoneyBypolylineId(int polylineId){
        Map map = ocCurrentDayRevenueService.getMoneyBypolylineId(polylineId);
        return map;
    }



    @PostMapping("/insertOrUpdateRevenue")
    @ResponseBody
    public Map insertOrUpdateRevenue(float money,int type1, String date) throws ParseException {
        log.info("revenue"+money);
        log.info("type"+type1);
        log.info("date"+date);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format1.parse(date);
        log.info("parse"+parse);
        Map map = ocCurrentDayRevenueService.insertOrUpdateRevenue(money,type1,parse);
        return map;
    }

}
