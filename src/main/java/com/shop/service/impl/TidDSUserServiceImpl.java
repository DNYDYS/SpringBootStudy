package com.shop.service.impl;

import com.shop.entity.User;
import com.shop.mapper.TidDSUserMapper;
import com.shop.service.TidDSUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TidDSUserServiceImpl implements TidDSUserService {

    private Logger log = LoggerFactory.getLogger(TidDSUserServiceImpl.class);

    //将DAO注入Service层
    @Autowired
    private TidDSUserMapper tidDSUserMapper;

    @Override
    public User loginIn(String name, String password) {
        log.info(""+name+":::::"+password);
        return tidDSUserMapper.getInfo(name,password);
    }
}
