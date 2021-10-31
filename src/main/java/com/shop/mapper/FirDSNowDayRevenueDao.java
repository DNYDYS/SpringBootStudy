package com.shop.mapper;

import com.shop.annos.DSAnno;
import com.shop.entity.NowDayRevenue;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * (OcCurrentDayRevenue)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-23 16:20:46
 */
@Mapper
public interface FirDSNowDayRevenueDao {

    @DSAnno("dbcp1")
    @Select("SELECT * from oc_current_day_revenue where polylineId=#{polylineId} GROUP BY date ")
    List<NowDayRevenue> getAllDataByTypeId(@Param("polylineId") int polylineId);

    @DSAnno("dbcp1")
    @Select("SELECT DISTINCT date FROM oc_current_day_revenue;")
    List<Date> getAllDate();

    @DSAnno("dbcp1")
    @Insert("INSERT INTO oc_current_day_revenue (money,polylineId,date) VALUES (#{money},#{polylineId},#{date})")
    int insertMoney(@Param("money") float money,@Param("polylineId") Integer polylineId,@Param("date") Date date);

    @DSAnno("dbcp1")
    @Update("UPDATE oc_current_day_revenue SET money = #{money} where date = #{date} and polylineId =#{polylineId}")
    int updateMoney(@Param("money") float money,@Param("polylineId") Integer polylineId,@Param("date") Date date);

    @DSAnno("dbcp1")
    @Insert("INSERT INTO oc_current_day_revenue (expenditure,date) VALUES (#{expenditure},#{date})")
    int insertExpenditure(@Param("expenditure") int expenditure,@Param("date") Date date);

    @DSAnno("dbcp1")
    @Update("UPDATE oc_current_day_revenue SET expenditure = #{expenditure} where date = #{date}")
    int updateExpenditure(@Param("expenditure") int expenditure,@Param("date") Date date);

    @DSAnno("dbcp1")
    @Select("SELECT count(*) from oc_current_day_revenue where polylineId=#{polylineId} and date = #{date}")
    int selectCountByDate(@Param("polylineId") Integer polylineId,@Param("date") Date date);

    @DSAnno("dbcp1")
    @Select("SELECT * from oc_current_day_revenue where date = #{date}")
    NowDayRevenue selectByDate(@Param("date") Date date);

    @DSAnno("dbcp1")
    @Update("UPDATE oc_current_day_revenue SET netrevenue = #{netrevenue} where date = #{date}")
    int updateNetrevenue(@Param("netrevenue") int netrevenue,@Param("date") Date date);
}

