package com.minipgm.sansanmedia.service.impl;

import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.mapper.UserMapper;
import com.minipgm.sansanmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    UserServiceImpl() {
    }

    @Override
    public boolean login(String wxid) {
        User user = userMapper.login(wxid);
        return user != null;
    }

    @Override
    public boolean addUser(User user) {
        int insertResult = userMapper.insert(user);
        return insertResult > 0;
    }

    @Override
    public boolean delUser(String wxid) {
        int deleteResult = userMapper.delUser(wxid);
        return deleteResult > 0;
    }

    @Override
    public boolean updateUserName(String wxid, String customName) {
        int updateResult = userMapper.updateUserName(wxid, customName);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserPhone(String wxid, String phone) {
        int updateResult = userMapper.updateUserPhone(wxid, phone);
        return updateResult > 0;
    }
}