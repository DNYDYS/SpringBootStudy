package com.shop.service;


import com.shop.entity.UserBean;

public interface UserService {

    UserBean loginIn(String name, String password);

}
