package com.shop.controller;

import com.shop.service.FirDSNowDayRevenueService;
import com.shop.service.impl.TidDSUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * (OcCurrentDayRevenue)表控制层
 *
 * @author makejava
 * @since 2021-08-23 16:20:50
 */
@RestController
@RequestMapping("/web/nowDayRevenue")
@Api(value = "商品类型及销量相关的接口", tags = "第一数据源销量接口", description = "商品类型以及销量的相关操作")
public class FirDSNowDayRevenueController {
    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);
    /**
     * 服务对象
     */
    @Autowired
    private FirDSNowDayRevenueService firDSNowDayRevenueService;

    @GetMapping("/getAll")
    @ResponseBody
    @ApiOperation(value = "获取所有销量接口",notes = "获取所有销量接口",produces = "appliaction/json")
    public Map getAll(){
        Map map = firDSNowDayRevenueService.getAll();
        return map;
    }

    @GetMapping("/getMoneyBypolylineId")
    @ResponseBody
    @ApiOperation(value = "通过折线id获取销量",notes = "通过折线id获取销量",produces = "appliaction/json")
    public Map getMoneyBypolylineId(int polylineId){
        Map map = firDSNowDayRevenueService.getMoneyBypolylineId(polylineId);
        return map;
    }



    @PostMapping("/insertOrUpdateRevenue")
    @ResponseBody
    @ApiOperation(value = "新增销量",notes = "新增销量",produces = "appliaction/json")
    public Map insertOrUpdateRevenue(float money,int type1, String date) throws ParseException {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format1.parse(date);
        log.info("parse"+parse);
        Map map = firDSNowDayRevenueService.insertOrUpdateRevenue(money,type1,parse);
        return map;
    }

}
