package com.minipgm.sansanmedia.mapper;

import com.minipgm.sansanmedia.entity.SubscribeLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubsribeMapper {

    @Select("select * from subscribe")
    List<SubscribeLink>getAll();

}
