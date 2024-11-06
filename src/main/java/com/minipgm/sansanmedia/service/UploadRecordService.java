package com.minipgm.sansanmedia.service;

import java.time.LocalDateTime;

public interface UploadRecordService {

    boolean upload(String upload_date, LocalDateTime dateTime, String image_base64);

}
