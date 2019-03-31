package com.suchuner.bidding.pojo;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable{
    /**
     * 未激活
     */
   public static final int ALIVE_NO = 1;
    /**
     * 已激活
     */
   public static final int ALIVE_YES = 0;

    /**
     * 账户正常
     */
    public static final int NORMAL_YES = 0;
    /**
     * 账户不正常
     */
    public static final int NORMAL_NO = 1;
    private Long id;

    private String busemail;

    private String password;

    private String linkman;

    private String linkmanemail;

    private String phone;

    private Long checkman;

    private Date checkdate;

    private String checkinfo;

    private String bizlicregnum;

    private Date bizlicenddate;

    private String bizlicdoc;

    private String taxregnum;

    private Date taxregenddate;

    private String taxregdoc;

    private String orgcode;

    private Date orgcodeenddate;

    private String orgcodedoc;

    private Integer isalive;

    private Integer isnormal;

    private String companyname;

    private String shortname;

    private String address;

    private String introduction;

    private Long regfund;

    private String lawperson;

    private String idcard;

    private Date startdate;

    private String callnum;

    private String companyemail;

    private String website;

    private Integer typeid;

    private Integer empnums;

    private String frame;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusemail() {
        return busemail;
    }

    public void setBusemail(String busemail) {
        this.busemail = busemail == null ? null : busemail.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmanemail() {
        return linkmanemail;
    }

    public void setLinkmanemail(String linkmanemail) {
        this.linkmanemail = linkmanemail == null ? null : linkmanemail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getCheckman() {
        return checkman;
    }

    public void setCheckman(Long checkman) {
        this.checkman = checkman;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getCheckinfo() {
        return checkinfo;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo == null ? null : checkinfo.trim();
    }

    public String getBizlicregnum() {
        return bizlicregnum;
    }

    public void setBizlicregnum(String bizlicregnum) {
        this.bizlicregnum = bizlicregnum == null ? null : bizlicregnum.trim();
    }

    public Date getBizlicenddate() {
        return bizlicenddate;
    }

    public void setBizlicenddate(Date bizlicenddate) {
        this.bizlicenddate = bizlicenddate;
    }

    public String getBizlicdoc() {
        return bizlicdoc;
    }

    public void setBizlicdoc(String bizlicdoc) {
        this.bizlicdoc = bizlicdoc == null ? null : bizlicdoc.trim();
    }

    public String getTaxregnum() {
        return taxregnum;
    }

    public void setTaxregnum(String taxregnum) {
        this.taxregnum = taxregnum == null ? null : taxregnum.trim();
    }

    public Date getTaxregenddate() {
        return taxregenddate;
    }

    public void setTaxregenddate(Date taxregenddate) {
        this.taxregenddate = taxregenddate;
    }

    public String getTaxregdoc() {
        return taxregdoc;
    }

    public void setTaxregdoc(String taxregdoc) {
        this.taxregdoc = taxregdoc == null ? null : taxregdoc.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public Date getOrgcodeenddate() {
        return orgcodeenddate;
    }

    public void setOrgcodeenddate(Date orgcodeenddate) {
        this.orgcodeenddate = orgcodeenddate;
    }

    public String getOrgcodedoc() {
        return orgcodedoc;
    }

    public void setOrgcodedoc(String orgcodedoc) {
        this.orgcodedoc = orgcodedoc == null ? null : orgcodedoc.trim();
    }

    public Integer getIsalive() {
        return isalive;
    }

    public void setIsalive(Integer isalive) {
        this.isalive = isalive;
    }

    public Integer getIsnormal() {
        return isnormal;
    }

    public void setIsnormal(Integer isnormal) {
        this.isnormal = isnormal;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Long getRegfund() {
        return regfund;
    }

    public void setRegfund(Long regfund) {
        this.regfund = regfund;
    }

    public String getLawperson() {
        return lawperson;
    }

    public void setLawperson(String lawperson) {
        this.lawperson = lawperson == null ? null : lawperson.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getCallnum() {
        return callnum;
    }

    public void setCallnum(String callnum) {
        this.callnum = callnum == null ? null : callnum.trim();
    }

    public String getCompanyemail() {
        return companyemail;
    }

    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail == null ? null : companyemail.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getEmpnums() {
        return empnums;
    }

    public void setEmpnums(Integer empnums) {
        this.empnums = empnums;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame == null ? null : frame.trim();
    }
}