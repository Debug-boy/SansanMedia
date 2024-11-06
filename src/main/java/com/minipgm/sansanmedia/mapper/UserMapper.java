package com.minipgm.sansanmedia.mapper;

import com.minipgm.sansanmedia.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE wxid = #{wxid}")
    User login(@Param("wxid") String wxid);

    @Insert("INSERT INTO users (wxid, wxname, custom_name, phone) VALUES (#{wxid}, #{wxname}, #{custom_name}, #{phone})")
    int insert(User user);

    @Delete("DELETE FROM users WHERE wxid = #{wxid}")
    int delUser(@Param("wxid") String wxid);

    @Update("UPDATE users SET custom_name = #{customName} WHERE wxid = #{wxid}")
    int updateUserName(@Param("wxid") String wxid, @Param("customName") String customName);

    @Update("UPDATE users SET phone = #{phone} WHERE wxid = #{wxid}")
    int updateUserPhone(@Param("wxid") String wxid, @Param("phone") String phone);

}
