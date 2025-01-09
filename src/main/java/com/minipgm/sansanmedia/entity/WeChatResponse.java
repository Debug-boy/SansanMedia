package com.minipgm.sansanmedia.entity;

public class WeChatResponse {

    private String session_key;
    private String openid;


    public WeChatResponse(){

    }

    public WeChatResponse(String o,String s){
        openid = o;
        session_key = s;
    }

    // Getters and setters
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }


}
