package com.minipgm.sansanmedia;

import com.minipgm.sansanmedia.entity.SubscribeTask;
import com.minipgm.sansanmedia.handler.ListStringToJsonConverter;
import com.minipgm.sansanmedia.mapper.SubsribeTaskMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SansanMediaApplicationTests {

    @Autowired
    SubsribeTaskMapper subsribeTaskMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void converTest(){
        ListStringToJsonConverter converter = new ListStringToJsonConverter();
        String json = "[\"url1\", \"url2\", \"url3\"]";  // 这个是模拟从数据库取出的 JSON 字符串
        try {
            List<String> urls = converter.convertToEntityAttribute(json);
            System.out.println(urls);  // 应该输出 [url1, url2, url3]
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSubsribeTaskMapper2(){
        SubscribeTask subscribeTask = subsribeTaskMapper.getTaskByWxOpenid("oLEXs6zQv_zTC65_OrYQNxXqpoXc");

        if(subscribeTask != null){
            System.out.println("success!");
        }else{
            System.out.println("urls list is null!");
        }

    }


}
