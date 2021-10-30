package com.shop.service.impl;

import com.shop.entity.UserBean;
import com.shop.mapper.UserMapper;
import com.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(String name, String password) {
        log.info(""+name+":::::"+password);
        return userMapper.getInfo(name,password);
    }
}
