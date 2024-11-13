package com.minipgm.sansanmedia.service;

import java.time.LocalDateTime;
import java.util.List;

public interface UploadRecordService {

    boolean upload(String wxopenid,String wxid,LocalDateTime upload_time, List<String> image_base64);

}
