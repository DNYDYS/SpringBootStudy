package com.shop.service;

import java.util.Date;
import java.util.Map;

/**
 * (OcCurrentDayRevenue)表服务接口
 *
 * @author makejava
 * @since 2021-08-23 16:20:48
 */
public interface FirDSNowDayRevenueService {

    //查询折线图收入数据
    Map getAll();

    Map insertOrUpdateRevenue(float money,int type, Date date);

    Map getMoneyBypolylineId(int id);


}
