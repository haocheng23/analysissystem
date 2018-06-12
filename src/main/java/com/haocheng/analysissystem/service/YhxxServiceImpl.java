package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.VipEntity;
import com.haocheng.analysissystem.bean.YhxxEntity;
import com.haocheng.analysissystem.dao.VipRepository;
import com.haocheng.analysissystem.dao.YhxxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YhxxServiceImpl implements YhxxService {
    @Autowired
    private VipRepository vipRepository;

    @Autowired
    private YhxxRepository yhxxRepository;

    //通过手机号找用户
    public YhxxEntity findByTel(String tel){
        YhxxEntity byTel = yhxxRepository.findByTel(tel);
        return byTel;
    }

    /*//在网用户总量
    public int getUserNum(){
        List<YhxxEntity> list = yhxxRepository.findAll();
        int num = list.size();
        return num;

    }*/

    //在网用户总量
    public int getUserNum(){
        long num = yhxxRepository.count();
        return (int) num;

    }

    //会员等级信息
    public List<VipEntity> getVip(){
        List<VipEntity> list = vipRepository.findAll();
        return list;
    }

}
