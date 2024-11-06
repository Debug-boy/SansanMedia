package com.minipgm.sansanmedia.service.impl;

import com.minipgm.sansanmedia.mapper.UploadRecordMapper;
import com.minipgm.sansanmedia.service.UploadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UploadRecordRecordServiceImpl implements UploadRecordService {

    @Autowired
    UploadRecordMapper uploadRecordMapper;

    @Override
    public boolean upload(String upload_date, LocalDateTime dateTime, String image_base64) {
        return this.uploadRecordMapper.upload(upload_date,dateTime,image_base64) > 0;
    }

}
