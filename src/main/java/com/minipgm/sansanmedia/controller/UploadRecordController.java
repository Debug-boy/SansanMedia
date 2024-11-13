package com.minipgm.sansanmedia.controller;


import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.UploadRecord;
import com.minipgm.sansanmedia.service.impl.UploadRecordRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/upload")
public class UploadRecordController {

    @Autowired
    UploadRecordRecordServiceImpl uploadService;

    @PostMapping("/detail")
    public ResponseResult<String> detail(@RequestBody UploadRecord uploadRecord) {

        if(uploadRecord.getWxopenid().isEmpty()){
            return ResponseResult.failure("上传图片失败,wxopenid字段为空!");
        }

        if(uploadRecord.getWxid().isEmpty()){
            return ResponseResult.failure("上传图片失败,wxid字段为空!");
        }

        if(uploadRecord.getImage_base64().isEmpty()){
            return ResponseResult.failure("上传图片失败,图片列表为空!");
        }

        boolean success = uploadService.upload(
                uploadRecord.getWxopenid(),uploadRecord.getWxid(), LocalDateTime.now(),uploadRecord.getImage_base64()
        );
        if (success) {
            return ResponseResult.success("上传图片成功!", null);
        } else {
            return ResponseResult.failure("上传图片失败!");
        }
    }


}
