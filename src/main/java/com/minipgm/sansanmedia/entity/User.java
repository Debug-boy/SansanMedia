package com.minipgm.sansanmedia.entity;

public class User {

    String wxid;
    String wxname;
    String custom_name;
    String phone;

    User(){

    }

    User(String wxid, String wxname, String custom_name, String phone) {
        this.wxid = wxid;
        this.wxname = wxname;
        this.custom_name = custom_name;
        this.phone = phone;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
