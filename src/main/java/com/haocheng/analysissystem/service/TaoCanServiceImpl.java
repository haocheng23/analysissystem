package com.haocheng.analysissystem.service;

import com.haocheng.analysissystem.bean.TaoCanEntity;
import com.haocheng.analysissystem.dao.TaoCanRepository;
import com.haocheng.analysissystem.service.TaoCanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TaoCanServiceImpl implements TaoCanService {
    @Autowired
    private TaoCanRepository taoCanRepository;

    @Override
    @ResponseBody
    public List<TaoCanEntity> getAll() {
        List<TaoCanEntity> list = taoCanRepository.findAll();
        return list;
    }
}
