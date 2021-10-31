package com.shop.mapper;

import com.shop.annos.DSAnno;
import com.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TidDSUserMapper {
    @DSAnno("dbcp3")
    @Select("SELECT * FROM oc_users WHERE name = #{name} AND password = #{password}")
    User getInfo(@Param("name")String name,@Param("password")String password);

}
