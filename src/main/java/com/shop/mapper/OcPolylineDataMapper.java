package com.shop.mapper;

import com.shop.config.DS;
import com.shop.entity.OcPolylineData;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OcPolylineDataMapper {

    @DS("db1")
    @Select("SELECT * FROM oc_polylinedata")
    List<OcPolylineData> selectAllType();

    @DS("db1")
    @Select("SELECT id FROM oc_polylinedata WHERE polylineName = #{polylineName} ")
    Integer getIdByNameType(@Param("polylineName") String polylineName);

    @DS("db1")
    @Insert("INSERT INTO oc_polylinedata (polylineName ,polylineType) VALUES (#{polylineName},#{polylineType})")
    int insertPolyLineType(@Param("polylineName") String polylineName,@Param("polylineType") String polylineType);

}
