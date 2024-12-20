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
    public User login(String wxopenid) {
        return userMapper.login(wxopenid);
    }

    @Override
    public boolean register(User user) {
        int insertResult = userMapper.register(user);
        return insertResult > 0;
    }

    @Override
    public boolean delUser(String wxopenid) {
        int deleteResult = userMapper.delUser(wxopenid);
        return deleteResult > 0;
    }

    @Override
    public boolean updateUserAuth(String wxopenid, boolean auth) {
        int updateResult = userMapper.updateUserAuth(wxopenid, auth);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserCustomName(String wxopenid, String customName) {
        int updateResult = userMapper.updateUserCustomName(wxopenid, customName);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserWxName(String wxopenid, String wxName) {
        int updateResult = userMapper.updateUserWxName(wxopenid, wxName);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserPhone(String wxopenid, String phone) {
        int updateResult = userMapper.updateUserPhone(wxopenid, phone);
        return updateResult > 0;
    }

    @Override
    public boolean updateUserAlipayUser(String wxopenid, String alipayUser) {
        return userMapper.updateUserAlipayUser(wxopenid, alipayUser) > 0;
    }

}