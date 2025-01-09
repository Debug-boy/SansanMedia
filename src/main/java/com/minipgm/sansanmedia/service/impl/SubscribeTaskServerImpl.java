package com.minipgm.sansanmedia.service.impl;

import com.minipgm.sansanmedia.entity.SubscribeTask;
import com.minipgm.sansanmedia.mapper.SubsribeTaskMapper;
import com.minipgm.sansanmedia.service.SubscribeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscribeTaskServerImpl implements SubscribeTaskService {

    @Autowired
    SubsribeTaskMapper subsribeTaskMapper;

    @Override
    public int initUserTask(String wxopenid, String wxname) {
        List<String>initUrls = new ArrayList<>();
        for(int i = 0;  i < 20 ; ++i) initUrls.add("");
        return subsribeTaskMapper.initUserTask(wxopenid,wxname,initUrls);
    }

    @Override
    public SubscribeTask getTaskByWxOpenid(String wxopenid) {
        return subsribeTaskMapper.getTaskByWxOpenid(wxopenid);
    }

    @Override
    public int updateUserWxName(String wxopenid, String wxname) {
        return subsribeTaskMapper.updateUserWxName(wxopenid,wxname);
    }

    @Override
    public int updateUserTaskUrls(String wxopenid, List<String> urls) {
        return subsribeTaskMapper.updateUserTaskUrls(wxopenid,urls);
    }

    @Override
    public int updateUserTaskIndex(String wxopenid, int index) {
        return subsribeTaskMapper.updateUserTaskIndex(wxopenid,index);
    }

    @Override
    public int deleteUserSubscribeTask(String wxopenid) {
        return subsribeTaskMapper.deleteUserSubscribeTask(wxopenid);
    }

}
