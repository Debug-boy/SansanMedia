package com.minipgm.sansanmedia.controller;


import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.UploadRecord;
import com.minipgm.sansanmedia.service.impl.UploadRecordRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        if(uploadRecord.getPhone().isEmpty()){
            return ResponseResult.failure("上传图片失败,手机号为空!");
        }

        if(uploadRecord.getArticle_url().isEmpty()){
            return ResponseResult.failure("上传图片失败,发布文章链接为空!");
        }

        if(uploadRecord.getImage_base64().isEmpty()){
            return ResponseResult.failure("上传图片失败,图片列表为空!");
        }

        boolean success = uploadService.upload(
                uploadRecord.getWxopenid(),
                uploadRecord.getWxid(),
                uploadRecord.getUpload_time(),
                uploadRecord.getPhone(),
                uploadRecord.getRelease_time(),
                uploadRecord.getArticle_url(),
                uploadRecord.getFans(),
                uploadRecord.getImage_base64()
        );

        if (success) {
            return ResponseResult.success("打卡成功!", null);
        } else {
            return ResponseResult.failure("未知错误,打卡失败!");
        }
    }

    @PostMapping("/status")
    public ResponseResult<List<Map<String,Object>>> monthStatus(@RequestBody Map<String, String> requestData){

        if(requestData.get("wxopenid").isEmpty()){
            return ResponseResult.failure("wxopenid字段为空!");
        }

        // 获取打卡记录
        List<Map<String, Object>> statusList = uploadService.monthStatus(requestData.get("wxopenid"));

        // 获取当前日期和本月的第一天
        LocalDateTime now = LocalDateTime.now();
        LocalDate startOfMonth = LocalDate.from(now.withDayOfMonth(1));
        LocalDate endOfMonth = LocalDate.from(now.withDayOfMonth(now.toLocalDate().lengthOfMonth()));

        // 生成本月的所有日期（从第一天到本月底）
        List<LocalDate> allDatesInMonth = new ArrayList<>();
        for (LocalDate date = startOfMonth; !date.isAfter(endOfMonth); date = date.plusDays(1)) {
            allDatesInMonth.add(date);
        }

        // 将查询的打卡记录转为Map，便于后续匹配
        Map<String, Long> statusMap = new HashMap<>();
        for (Map<String, Object> record : statusList) {
            Date date = (Date) record.get("date");
            Long status = (Long) record.get("status");
            statusMap.put(date.toString(), status);
        }

        // 生成结果列表
        List<Map<String, Object>> result = new ArrayList<>();
        for (LocalDate date : allDatesInMonth) {
            String dateString = date.toString();
            result.add(Map.of("date", dateString, "status", statusMap.getOrDefault(dateString, 0L))); // 默认status为1（未打卡）
        }

        return ResponseResult.success("获取月打卡状态成功!", result);
    }


}
