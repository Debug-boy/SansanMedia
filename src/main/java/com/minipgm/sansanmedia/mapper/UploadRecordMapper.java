package com.minipgm.sansanmedia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface UploadRecordMapper {

    @Insert("INSERT INTO uploadrecord (wxopenid,wxid,upload_time,phone,release_time,article_url,fans,image_base64) VALUES (#{wxopenid},#{wxid},#{upload_time},#{phone},#{release_time},#{article_url},#{fans},#{image_base64,typeHandler=com.minipgm.sansanmedia.handler.ListStringJsonTypeHandler})")
    int upload(String wxopenid, String wxid, LocalDateTime upload_time, String phone, LocalDateTime release_time, String article_url, long fans, List<String> image_base64);


    @Select("SELECT DATE(upload_time) AS date, " +
            "IF(COUNT(*) > 0, 1, 0) AS status " +
            "FROM uploadrecord " +
            "WHERE wxopenid = #{wxopenid} " +
            "AND upload_time >= DATE_FORMAT(CURRENT_DATE, '%Y-%m-01') " +
            "AND upload_time < DATE_FORMAT(DATE_ADD(CURRENT_DATE, INTERVAL 1 MONTH), '%Y-%m-01') " +
            "GROUP BY DATE(upload_time)")
    List<Map<String, Object>> monthStatus(String wxopenid);

}
