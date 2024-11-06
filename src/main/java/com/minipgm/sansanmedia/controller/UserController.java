package com.minipgm.sansanmedia.controller;

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
    public ResponseResult<String> login(@RequestParam("wxid") String wxid) {
        boolean success = userService.login(wxid);
        if (success) {
            return ResponseResult.success("用户删除成功!", null);
        } else {
            return ResponseResult.failure("删除用户失败!");
        }
    }

    @PostMapping("/register")
    public ResponseResult<String> addUser(@RequestBody User user) {
        boolean success = userService.addUser(user);
        if (success) {
            return ResponseResult.success("用户注册成功!", null);
        } else {
            return ResponseResult.failure("注册用户失败!");
        }
    }

    @PostMapping("/delete")
    public ResponseResult<String> delUser(@RequestParam("wxid") String wxid) {
        boolean success = userService.delUser(wxid);
        if (success) {
            return ResponseResult.success("用户删除成功!", null);
        } else {
            return ResponseResult.failure("删除用户失败!");
        }
    }

    @PostMapping("/update/name")
    public ResponseResult<String> updateUserName(@RequestParam("wxid") String wxid, @RequestParam("customName") String customName) {
        boolean success = userService.updateUserName(wxid, customName);
        if (success) {
            return ResponseResult.success("用户名字更新成功!", null);
        } else {
            return ResponseResult.failure("更新用户名字失败!");
        }
    }

    @PostMapping("/update/phone")
    public ResponseResult<String> updateUserPhone(@RequestParam("wxid") String wxid, @RequestParam("phone") String phone) {
        boolean success = userService.updateUserPhone(wxid, phone);
        if (success) {
            return ResponseResult.success("更新手机号成功!", null);
        } else {
            return ResponseResult.failure("更新手机号失败!");
        }
    }

}