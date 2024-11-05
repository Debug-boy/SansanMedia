package com.minipgm.sansanmedia.mapper;

import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Select("select * from users")
    Result all();

}
