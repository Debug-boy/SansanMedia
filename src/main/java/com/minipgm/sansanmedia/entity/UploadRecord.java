package com.minipgm.sansanmedia.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "uploadrecord")
public class UploadRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String wxid;

    private LocalDateTime upload_time;

    @Column(columnDefinition = "json")
    private String image_base64;

    public UploadRecord() {
    }

    public UploadRecord(int id, String wxid, LocalDateTime upload_time, String image_base64) {
        this.id = id;
        this.wxid = wxid;
        this.upload_time = upload_time;
        this.image_base64 = image_base64;
    }

    public UploadRecord(String wxid, LocalDateTime upload_time, List<String> images) throws JsonProcessingException {
        this.wxid = wxid;
        this.upload_time = upload_time;
        this.image_base64 = new ObjectMapper().writeValueAsString(images);
    }

    //... getters and setters ...

    public List<String> getImageList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(this.image_base64, objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
    }

    public void setImageList(List<String> images) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.image_base64 = objectMapper.writeValueAsString(images);
    }
}