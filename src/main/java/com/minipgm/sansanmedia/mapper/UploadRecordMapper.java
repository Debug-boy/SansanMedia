package com.minipgm.sansanmedia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UploadRecordMapper {

    @Insert("INSERT INTO uploadrecord (wxopenid,wxid,upload_time,image_base64) VALUES (#{wxopenid},#{wxid},#{upload_time},#{image_base64,typeHandler=com.minipgm.sansanmedia.handler.ListStringJsonTypeHandler})")
    int upload(String wxopenid,String wxid, LocalDateTime upload_time,List<String> image_base64);

}
