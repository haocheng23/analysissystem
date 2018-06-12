package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.LoginEntity;

public interface UserService {
    //登录时根据用户名和密码查找用户
    LoginEntity findByUsernameAndPassword(LoginEntity loginEntity);

}
