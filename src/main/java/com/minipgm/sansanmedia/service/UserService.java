package com.minipgm.sansanmedia.service;

import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.service.impl.UserServiceImpl;

public interface UserService {

    User login(String wxopenid);

    boolean register(User user);

    boolean delUser(String wxopenid);

    boolean updateUserAuth(String wxopenid,boolean auth);

    boolean updateUserCustomName(String wxopenid,String customName);

    boolean updateUserWxName(String wxopenid,String wxName);

    boolean updateUserPhone(String wxopenid,String phone);

    boolean updateUserAlipayUser(String wxopenid, String alipayUser);

}
