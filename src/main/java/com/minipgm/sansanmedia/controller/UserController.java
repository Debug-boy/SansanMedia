package com.minipgm.sansanmedia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.service.UserService;
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

    @PostMapping("/login")
    public ResponseResult<User> login(@RequestBody Map<String, String> requestData) {
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
        boolean success = userService.register(user);
        if (success) {
            return ResponseResult.success("用户注册成功!", null);
        } else {
            return ResponseResult.failure("注册用户失败!");
        }
    }

    @PostMapping("/delete")
    public ResponseResult<String> delUser(@RequestBody Map<String, String> requestData) {
        boolean success = userService.delUser(requestData.get("wxopenid"));
        if (success) {
            return ResponseResult.success("用户删除成功!", null);
        } else {
            return ResponseResult.failure("删除用户失败!");
        }
    }

    @PostMapping("/update/name")
    public ResponseResult<String> updateUserName(@RequestBody Map<String, String> requestData) {
        boolean success = userService.updateUserName(requestData.get("wxopenid"),requestData.get("customName"));
        if (success) {
            return ResponseResult.success("用户名字更新成功!", null);
        } else {
            return ResponseResult.failure("更新用户名字失败!");
        }
    }

    @PostMapping("/update/phone")
    public ResponseResult<String> updateUserPhone(@RequestBody Map<String, String> requestData) {
        boolean success = userService.updateUserPhone(requestData.get("wxopenid"),requestData.get("phone"));
        if (success) {
            return ResponseResult.success("更新手机号成功!", null);
        } else {
            return ResponseResult.failure("更新手机号失败!");
        }
    }

    @PostMapping("/update/alipayUser")
    public ResponseResult<String> updateUserAlipayUser(@RequestBody Map<String, String> requestData) {
        boolean success = userService.updateUserAlipayUser(requestData.get("wxopenid"),requestData.get("alipayUser"));
        if (success) {
            return ResponseResult.success("更新支付宝信息成功!", null);
        } else {
            return ResponseResult.failure("更新支付宝信息失败!");
        }
    }

}