package com.suchuner.bidding.pojo;

import java.io.Serializable;
import java.util.Date;

public class Oper implements Serializable{
    private Long id;

    private String opername;

    private String operator;

    private Long operId;

    private String operitemname;

    private Long operitemId;

    private Date operdate;

    private Integer types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpername() {
        return opername;
    }

    public void setOpername(String opername) {
        this.opername = opername == null ? null : opername.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperitemname() {
        return operitemname;
    }

    public void setOperitemname(String operitemname) {
        this.operitemname = operitemname == null ? null : operitemname.trim();
    }

    public Long getOperitemId() {
        return operitemId;
    }

    public void setOperitemId(Long operitemId) {
        this.operitemId = operitemId;
    }

    public Date getOperdate() {
        return operdate;
    }

    public void setOperdate(Date operdate) {
        this.operdate = operdate;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }
}