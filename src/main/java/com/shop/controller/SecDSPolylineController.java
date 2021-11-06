package com.shop.controller;

import com.shop.service.SecDSPolylineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/OcPolyline")
@Api(value = "折线类型接口",tags = "第二数据源折线类型接口", description = "折线相关操作")
public class SecDSPolylineController {

    @Autowired
    private SecDSPolylineService polylineService;

    @PostMapping("/getAllPolyline")
    @ResponseBody
    @ApiOperation(value = "获取所有折线类型",notes = "获取所有折线类型",produces = "application/json")
    public Map getAllPolyline(){
        return polylineService.getAllPolyline();
    }

    @PostMapping("/insertPolyLineType")
    @ResponseBody
    @ApiOperation(value = "新增折线类型",notes = "新增折线类型",produces = "application/json")
    public Map insertPolyLineType(String polylineName ,String polylineType){
        return polylineService.insertPolyLineType(polylineName,polylineType);
    }

}
