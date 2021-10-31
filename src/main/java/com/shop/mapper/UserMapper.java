package com.shop.mapper;


import com.shop.config.DS;
import com.shop.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @DS("dbcp2")
    @Select("SELECT * FROM oc_users WHERE name = #{name} AND password = #{password}")
    UserBean getInfo(@Param("name")String name,@Param("password")String password);

}
