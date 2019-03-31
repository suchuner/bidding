package com.suchuner.bidding.pojo;

import java.io.Serializable;

public class Bidding implements Serializable{
    public static final byte IS_WINNER_NO = 0;
    public static final byte IS_WINNER_YES = 1;
    public static final byte IS_BEGIN_NO = 0;
    public static final byte IS_BEGIN_YES = 1;
    public static final int IS_MARGIN_YES = 0;
    public static final int IS_MARGIN_NO = 1;
    private Project project;
    private Supplier supplier;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    private Long id;

    private Long pjtId;

    private Long supId;

    private Long marginId;

    private Integer ismargin;

    private Long margin;

    private Long cash;

    private String margindoc;

    private Integer score;

    private Byte iswinner;

    private String listpricedoc;

    private String biddoc;

    private String otherdoc;

    private Double price;

    private Double bussiness;

    private Double service;

    private Double technology;

    private Double totalscore;

    private Byte isBegin;

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

    public Long getMarginId() {
        return marginId;
    }

    public void setMarginId(Long marginId) {
        this.marginId = marginId;
    }

    public Integer getIsmargin() {
        return ismargin;
    }

    public void setIsmargin(Integer ismargin) {
        this.ismargin = ismargin;
    }

    public Long getMargin() {
        return margin;
    }

    public void setMargin(Long margin) {
        this.margin = margin;
    }

    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }

    public String getMargindoc() {
        return margindoc;
    }

    public void setMargindoc(String margindoc) {
        this.margindoc = margindoc == null ? null : margindoc.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte getIswinner() {
        return iswinner;
    }

    public void setIswinner(Byte iswinner) {
        this.iswinner = iswinner;
    }

    public String getListpricedoc() {
        return listpricedoc;
    }

    public void setListpricedoc(String listpricedoc) {
        this.listpricedoc = listpricedoc == null ? null : listpricedoc.trim();
    }

    public String getBiddoc() {
        return biddoc;
    }

    public void setBiddoc(String biddoc) {
        this.biddoc = biddoc == null ? null : biddoc.trim();
    }

    public String getOtherdoc() {
        return otherdoc;
    }

    public void setOtherdoc(String otherdoc) {
        this.otherdoc = otherdoc == null ? null : otherdoc.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBussiness() {
        return bussiness;
    }

    public void setBussiness(Double bussiness) {
        this.bussiness = bussiness;
    }

    public Double getService() {
        return service;
    }

    public void setService(Double service) {
        this.service = service;
    }

    public Double getTechnology() {
        return technology;
    }

    public void setTechnology(Double technology) {
        this.technology = technology;
    }

    public Double getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Double totalscore) {
        this.totalscore = totalscore;
    }

    public Byte getIsBegin() {
        return isBegin;
    }

    public void setIsBegin(Byte isBegin) {
        this.isBegin = isBegin;
    }
}