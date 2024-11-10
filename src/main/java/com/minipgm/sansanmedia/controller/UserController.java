package com.minipgm.sansanmedia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseResult<User> login(@RequestParam("wxopenid") String wxopenid) {
        User user = userService.login(wxopenid);
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
                    "",
                    user.getRegister_time()
            );

            return ResponseResult.success("登录成功!", userDTO);

        } else {
            return ResponseResult.failure("登录失败!");
        }
    }

    @PostMapping("/register")
    public ResponseResult<String> addUser(@RequestBody User user) {
        if(user.getRegister_image().isEmpty()){
            user.setRegister_image("{}");
        }
        boolean success = userService.register(user);
        if (success) {
            return ResponseResult.success("用户注册成功!", null);
        } else {
            return ResponseResult.failure("注册用户失败!");
        }
    }

    @PostMapping("/delete")
    public ResponseResult<String> delUser(@RequestParam("wxopenid") String wxopenid) {
        boolean success = userService.delUser(wxopenid);
        if (success) {
            return ResponseResult.success("用户删除成功!", null);
        } else {
            return ResponseResult.failure("删除用户失败!");
        }
    }

    @PostMapping("/update/name")
    public ResponseResult<String> updateUserName(@RequestParam("wxopenid") String wxopenid, @RequestParam("customName") String customName) {
        boolean success = userService.updateUserName(wxopenid, customName);
        if (success) {
            return ResponseResult.success("用户名字更新成功!", null);
        } else {
            return ResponseResult.failure("更新用户名字失败!");
        }
    }

    @PostMapping("/update/phone")
    public ResponseResult<String> updateUserPhone(@RequestParam("wxopenid") String wxopenid, @RequestParam("phone") String phone) {
        boolean success = userService.updateUserPhone(wxopenid, phone);
        if (success) {
            return ResponseResult.success("更新手机号成功!", null);
        } else {
            return ResponseResult.failure("更新手机号失败!");
        }
    }

    @PostMapping("/update/alipayUser")
    public ResponseResult<String> updateUserAlipayUser(@RequestParam("wxopenid") String wxopenid, @RequestParam("alipayUser") String alipayUser) {
        boolean success = userService.updateUserAlipayUser(wxopenid, alipayUser);
        if (success) {
            return ResponseResult.success("更新支付宝信息成功!", null);
        } else {
            return ResponseResult.failure("更新支付宝信息失败!");
        }
    }

}