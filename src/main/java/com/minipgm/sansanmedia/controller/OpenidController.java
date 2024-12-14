package com.minipgm.sansanmedia.controller;

import com.minipgm.sansanmedia.entity.ResponseResult;
import com.minipgm.sansanmedia.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/openid")
public class OpenidController {

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.secret}")
    private String secret;

    private final RestTemplate restTemplate;

    public OpenidController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/getUserOpenid")
    public ResponseResult<String> getUserOpenid(@RequestBody Map<String, String> requestData) {
        if (requestData.get("code").isEmpty()) {
            return ResponseResult.failure("code字段为空!");
        }

        String code = requestData.get("code");
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code&connect_redirect=1", appid, secret, code);

        // 发送 GET 请求
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // 如果请求成功
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            return ResponseResult.success(responseBody);
        } else {
            return ResponseResult.failure("请求微信接口失败");
        }
    }
}
