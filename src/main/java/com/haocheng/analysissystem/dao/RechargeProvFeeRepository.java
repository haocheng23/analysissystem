package com.haocheng.analysissystem.dao;

import com.haocheng.analysissystem.bean.RechargeProvFeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RechargeProvFeeRepository extends JpaRepository<RechargeProvFeeEntity,String> {

    @Query("select sum(total) from RechargeProvFeeEntity")
    Long findSumRechargefee();
}
