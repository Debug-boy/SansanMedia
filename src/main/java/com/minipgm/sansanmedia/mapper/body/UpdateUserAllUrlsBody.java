package com.minipgm.sansanmedia.mapper.body;

import java.util.List;

public class UpdateUserAllUrlsBody {

    private String wxopenid;

    private List<String> urls;

    public UpdateUserAllUrlsBody(){

    }

    public UpdateUserAllUrlsBody(String wxopneid, List<String> urls) {
        this.wxopenid = wxopneid;
        this.urls = urls;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public boolean wxopenidNotNull(){
        return wxopenid != null;
    }

    public boolean urlsNotNull(){
        return urls != null;
    }

}
