package com.suchuner.bidding.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Expert implements Serializable{
    public static final byte ISNOEMAL_NO = 1;
    public static final byte ISNOEMAL_YES = 0;
    private Long id;

    private String name;

    private Integer gender;

    private Long age;

    private String phone;

    private Integer education;

    private String account;

    private String password;

    private String code;

    private String address;

    private String email;

    private Byte isnormal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getIsnormal() {
        return isnormal;
    }

    public void setIsnormal(Byte isnormal) {
        this.isnormal = isnormal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expert expert = (Expert) o;
        return Objects.equals(getId(), expert.getId()) &&
                Objects.equals(getName(), expert.getName()) &&
                Objects.equals(getGender(), expert.getGender()) &&
                Objects.equals(getAge(), expert.getAge()) &&
                Objects.equals(getPhone(), expert.getPhone()) &&
                Objects.equals(getEducation(), expert.getEducation()) &&
                Objects.equals(getAccount(), expert.getAccount()) &&
                Objects.equals(getPassword(), expert.getPassword()) &&
                Objects.equals(getCode(), expert.getCode()) &&
                Objects.equals(getAddress(), expert.getAddress()) &&
                Objects.equals(getEmail(), expert.getEmail()) &&
                Objects.equals(getIsnormal(), expert.getIsnormal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGender(), getAge(), getPhone(), getEducation(), getAccount(), getPassword(), getCode(), getAddress(), getEmail(), getIsnormal());
    }
}