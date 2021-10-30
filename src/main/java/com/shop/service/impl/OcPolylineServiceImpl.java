package com.shop.service.impl;

import com.shop.entity.OcCurrentDayRevenue;
import com.shop.entity.OcPolylineData;
import com.shop.mapper.OcCurrentDayRevenueDao;
import com.shop.mapper.OcPolylineDataMapper;
import com.shop.service.OcPolylineService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Service
public class OcPolylineServiceImpl implements OcPolylineService {

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private OcPolylineDataMapper polylineDataMapper;

    @Autowired
    private OcCurrentDayRevenueDao ocCurrentDayRevenueDao;

    @Override
    public Map getAllPolyline() {
        Map map = new HashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<OcPolylineData> ocPolylineDataList = polylineDataMapper.selectAllType();
        List<String> poleTypeNameList = new ArrayList<>();
        List<String> days = new ArrayList<>();
        for (OcPolylineData o : ocPolylineDataList) {
            poleTypeNameList.add(o.getPolylineName());
            List<OcCurrentDayRevenue> allDataByTypeId = ocCurrentDayRevenueDao.getAllDataByTypeId(o.getId());
            for (OcCurrentDayRevenue ocCurrentDayRevenue : allDataByTypeId) {
                String transformDate = simpleDateFormat.format(ocCurrentDayRevenue.getDate());
                days.add(transformDate);
            }
        }
        //去重
        days = days.stream().distinct().collect(Collectors.toList());
        map.put("polylineDataList",ocPolylineDataList);
        map.put("poleTypeNameList",poleTypeNameList);
        map.put("days",days);
        map.put("Code", 200);
        map.put("Desc", "成功");
        return map;
    }

    /**
     * 新增一个折线类型
     * @param polylineName
     * @param polylineType
     * @return
     */
    @Override
    public Map insertPolyLineType(String polylineName, String polylineType) {
        Map map = new HashMap();
        float money = 0;
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        Integer idByNameType = polylineDataMapper.getIdByNameType(polylineName);
        if (idByNameType == null){
            polylineDataMapper.insertPolyLineType(polylineName,polylineType);
            idByNameType = polylineDataMapper.getIdByNameType(polylineName);
            List<OcPolylineData> ocPolylineDataList = polylineDataMapper.selectAllType();
            List<Date> allDate = ocCurrentDayRevenueDao.getAllDate();
            for (Date date:allDate) {
                ocCurrentDayRevenueDao.insertMoney(money,idByNameType,date);
            }
            dataSourceTransactionManager.commit(transactionStatus);
            map.put("polylineDataList",ocPolylineDataList);
            map.put("Code", 200);
            map.put("Desc", "成功");
//        dataSourceTransactionManager.rollback(transactionStatus);
            return map;
        }else{
            map.put("Code", 20210831);
            map.put("Desc", "已经存在该折线名称");
            return map;
        }
//        dataSourceTransactionManager.commit(transactionStatus);
//        dataSourceTransactionManager.rollback(transactionStatus);
    }
}
