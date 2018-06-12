package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.LoginEntity;
import com.haocheng.analysissystem.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    //注入user接口
    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginEntity findByUsernameAndPassword(LoginEntity loginEntity) {
        String username = loginEntity.getUsername();
        String password = loginEntity.getPassword();
        return userRepository.findByUsernameAndPassword(username, password);
    }


}
