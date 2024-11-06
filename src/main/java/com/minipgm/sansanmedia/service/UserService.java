package com.minipgm.sansanmedia.service;

import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.service.impl.UserServiceImpl;

public interface UserService {

    boolean login(String wxid);

    boolean addUser(User user);

    boolean delUser(String wxid);

    boolean updateUserName(String wxid,String custom_name);

    boolean updateUserPhone(String wxid,String phone);

}
