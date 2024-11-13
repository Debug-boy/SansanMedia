package com.minipgm.sansanmedia.entity;

import com.minipgm.sansanmedia.handler.ListStringToJsonConverter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "uploadrecord")
public class UploadRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String wxopenid;

    private String wxid;

    private LocalDateTime upload_time;

    @Column(columnDefinition = "longtext")
    @Convert(converter = ListStringToJsonConverter.class)
    private List<String> image_base64;

    public UploadRecord() {

    }

    public UploadRecord(int id, String wxopenid, String wxid, LocalDateTime upload_time, List<String> image_base64) {
        this.id = id;
        this.wxopenid = wxopenid;
        this.wxid = wxid;
        this.upload_time = upload_time;
        this.image_base64 = image_base64;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }


    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public LocalDateTime getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(LocalDateTime upload_time) {
        this.upload_time = upload_time;
    }

    public List<String> getImage_base64() {
        return image_base64;
    }

    public void setImage_base64(List<String> image_base64) {
        this.image_base64 = image_base64;
    }
}