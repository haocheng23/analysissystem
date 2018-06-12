package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.*;
import com.haocheng.analysissystem.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeFeeRepository rechargeFeeRepository;

    @Autowired
    private RechargeProvinceRepository rechargeProvinceRepository;

    @Autowired
    private RechargeTimeRepository rechargeTimeRepository;

    @Autowired
    private RechargeProvFeeRepository rechargeProvFeeRepository;

    @Autowired
    private PayWayRepository payWayRepository;

    /**
     * 获取订单充值费用
     * @return
     */
    @Override
    @ResponseBody
    public List<RechargeFeeEntity> getAll(){
        List<RechargeFeeEntity> list = rechargeFeeRepository.findAll();
        return list;
    }

    /**
     * 获取订单充值省份
     * @return
     */
    @Override
    @ResponseBody
    public List<RechargeProvinceEntity> getAllByProv(){
        List<RechargeProvinceEntity> list2 = rechargeProvinceRepository.findAll();
        return list2;
    }

    /**
     * 获取订单充值时间
     * @return
     */
    @Override
    @ResponseBody
    public List<RechargeTimeEntity> getAllByTime(){
        List<RechargeTimeEntity> list3 = rechargeTimeRepository.findAll();
        return list3;
    }

    /**
     * 获取充值排行榜top10
     */
    @Override
    @ResponseBody
    public List<RechargeProvFeeEntity> getTopByProv() {
        List<RechargeProvFeeEntity> list4 = rechargeProvFeeRepository.findAll();
        return list4.subList(0,10);
    }

    /**
     * 金额总量
     */
    @Override
    @ResponseBody
    public Long getMoneySum(){
        Long sumRechargefee = rechargeProvFeeRepository.findSumRechargefee();
        return sumRechargefee;
    }

    /**
     * 支付方式
     */
    @ResponseBody
    public List<PayWayEntity> getPayWay(){
        List<PayWayEntity> list5 = payWayRepository.findAll();
        return list5;
    }
}
