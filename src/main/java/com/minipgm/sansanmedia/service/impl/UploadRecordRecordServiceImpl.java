package com.minipgm.sansanmedia.service.impl;

import com.minipgm.sansanmedia.mapper.UploadRecordMapper;
import com.minipgm.sansanmedia.service.UploadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UploadRecordRecordServiceImpl implements UploadRecordService {

    @Autowired
    UploadRecordMapper uploadRecordMapper;

    @Override
    public boolean upload(String wxopenid,String wxid,LocalDateTime upload_time, List<String> image_base64) {
        return this.uploadRecordMapper.upload(wxopenid,wxid,upload_time,image_base64) > 0;
    }

}
