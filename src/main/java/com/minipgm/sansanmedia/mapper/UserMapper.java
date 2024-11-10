package com.minipgm.sansanmedia.mapper;

import com.minipgm.sansanmedia.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE wxuid = #{wxuid}")
    User login(@Param("wxuid") String wxuid);

    @Insert("INSERT INTO users (wxuid, wxid, wxname, custom_name, phone,auth, alipay_user, register_image, register_time) " +
            "VALUES (#{user.wxuid}, #{user.wxid}, #{user.wxname}, #{user.custom_name}, #{user.phone},#{user.auth}, #{user.alipay_user}, #{user.register_image}, #{user.register_time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int register(@Param("user") User user);

    @Delete("DELETE FROM users WHERE wxuid = #{wxuid}")
    int delUser(@Param("wxuid") String wxuid);

    @Update("UPDATE users SET custom_name = #{customName} WHERE wxid = #{wxuid}")
    int updateUserName(@Param("wxuid") String wxuid, @Param("customName") String customName);

    @Update("UPDATE users SET phone = #{phone} WHERE wxid = #{wxuid}")
    int updateUserPhone(@Param("wxuid") String wxuid, @Param("phone") String phone);

    @Update("UPDATE users SET alipay_user = #{alipayUser} WHERE wxuid = #{wxuid}")
    int updateUserAlipayUser(@Param("wxuid") String wxuid, @Param("alipayUser") String alipayUser);

}
