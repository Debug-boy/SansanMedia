package com.minipgm.sansanmedia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface UploadRecordMapper {

    @Insert("INSERT INTO uploadrecord (wxid,upload_date, image_base64) VALUES (#{wxid},#{upload_date}, #{image_base64})")
    int upload(String wxid, LocalDateTime upload_date, String image_base64);

}
