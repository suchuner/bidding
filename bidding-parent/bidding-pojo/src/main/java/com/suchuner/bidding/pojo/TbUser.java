package com.suchuner.bidding.pojo;

import java.io.Serializable;

public class TbUser implements Serializable{
    public static final byte ISNORMAL_NO = 1;
    public static final byte ISNORMAL_YES = 0;
    private Long id;

    private String username;

    private String password;

    private String name;

    private Integer gender;

    private String email;

    private String tele;

    private String address;

    private Byte isnormal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getIsnormal() {
        return isnormal;
    }

    public void setIsnormal(Byte isnormal) {
        this.isnormal = isnormal;
    }
}