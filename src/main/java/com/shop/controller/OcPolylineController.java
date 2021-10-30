package com.shop.controller;

import com.shop.service.OcPolylineService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/OcPolyline")
public class OcPolylineController {

    @Autowired
    private OcPolylineService polylineService;

    @PostMapping("/getAllPolyline")
    @ResponseBody
    public Map getAllPolyline(){
        return polylineService.getAllPolyline();
    }

    @PostMapping("/insertPolyLineType")
    @ResponseBody
    public Map insertPolyLineType(String polylineName ,String polylineType){
        return polylineService.insertPolyLineType(polylineName,polylineType);
    }

}
