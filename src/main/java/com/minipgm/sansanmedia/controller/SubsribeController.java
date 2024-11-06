package com.minipgm.sansanmedia.controller;

import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.SubscribeLink;
import com.minipgm.sansanmedia.service.impl.SubsribeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribe")
public class SubsribeController {

    @Autowired
    private SubsribeServiceImpl subscribeService;

    // 获取所有订阅链接
    @GetMapping("/all")
    public ResponseResult<List<SubscribeLink>> getAll() {
        List<SubscribeLink> subscribeLinks = subscribeService.getAll();
        if (!subscribeLinks.isEmpty()) {
            return ResponseResult.success(subscribeLinks);
        } else {
            return ResponseResult.failure("数据为空!");
        }
    }

}