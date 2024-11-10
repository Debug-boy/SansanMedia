package com.minipgm.sansanmedia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String wxuid;
    String wxid;

    String wxname;
    String custom_name;

    String phone;

    @Column(columnDefinition = "tinyint")
    boolean auth;

    String alipay_user;

    @Column(columnDefinition = "json")
    String register_image;

    private LocalDateTime register_time;

    public User(){

    }

    public User(int id, String wxuid, String wxid, String wxname, String custom_name, String phone,boolean auth, String alipay_user, String register_image,LocalDateTime register_time) {
        this.id = id;
        this.wxuid = wxuid;
        this.wxid = wxid;
        this.wxname = wxname;
        this.custom_name = custom_name;
        this.phone = phone;
        this.auth = auth;
        this.alipay_user = alipay_user;
        this.register_image = register_image;
        this.register_time = register_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxuid() {
        return wxuid;
    }

    public void setWxuid(String wxuid) {
        this.wxuid = wxuid;
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

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getAlipay_user() {
        return alipay_user;
    }

    public void setAlipay_user(String alipay_user) {
        this.alipay_user = alipay_user;
    }

    public String getRegister_image() {
        return register_image;
    }

    public void setRegister_image(String register_image) {
        this.register_image = register_image;
    }

    public LocalDateTime getRegister_time() {
        return register_time;
    }

    public void setRegister_time(LocalDateTime register_time) {
        this.register_time = register_time;
    }
}
