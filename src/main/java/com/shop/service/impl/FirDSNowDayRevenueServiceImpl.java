package com.shop.service.impl;

import com.shop.entity.NowDayRevenue;
import com.shop.entity.OcPolylineData;
import com.shop.mapper.FirDSNowDayRevenueDao;
import com.shop.mapper.SecDSPolylineMapper;
import com.shop.service.FirDSNowDayRevenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (OcCurrentDayRevenue)表服务实现类
 *
 * @author makejava
 * @since 2021-08-23 16:20:49
 */
@Service
public class FirDSNowDayRevenueServiceImpl implements FirDSNowDayRevenueService {

    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);

    @Autowired
    private FirDSNowDayRevenueDao firDSNowDayRevenueDao;

    @Autowired
    private SecDSPolylineMapper secDSPolylineMapper;

    @Override
    public Map getAll() {
        Map map = new HashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<OcPolylineData> ocPolylineDataList = secDSPolylineMapper.selectAllType();
        //存钱
        List<Float> money = new ArrayList<>();
        List<String> days = new ArrayList<>();
        //
        List<String> poleTypeNameList = new ArrayList<>();
        List<String> polylineTypeList = new ArrayList<>();
        List<Integer> polylineIdList = new ArrayList<>();

        for (OcPolylineData o : ocPolylineDataList) {
            poleTypeNameList.add(o.getPolylineName());
            polylineTypeList.add(o.getPolylineType());
            polylineIdList.add(o.getId());
            List<NowDayRevenue> allDataByTypeId = firDSNowDayRevenueDao.getAllDataByTypeId(o.getId());
            for (NowDayRevenue nowDayRevenue : allDataByTypeId) {
                money.add(nowDayRevenue.getMoney());
                String transformDate = simpleDateFormat.format(nowDayRevenue.getDate());
                days.add(transformDate);
            }
            map.put(o.getPolylineName(), money);
        }
        map.put("poleTypeNameList", poleTypeNameList);
        map.put("polylineTypeList", polylineTypeList);
        map.put("polylineIdList", polylineIdList);
        map.put("ocPolylineDataList", ocPolylineDataList);
        map.put("days", days);
        map.put("Code", 200);
        map.put("Desc", "成功");
        log.info("" + map);
        return map;
//        //当日营收 支出 净收入 时间
//        List<Integer> revenue = new ArrayList<>();
//        List<Integer> expenditure = new ArrayList<>();
//        List<Integer> netRevenue = new ArrayList<>();
//        List<String> days = new ArrayList<>();
//        List<OcCurrentDayRevenue> all = ocCurrentDayRevenueDao.getAll();
//        if (all.size() > 0) {
//            for (OcCurrentDayRevenue o : all) {
//                revenue.add(o.getRevenue());
//                expenditure.add(o.getExpenditure());
//                netRevenue.add(o.getNetRevenue());
//                String transformDate = simpleDateFormat.format(o.getDate());
//                days.add(transformDate);
//                log.info("" + o + "date" + transformDate);
//            }
//            map.put("Code", 200);
//            map.put("Desc", "成功");
//            map.put("revenue", revenue);
//            map.put("expenditure", expenditure);
//            map.put("netRevenue", netRevenue);
//            map.put("days", days);
//            return map;
//        } else {
//            map.put("Code", 400);
//            map.put("Desc", "查找数据失败");
//            return map;
//        }
    }

    @Override
    public Map getMoneyBypolylineId(int id) {
        Map map = new HashMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //存钱
        List<Float> money = new ArrayList<>();
        List<String> days = new ArrayList<>();

        List<NowDayRevenue> allDataByTypeId = firDSNowDayRevenueDao.getAllDataByTypeId(id);
        for (NowDayRevenue nowDayRevenue : allDataByTypeId) {
            money.add(nowDayRevenue.getMoney());
            String transformDate = simpleDateFormat.format(nowDayRevenue.getDate());
            days.add(transformDate);
        }
        map.put("money", money);
        map.put("days", days);
        map.put("Code", 200);
        map.put("Desc", "成功");
        return map;
    }

    /**
     *@Author lyy
     *@Discription 通过时间 和折线类型id产找是否存在该money不存在添加0
     *@Data 2021/8/26
     *@Param
     *@return
     **/
    public void addMoneyBYPolyline(Date date){
        float autoMoney = 0;
        List<OcPolylineData> ocPolylineDataList = secDSPolylineMapper.selectAllType();
        for (OcPolylineData polylineData:ocPolylineDataList) {
            int count = firDSNowDayRevenueDao.selectCountByDate(polylineData.getId(), date);
            if (count == 0){
                firDSNowDayRevenueDao.insertMoney(autoMoney,polylineData.getId(),date);
            }
        }
    }

    /**
     *@Author lyy
     *@Discription 添加或修改
     *@Data 2021/8/26
     *@Param
     *@return
     **/
    @Override
    public Map insertOrUpdateRevenue(float money, int polylineId, Date date) {
        Map map = new HashMap();
        log.info("打印转换的时间"+date);
        //0 不存在新增    1 存在修改
        int i = firDSNowDayRevenueDao.selectCountByDate(polylineId,date);
        if(i == 0){
            firDSNowDayRevenueDao.insertMoney(money,polylineId,date);
            //通过时间 和折线类型id产找是否存在该money不存在添加0 i
            addMoneyBYPolyline(date);
            map.put("Code", 200);
            map.put("Desc", "新增数据成功");
            return map;
        }else{
            firDSNowDayRevenueDao.updateMoney(money,polylineId,date);
            map.put("Code", 200);
            map.put("Desc", "修改数据成功");
            return map;
        }
//        map = this.getAll();

    }

}
