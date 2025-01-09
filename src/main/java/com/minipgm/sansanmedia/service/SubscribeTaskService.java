package com.minipgm.sansanmedia.service;

import com.minipgm.sansanmedia.entity.SubscribeTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface SubscribeTaskService {

    public int initUserTask(String wxopenid, String wxname);

    SubscribeTask getTaskByWxOpenid(String wxopenid);

    public int updateUserWxName(String wxopenid,String wxname);

    public int updateUserTaskUrls(String wxopenid,List<String>urls);

    public int updateUserTaskIndex(String wxopenid,int index);

    public int deleteUserSubscribeTask(String wxopenid);
}
