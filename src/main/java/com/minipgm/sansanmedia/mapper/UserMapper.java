package com.minipgm.sansanmedia.mapper;

import com.minipgm.sansanmedia.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE wxopenid = #{wxopenid}")
    User login(@Param("wxopenid") String wxopenid);

    @Insert("INSERT INTO users (wxopenid, wxid, wxname, custom_name, phone,auth, alipay_user, register_image, register_time) " +
            "VALUES (#{user.wxopenid}, #{user.wxid}, #{user.wxname}, #{user.custom_name}, #{user.phone},#{user.auth}, #{user.alipay_user}, #{user.register_image}, #{user.register_time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int register(@Param("user") User user);

    @Delete("DELETE FROM users WHERE wxopenid = #{wxopenid}")
    int delUser(@Param("wxopenid") String wxopenid);

    @Update("UPDATE users SET custom_name = #{customName} WHERE wxid = #{wxopenid}")
    int updateUserName(@Param("wxopenid") String wxopenid, @Param("customName") String customName);

    @Update("UPDATE users SET phone = #{phone} WHERE wxid = #{wxopenid}")
    int updateUserPhone(@Param("wxopenid") String wxopenid, @Param("phone") String phone);

    @Update("UPDATE users SET alipay_user = #{alipayUser} WHERE wxopenid = #{wxopenid}")
    int updateUserAlipayUser(@Param("wxopenid") String wxopenid, @Param("alipayUser") String alipayUser);

}
