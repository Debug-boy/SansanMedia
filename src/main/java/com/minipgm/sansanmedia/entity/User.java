package com.minipgm.sansanmedia.entity;

import com.minipgm.sansanmedia.handler.ListStringToJsonConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String wxopenid;
    String wxid;

    String wxname;
    String custom_name;

    String phone;

    @Column(columnDefinition = "tinyint")
    boolean auth;

    String alipay_user;

    @Column(columnDefinition = "longtext")
    @Convert(converter = ListStringToJsonConverter.class)
    private List<String> register_image = new ArrayList<>();

    private LocalDateTime register_time;

    public User(){

    }

    public User(int id, String wxopenid, String wxid, String wxname, String custom_name, String phone, boolean auth, String alipay_user, List<String> register_image, LocalDateTime register_time) {
        this.id = id;
        this.wxopenid = wxopenid;
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

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxuid) {
        this.wxopenid = wxuid;
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

    public List<String> getRegister_image() {
        return register_image;
    }

    public void setRegister_image(List<String> register_image) {
        this.register_image = register_image;
    }

    public LocalDateTime getRegister_time() {
        return register_time;
    }

    public void setRegister_time(LocalDateTime register_time) {
        this.register_time = register_time;
    }
}
