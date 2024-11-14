package com.minipgm.sansanmedia.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UploadRecordService {

    boolean upload(String wxopenid, String wxid, LocalDateTime upload_time, String phone, LocalDateTime release_time, String article_url, long fans, List<String> image_base64);

    List<Map<String, Object>> monthStatus(String wxopenid);

}
