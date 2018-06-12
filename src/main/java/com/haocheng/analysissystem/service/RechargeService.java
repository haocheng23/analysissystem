package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.*;

import java.util.List;

public interface RechargeService {
    List<RechargeFeeEntity> getAll();

    List<RechargeProvinceEntity> getAllByProv();

    List<RechargeTimeEntity> getAllByTime();

    List<RechargeProvFeeEntity> getTopByProv();

    Long getMoneySum();

    List<PayWayEntity> getPayWay();
}
