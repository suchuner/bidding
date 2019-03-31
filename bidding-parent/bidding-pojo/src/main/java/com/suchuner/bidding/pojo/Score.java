package com.suchuner.bidding.pojo;

import java.io.Serializable;

public class Score implements Serializable{
    private Long id;

    private Long pjtId;

    private Long supId;

    private Long judgeId;

    private Integer price;

    private Integer bussiness;

    private Integer service;

    private Integer technology;

    private String suggestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPjtId() {
        return pjtId;
    }

    public void setPjtId(Long pjtId) {
        this.pjtId = pjtId;
    }

    public Long getSupId() {
        return supId;
    }

    public void setSupId(Long supId) {
        this.supId = supId;
    }

    public Long getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Long judgeId) {
        this.judgeId = judgeId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBussiness() {
        return bussiness;
    }

    public void setBussiness(Integer bussiness) {
        this.bussiness = bussiness;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public Integer getTechnology() {
        return technology;
    }

    public void setTechnology(Integer technology) {
        this.technology = technology;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }
}