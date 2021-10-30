package com.shop.service;

import com.shop.entity.OcCurrentDayRevenue;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (OcCurrentDayRevenue)表服务接口
 *
 * @author makejava
 * @since 2021-08-23 16:20:48
 */
public interface OcCurrentDayRevenueService {

    //查询折线图收入数据
    Map getAll();

    Map insertOrUpdateRevenue(float money,int type, Date date);

    Map getMoneyBypolylineId(int id);


}
