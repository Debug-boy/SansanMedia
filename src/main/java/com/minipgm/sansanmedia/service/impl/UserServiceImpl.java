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
    public User login(String wxuid) {
        return userMapper.login(wxuid);
    }

    @Override
    public boolean register(User user) {
        int insertResult = userMapper.register(user);
        return insertResult > 0;
    }

    @Override
    public boolean delUser(String wxuid) {
        int deleteResult = userMapper.delUser(wxuid);
        return deleteResult > 0;
    }

    @Override
    public boolean updateUserName(String wxuid, String customName) {
        int updateResult = userMapper.updateUserName(wxuid, customName);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserPhone(String wxuid, String phone) {
        int updateResult = userMapper.updateUserPhone(wxuid, phone);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserAlipayUser(String wxuid, String alipayUser) {
        return userMapper.updateUserAlipayUser(wxuid, alipayUser) > 0;
    }

}