package com.haocheng.analysissystem.dao;

import com.haocheng.analysissystem.bean.YhxxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YhxxRepository extends JpaRepository<YhxxEntity,Integer> {
    YhxxEntity findByTel(String tel);
}
