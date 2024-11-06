package com.minipgm.sansanmedia.controller;


import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.service.impl.UploadRecordRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/upload")
public class UploadRecordController {

    @Autowired
    UploadRecordRecordServiceImpl uploadService;

    @PostMapping("/detail")
    public ResponseResult<String> detail(
            @RequestParam("wxid") String wxid,
            @RequestParam("image_base64") String image_base64
    ) {
        boolean success = uploadService.upload(wxid, LocalDateTime.now(),image_base64);
        if (success) {
            return ResponseResult.success("上传图片成功!", null);
        } else {
            return ResponseResult.failure("上传图片失败!");
        }
    }


}
