package com.minipgm.sansanmedia.service.impl;

import com.minipgm.sansanmedia.mapper.UploadRecordMapper;
import com.minipgm.sansanmedia.service.UploadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UploadRecordRecordServiceImpl implements UploadRecordService {

    @Autowired
    UploadRecordMapper uploadRecordMapper;

    @Override
    public boolean upload(String wxopenid, String wxid, LocalDateTime upload_time, String phone, LocalDateTime release_time, String article_url, long fans, List<String> image_base64) {
        return this.uploadRecordMapper.upload(wxopenid, wxid, upload_time, phone, release_time, article_url, fans, image_base64) > 0;
    }

    @Override
    public List<Map<String, Object>> monthStatus(String wxopenid) {
        return this.uploadRecordMapper.monthStatus(wxopenid);
    }

}
