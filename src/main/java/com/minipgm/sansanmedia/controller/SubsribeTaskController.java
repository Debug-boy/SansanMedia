package com.minipgm.sansanmedia.controller;


import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.SubscribeTask;
import com.minipgm.sansanmedia.mapper.body.UpdateUserAllUrlsBody;
import com.minipgm.sansanmedia.service.impl.SubscribeTaskServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subscribe_task")
public class SubsribeTaskController {

    @Autowired
    SubscribeTaskServerImpl subscribeTaskServer;

    @PostMapping("/init_user")
    public ResponseResult<String> initUserTask(@RequestBody Map<String, String> requestBody) {

        if (!requestBody.containsKey("wxopenid")) {
            return ResponseResult.failure("wxopenid 字段不存在!");
        }

        if (!requestBody.containsKey("wxname")) {
            return ResponseResult.failure("wxname 字段不存在!");
        }

        if (subscribeTaskServer.initUserTask(requestBody.get("wxopenid"), requestBody.get("wxname")) > 0) {
            return ResponseResult.success("初始化用户任务成功!", null);
        }

        return ResponseResult.failure("未知的初始错误!");
    }

    @PostMapping("/get_user_task")
    public ResponseResult<SubscribeTask> getTaskByWxOpenid(@RequestBody Map<String, String> requestBody){
        if (!requestBody.containsKey("wxopenid")) {
            return ResponseResult.failure("wxopenid 字段不存在!");
        }

        SubscribeTask subscribeTask = subscribeTaskServer.getTaskByWxOpenid(requestBody.get("wxopenid"));
        if(subscribeTask == null){
            return ResponseResult.failure("用户不存在或没有初始化任务!");
        }

        subscribeTask.setId(-1);

        return ResponseResult.success("获取用户任务成功!",subscribeTask);
    }

    @PostMapping("/update_user_url")
    public ResponseResult<String> updateUserUrl(@RequestBody Map<String,String> requestBody){
        if (!requestBody.containsKey("wxopenid")) {
            return ResponseResult.failure("wxopenid 字段不存在!");
        }

        if (!requestBody.containsKey("updateIndex")) {
            return ResponseResult.failure("updateIndex 字段不存在!");
        }

        if (!requestBody.containsKey("updateTaskUrl")) {
            return ResponseResult.failure("updateTaskUrl 字段不存在!");
        }

        int updateIndex = Integer.parseInt(requestBody.get("updateIndex"));
        String updateTaskUrl = requestBody.get("updateTaskUrl");

        if(updateIndex < 0 || updateIndex >= 20){
            return ResponseResult.failure("更新索引不符合规范,要求在[0-19]");
        }

        SubscribeTask subscribeTask = subscribeTaskServer.getTaskByWxOpenid(requestBody.get("wxopenid"));
        if(subscribeTask == null){
            return ResponseResult.failure("用户不存在或没有初始化任务!");
        }

        subscribeTask.getUrls().set(updateIndex,updateTaskUrl);

        if( subscribeTaskServer.updateUserTaskUrls(requestBody.get("wxopenid"),subscribeTask.getUrls()) > 0){
            return ResponseResult.success("更新用户url成功",null);
        }
        return ResponseResult.failure("更新用户url失败,未知错误!");
    }

    @PostMapping("update_user_all_urls")
    public ResponseResult<String> updateUserAllUrls(@RequestBody UpdateUserAllUrlsBody requestBody){

        if ( (!requestBody.wxopenidNotNull()) || (requestBody.getWxopenid().isEmpty()) ) {
            return ResponseResult.failure("wxopenid字段不存在!");
        }

        if( (!requestBody.urlsNotNull()) || (requestBody.getUrls().isEmpty()) ){
            return ResponseResult.failure("urls字段不存在或字段数组太少!");
        }

        List<String >urls = requestBody.getUrls();
        while (urls.size() < 20) urls.add("");

        if( subscribeTaskServer.updateUserTaskUrls(requestBody.getWxopenid(),requestBody.getUrls()) > 0) {
            return ResponseResult.success("跟新用户所有任务链接成功!",null);
        }

        return ResponseResult.failure("未知错误! 用户不存在或没有初始化任务!");
    }

    @RequestMapping("update_user_task_index")
    public ResponseResult<String>updateUserTaskIndex(@RequestBody Map<String,String> requestBody){
        if (!requestBody.containsKey("wxopenid")) {
            return ResponseResult.failure("wxopenid 字段不存在!");
        }

        if (!requestBody.containsKey("updateIndex")) {
            return ResponseResult.failure("updateIndex 字段不存在!");
        }

        int updateIndex = Integer.parseInt(requestBody.get("updateIndex"));
        String wxopenid = requestBody.get("wxopenid");

        if(updateIndex < 0 || updateIndex >= 20){
            return ResponseResult.failure("更新索引不符合规范,要求在[0-19]");
        }

        if(subscribeTaskServer.updateUserTaskIndex(wxopenid,updateIndex) > 0){
            return ResponseResult.success("更新任务索引成功!",null);
        }

        return ResponseResult.failure("更新任务索引失败!用户不存在或未初始化用户!");
    }

}