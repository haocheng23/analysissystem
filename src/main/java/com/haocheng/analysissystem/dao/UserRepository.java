package com.haocheng.analysissystem.dao;

import com.haocheng.analysissystem.bean.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<LoginEntity, Integer> {
    LoginEntity findByUsernameAndPassword(String username,String password);
}
