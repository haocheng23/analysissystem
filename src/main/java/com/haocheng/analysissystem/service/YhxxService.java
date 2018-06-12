package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.VipEntity;
import com.haocheng.analysissystem.bean.YhxxEntity;

import java.util.List;

public interface YhxxService {

    YhxxEntity findByTel(String tel);

    int getUserNum();

    List<VipEntity> getVip();

}
