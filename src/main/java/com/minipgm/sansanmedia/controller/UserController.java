package com.minipgm.sansanmedia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.mapper.SubsribeMapper;
import com.minipgm.sansanmedia.mapper.SubsribeTaskMapper;
import com.minipgm.sansanmedia.mapper.UserMapper;
import com.minipgm.sansanmedia.service.UserService;
import com.minipgm.sansanmedia.service.impl.SubscribeTaskServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    SubscribeTaskServerImpl subscribeTaskServer;

    @PostMapping("/login")
    public ResponseResult<User> login(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        User user = userService.login(requestData.get("wxopenid"));
        if (user != null) {
            User userDTO = new User(
                    user.getId(),
                    user.getWxopenid(),
                    user.getWxid(),
                    user.getWxname(),
                    user.getCustom_name(),
                    user.getPhone(),
                    user.isAuth(),
                    user.getAlipay_user(),
                    new ArrayList<String>(),
                    user.getRegister_time()
            );
            return ResponseResult.success("登录成功!", userDTO);
        } else {
            return ResponseResult.failure("登录失败!");
        }
    }

    @PostMapping("/register")
    public ResponseResult<String> register(@RequestBody User user) {

        if(user.getWxopenid().isEmpty()){
            return ResponseResult.failure("注册用户失败,wxopenid字段为空!");
        }

        if(user.getRegister_image().isEmpty()){
            return ResponseResult.failure("注册用户失败,图片为空!");
        }

        if(userService.login(user.getWxopenid()) != null){
            return ResponseResult.failure("注册用户失败,用户已存在!");
        }

        boolean success = userService.register(user);
        if (success) {

            //new create subscribe_task table database;
            //need add user wxopenid and wxname and urls to table;
            subscribeTaskServer.initUserTask(user.getWxopenid(),user.getWxname());

            return ResponseResult.success("用户注册成功!", null);
        } else {
            return ResponseResult.failure("注册用户失败!");
        }
    }

    @PostMapping("/delete")
    public ResponseResult<String> delUser(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        boolean success = userService.delUser(requestData.get("wxopenid"));
        if (success) {
            subscribeTaskServer.deleteUserSubscribeTask(requestData.get("wxopenid"));
            return ResponseResult.success("用户删除成功!", null);
        } else {
            return ResponseResult.failure("删除用户失败,用户可能不存在!");
        }
    }

    @PostMapping("/update/auth")
    public ResponseResult<String> updateUserAuth(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        boolean success = userService.updateUserAuth(requestData.get("wxopenid"), Boolean.parseBoolean(requestData.get("auth")));
        if (success) {
            return ResponseResult.success("更新用户认证成功!", null);
        } else {
            return ResponseResult.failure("更新用户认证失败,用户可能不存在!");
        }
    }

    @PostMapping("/update/customName")
    public ResponseResult<String> updateUserCustomName(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        boolean success = userService.updateUserCustomName(requestData.get("wxopenid"),requestData.get("customName"));
        if (success) {
            return ResponseResult.success("更新自定义名字成功!", null);
        } else {
            return ResponseResult.failure("更新自定义名字失败,用户可能不存在!");
        }
    }

    @PostMapping("/update/wxName")
    public ResponseResult<String> updateUserWxName(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        boolean success = userService.updateUserWxName(requestData.get("wxopenid"),requestData.get("wxName"));
        if (success) {
            subscribeTaskServer.updateUserWxName(requestData.get("wxopenid"),requestData.get("wxName"));
            return ResponseResult.success("更新微信名称字成功!", null);
        } else {
            return ResponseResult.failure("更新微信名称字失败,用户可能不存在!");
        }

    }

    @PostMapping("/update/phone")
    public ResponseResult<String> updateUserPhone(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        boolean success = userService.updateUserPhone(requestData.get("wxopenid"),requestData.get("phone"));
        if (success) {
            return ResponseResult.success("更新手机号成功!", null);
        } else {
            return ResponseResult.failure("更新手机号失败,用户可能不存在!");
        }
    }

    @PostMapping("/update/alipayUser")
    public ResponseResult<String> updateUserAlipayUser(@RequestBody Map<String, String> requestData) {

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        boolean success = userService.updateUserAlipayUser(requestData.get("wxopenid"),requestData.get("alipayUser"));
        if (success) {
            return ResponseResult.success("更新支付宝信息成功!", null);
        } else {
            return ResponseResult.failure("更新支付宝信息失败,用户可能不存在!");
        }
    }

}