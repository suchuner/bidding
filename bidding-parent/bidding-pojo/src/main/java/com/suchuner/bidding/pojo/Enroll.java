package com.suchuner.bidding.pojo;

import java.io.Serializable;
import java.util.Date;

public class Enroll implements Serializable{
    /**
     * 报名成功
     */
    public static final byte IS_ENROLL_YES = 0;
    /**
     * 报名失败
     */
    public static final byte IS_ENROLL_NO = 1;
    /**
     * 已提交保证金
     */
    public static final byte IS_MARGIN_YES = 0;
    /**
     * 未提交保证金
     */
    public static final byte IS_MARGIN_NO = 1;
    /**
     * 报名正常
     */
    public static final byte IS_NORMAL_YES = 0;
    /**
     * 第一次报名审核失败
     */
    public static final byte IS_NORMAL_NO = 1;
    /**
     * 第一次报名审核
     */
    public static final byte IS_NORMAL_FRIST = 2;

    private Long id;

    private Long pjtId;

    private Long supId;

    private Date enrolldate;

    private Long crediterId;

    private Date checkdate;

    private Byte isnormal;

    private Byte isenroll;
    /**该字段暂时用于做保证金的提交判断*/
    private Byte islegal;

    private String legaldoc;

    private Byte istax;

    private String taxdoc;

    private Byte issocialinsurance;

    private String sidoc;

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

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public Long getCrediterId() {
        return crediterId;
    }

    public void setCrediterId(Long crediterId) {
        this.crediterId = crediterId;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Byte getIsnormal() {
        return isnormal;
    }

    public void setIsnormal(Byte isnormal) {
        this.isnormal = isnormal;
    }

    public Byte getIsenroll() {
        return isenroll;
    }

    public void setIsenroll(Byte isenroll) {
        this.isenroll = isenroll;
    }

    public Byte getIslegal() {
        return islegal;
    }

    /**该字段暂时用于做保证金的提交判断
     * @param islegal
     */
    public void setIslegal(Byte islegal) {
        this.islegal = islegal;
    }

    public String getLegaldoc() {
        return legaldoc;
    }

    public void setLegaldoc(String legaldoc) {
        this.legaldoc = legaldoc == null ? null : legaldoc.trim();
    }

    public Byte getIstax() {
        return istax;
    }

    public void setIstax(Byte istax) {
        this.istax = istax;
    }

    public String getTaxdoc() {
        return taxdoc;
    }

    public void setTaxdoc(String taxdoc) {
        this.taxdoc = taxdoc == null ? null : taxdoc.trim();
    }

    public Byte getIssocialinsurance() {
        return issocialinsurance;
    }

    public void setIssocialinsurance(Byte issocialinsurance) {
        this.issocialinsurance = issocialinsurance;
    }

    public String getSidoc() {
        return sidoc;
    }

    public void setSidoc(String sidoc) {
        this.sidoc = sidoc == null ? null : sidoc.trim();
    }
}