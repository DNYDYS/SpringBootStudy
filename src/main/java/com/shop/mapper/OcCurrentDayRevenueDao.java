package com.shop.mapper;

import com.shop.config.DS;
import com.shop.entity.OcCurrentDayRevenue;
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
public interface OcCurrentDayRevenueDao {

    @DS("db1")
    @Select("SELECT * from oc_current_day_revenue where polylineId=#{polylineId} GROUP BY date ")
    List<OcCurrentDayRevenue> getAllDataByTypeId(@Param("polylineId") int polylineId);

    @DS("db1")
    @Select("SELECT DISTINCT date FROM oc_current_day_revenue;")
    List<Date> getAllDate();

    @DS("db1")
    @Insert("INSERT INTO oc_current_day_revenue (money,polylineId,date) VALUES (#{money},#{polylineId},#{date})")
    int insertMoney(@Param("money") float money,@Param("polylineId") Integer polylineId,@Param("date") Date date);

    @DS("db1")
    @Update("UPDATE oc_current_day_revenue SET money = #{money} where date = #{date} and polylineId =#{polylineId}")
    int updateMoney(@Param("money") float money,@Param("polylineId") Integer polylineId,@Param("date") Date date);

    @DS("db1")
    @Insert("INSERT INTO oc_current_day_revenue (expenditure,date) VALUES (#{expenditure},#{date})")
    int insertExpenditure(@Param("expenditure") int expenditure,@Param("date") Date date);

    @DS("db1")
    @Update("UPDATE oc_current_day_revenue SET expenditure = #{expenditure} where date = #{date}")
    int updateExpenditure(@Param("expenditure") int expenditure,@Param("date") Date date);

    @DS("db1")
    @Select("SELECT count(*) from oc_current_day_revenue where polylineId=#{polylineId} and date = #{date}")
    int selectCountByDate(@Param("polylineId") Integer polylineId,@Param("date") Date date);

    @DS("db1")
    @Select("SELECT * from oc_current_day_revenue where date = #{date}")
    OcCurrentDayRevenue selectByDate(@Param("date") Date date);

    @DS("db1")
    @Update("UPDATE oc_current_day_revenue SET netrevenue = #{netrevenue} where date = #{date}")
    int updateNetrevenue(@Param("netrevenue") int netrevenue,@Param("date") Date date);

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    OcCurrentDayRevenue queryById(Integer id);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param offset 查询起始位置
//     * @param limit  查询条数
//     * @return 对象列表
//     */
//    List<OcCurrentDayRevenue> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
//
//
//    /**
//     * 通过实体作为筛选条件查询
//     *
//     * @param ocCurrentDayRevenue 实例对象
//     * @return 对象列表
//     */
//    List<OcCurrentDayRevenue> queryAll(OcCurrentDayRevenue ocCurrentDayRevenue);
//
//    /**
//     * 新增数据
//     *
//     * @param ocCurrentDayRevenue 实例对象
//     * @return 影响行数
//     */
//    int insert(OcCurrentDayRevenue ocCurrentDayRevenue);
//
//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<OcCurrentDayRevenue> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<OcCurrentDayRevenue> entities);
//
//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<OcCurrentDayRevenue> 实例对象列表
//     * @return 影响行数
//     */
//    int insertOrUpdateBatch(@Param("entities") List<OcCurrentDayRevenue> entities);
//
//    /**
//     * 修改数据
//     *
//     * @param ocCurrentDayRevenue 实例对象
//     * @return 影响行数
//     */
//
//    int update(OcCurrentDayRevenue ocCurrentDayRevenue);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer id);

}

