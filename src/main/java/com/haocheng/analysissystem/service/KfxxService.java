package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.KfxxEntity;

import java.util.List;

public interface KfxxService {
    List<KfxxEntity> getAll();

    int getServicerNum();
}
