package com.shop.service.impl;

import com.shop.entity.NowDayRevenue;
import com.shop.entity.OcPolylineData;
import com.shop.mapper.FirDSNowDayRevenueDao;
import com.shop.mapper.SecDSPolylineMapper;
import com.shop.service.SecDSPolylineService;
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
import org.springframework.stereotype.Service;

@Service
public class SecDSPolylineServiceImpl implements SecDSPolylineService {

    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);

//    @Autowired
//    DataSourceTransactionManager dataSourceTransactionManager;

//    @Autowired
//    private TransactionDefinition transactionDefinition;

    @Autowired
    private SecDSPolylineMapper polylineDataMapper;

    @Autowired
    private FirDSNowDayRevenueDao firDSNowDayRevenueDao;

    @Override
    public Map getAllPolyline() {
        Map map = new HashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<OcPolylineData> ocPolylineDataList = polylineDataMapper.selectAllType();
        List<String> poleTypeNameList = new ArrayList<>();
        List<String> days = new ArrayList<>();
        for (OcPolylineData o : ocPolylineDataList) {
            poleTypeNameList.add(o.getPolylineName());
            List<NowDayRevenue> allDataByTypeId = firDSNowDayRevenueDao.getAllDataByTypeId(o.getId());
            for (NowDayRevenue nowDayRevenue : allDataByTypeId) {
                String transformDate = simpleDateFormat.format(nowDayRevenue.getDate());
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
//        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        Integer idByNameType = polylineDataMapper.getIdByNameType(polylineName);
        if (idByNameType == null){
            polylineDataMapper.insertPolyLineType(polylineName,polylineType);
            idByNameType = polylineDataMapper.getIdByNameType(polylineName);
            List<OcPolylineData> ocPolylineDataList = polylineDataMapper.selectAllType();
            List<Date> allDate = firDSNowDayRevenueDao.getAllDate();
            for (Date date:allDate) {
                firDSNowDayRevenueDao.insertMoney(money,idByNameType,date);
            }
//            dataSourceTransactionManager.commit(transactionStatus);
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
