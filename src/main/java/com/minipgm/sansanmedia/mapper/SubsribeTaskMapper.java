package com.minipgm.sansanmedia.mapper;

import com.minipgm.sansanmedia.entity.SubscribeTask;
import com.minipgm.sansanmedia.entity.User;
import com.minipgm.sansanmedia.handler.ListStringJsonTypeHandler;
import com.minipgm.sansanmedia.handler.ListStringTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubsribeTaskMapper {

    @Insert("INSERT INTO subscribe_task (wxopenid, wxname,urls) VALUES (#{wxopenid},#{wxname},#{urls,typeHandler=com.minipgm.sansanmedia.handler.ListStringJsonTypeHandler})")
    public int initUserTask(@Param("wxopenid") String wxopenid, @Param("wxname") String wxname, @Param("urls")List<String>urls);

    @Select("SELECT * FROM subscribe_task WHERE wxopenid = #{wxopenid}")
    @Results({
            @Result(property = "urls", column = "urls", typeHandler = ListStringTypeHandler.class)
    })
    public SubscribeTask getTaskByWxOpenid(@Param("wxopenid") String wxopenid);

    @Update("UPDATE subscribe_task SET wxname = #{wxname} WHERE wxopenid=#{wxopenid}")
    public int updateUserWxName(@Param("wxopneid")String wxopenid,@Param("wxname")String wxname);

    @Update("UPDATE subscribe_task SET urls = #{urls,typeHandler=com.minipgm.sansanmedia.handler.ListStringJsonTypeHandler} where wxopenid = #{wxopenid}")
    public int updateUserTaskUrls(@Param("wxopenid") String wxopenid,@Param("urls")List<String>urls);

    @Update("UPDATE subscribe_task SET `index`=#{index} WHERE wxopenid=#{wxopenid}")
    public int updateUserTaskIndex(@Param("wxopenid")String wxopenid,@Param("index")int index);

    @Delete("DELETE FROM subscribe_task WHERE wxopenid=#{wxopenid}")
    public int deleteUserSubscribeTask(@Param("wxopenid")String wxopenid);
}
