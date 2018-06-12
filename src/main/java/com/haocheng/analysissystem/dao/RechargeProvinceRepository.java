package com.haocheng.analysissystem.dao;

import com.haocheng.analysissystem.bean.RechargeProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeProvinceRepository extends JpaRepository<RechargeProvinceEntity,String> {
    List<RechargeProvinceEntity> findTop10ByTotal(Integer total);
}
