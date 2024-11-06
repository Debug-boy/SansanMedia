package com.minipgm.sansanmedia.service.impl;

import com.minipgm.sansanmedia.entity.SubscribeLink;
import com.minipgm.sansanmedia.mapper.SubsribeMapper;
import com.minipgm.sansanmedia.service.SubsribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsribeServiceImpl implements SubsribeService {

    @Autowired
    SubsribeMapper subsribeMapper;

    @Override
    public List<SubscribeLink> getAll() {
        return this.subsribeMapper.getAll();
    }


}
