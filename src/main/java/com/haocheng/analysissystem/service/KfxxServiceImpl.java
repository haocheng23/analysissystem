package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.KfxxEntity;
import com.haocheng.analysissystem.dao.KfxxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KfxxServiceImpl implements KfxxService{
    @Autowired
    private KfxxRepository kfxxRepository;

    public List<KfxxEntity> getAll(){
        List<KfxxEntity> list = kfxxRepository.findAll();
        return list;
    }

    public int getServicerNum(){
        long count = kfxxRepository.count();
        return (int) count;
    }
}
