package com.minipgm.sansanmedia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface UploadRecordMapper {

    @Insert("INSERT INTO uploadrecord (wxid,upload_time, image_base64) VALUES (#{wxid},#{upload_time}, #{image_base64})")
    int upload(String wxid, LocalDateTime upload_time, String image_base64);

}
