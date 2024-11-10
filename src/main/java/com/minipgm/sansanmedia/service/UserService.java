package com.minipgm.sansanmedia.service;

import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.service.impl.UserServiceImpl;

public interface UserService {

    User login(String wxuid);

    boolean register(User user);

    boolean delUser(String wxuid);

    boolean updateUserName(String wxuid,String custom_name);

    boolean updateUserPhone(String wxuid,String phone);

    boolean updateUserAlipayUser(String wxuid, String alipayUser);

}
