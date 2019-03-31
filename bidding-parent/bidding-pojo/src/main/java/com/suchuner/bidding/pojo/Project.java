package com.suchuner.bidding.pojo;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable{
	   /**
     * 项目未审核
     */
    public static final int STATUS_CHECK_NO = 0;
    /**
     * 项目已审核但未通过
     */
    public static final int STATUS_CHECK_YES_PASS_NO = 1;
    /**
     * 项目已审核且已通过
     */
    public static final int STATUS_CHECK_YES_PASS_YES = 2;
    /**
     * 项目开始招标
     */
    public static final int STATUS_TENDER_START = 3;
    /**
     * 项目竞标
     */
    public static final int STATUS_TENDERING = 4;
    /**
     * 项目招标成功
     */
    public static final int STATUS_TENDER_SUCCESS = 5;
    /**
     * 项目流标
     */
    public static final int STATUS_TENDER_FAILURE = 6;

    /**
     * 第一轮招标:否
     */
    public static final byte IS_BEGIN_NO=0;
    /**
     * 第一轮招标:是
     */
    public static final byte IS_BEGIN_YES=1;

    /**
     * 第一次申请招标
     */
    public static final byte IS_REBIDDING_NO=0;
    /**
     * 招标通过审核的供应商未达到继续招标的标准,需要重新发布招标
     */
    public static final byte IS_REBIDDING_YES=1;
    /**
     * 第一次招标报名通过审核的供应商达到招标的标准,继续招标
     */
    public static final byte IS_REBIDDING_NO_CONTINUE=2;
    private Long id;

    private String projectnum;

    private String itemname;

    private Long budget;

    private String introduction;

    private Integer status;

    private String notice;

    private String biddingdoc;

    private String buylistandreqdoc;

    private String biddingrequiredoc;

    private String otherdoc;

    private Long starter;

    private Long checker;

    private Date startdate;

    private Date checkerdate;

    private Date dateline;

    private Date deadline;

    private Integer judgenums;

    private Long winner;

    private Date enddate;

    private Long bid;

    private Byte isbegin;

    private String reportdoc;

    private Byte isrebidding;

    private String moreWinnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectnum() {
        return projectnum;
    }

    public void setProjectnum(String projectnum) {
        this.projectnum = projectnum == null ? null : projectnum.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getBiddingdoc() {
        return biddingdoc;
    }

    public void setBiddingdoc(String biddingdoc) {
        this.biddingdoc = biddingdoc == null ? null : biddingdoc.trim();
    }

    public String getBuylistandreqdoc() {
        return buylistandreqdoc;
    }

    public void setBuylistandreqdoc(String buylistandreqdoc) {
        this.buylistandreqdoc = buylistandreqdoc == null ? null : buylistandreqdoc.trim();
    }

    public String getBiddingrequiredoc() {
        return biddingrequiredoc;
    }

    public void setBiddingrequiredoc(String biddingrequiredoc) {
        this.biddingrequiredoc = biddingrequiredoc == null ? null : biddingrequiredoc.trim();
    }

    public String getOtherdoc() {
        return otherdoc;
    }

    public void setOtherdoc(String otherdoc) {
        this.otherdoc = otherdoc == null ? null : otherdoc.trim();
    }

    public Long getStarter() {
        return starter;
    }

    public void setStarter(Long starter) {
        this.starter = starter;
    }

    public Long getChecker() {
        return checker;
    }

    public void setChecker(Long checker) {
        this.checker = checker;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getCheckerdate() {
        return checkerdate;
    }

    public void setCheckerdate(Date checkerdate) {
        this.checkerdate = checkerdate;
    }

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getJudgenums() {
        return judgenums;
    }

    public void setJudgenums(Integer judgenums) {
        this.judgenums = judgenums;
    }

    public Long getWinner() {
        return winner;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Byte getIsbegin() {
        return isbegin;
    }

    public void setIsbegin(Byte isbegin) {
        this.isbegin = isbegin;
    }

    public String getReportdoc() {
        return reportdoc;
    }

    public void setReportdoc(String reportdoc) {
        this.reportdoc = reportdoc == null ? null : reportdoc.trim();
    }

    public Byte getIsrebidding() {
        return isrebidding;
    }

    public void setIsrebidding(Byte isrebidding) {
        this.isrebidding = isrebidding;
    }

    public String getMoreWinnerId() {
        return moreWinnerId;
    }

    public void setMoreWinnerId(String moreWinnerId) {
        this.moreWinnerId = moreWinnerId == null ? null : moreWinnerId.trim();
    }
}