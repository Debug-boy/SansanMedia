package com.minipgm.sansanmedia.entity;

import com.minipgm.sansanmedia.handler.ListStringToJsonConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscribe_task")
public class SubscribeTask{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String wxopenid;
    private String wxname;
    private int index;

    @Column(columnDefinition = "longtext")
    @Convert(converter = ListStringToJsonConverter.class)
    private List<String>urls = new ArrayList<>();


    public SubscribeTask(){

    }

    public SubscribeTask(String wxopenid, String wxname, int index, List<String> urls) {
        this.wxopenid = wxopenid;
        this.wxname = wxname;
        this.index = index;
        this.urls = urls;
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

    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }


}
