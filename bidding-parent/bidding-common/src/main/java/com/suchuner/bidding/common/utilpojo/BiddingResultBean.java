package com.suchuner.bidding.common.utilpojo;

import java.util.List;

/**
 * @author suchuner
 */
public class BiddingResultBean<T> {
    private Byte flag;
    private String message;
    private Object obj;
    private List<T> list;

    public byte getFlag() {
        return flag;
    }

    public String getMessage() {
        return message;
    }

    public Object getObj() {
        return obj;
    }

    public List<T> getList() {
        return list;
    }

    private BiddingResultBean() {
    }

    private BiddingResultBean(Byte flag, String message, Object obj, List<T> list) {
        this.flag = flag;
        this.message = message;
        this.obj = obj;
        this.list = list;
    }
    public static BiddingResultBean ok(Byte flag){
        return new BiddingResultBean(flag,null,null,null);
    }


    public static BiddingResultBean ok(Byte flag, String message){
        return new BiddingResultBean(flag,message,null,null);
    }

    public static BiddingResultBean ok(Byte flag, String message, Object obj){
        return new BiddingResultBean(flag,message,obj,null);
    }

    public static BiddingResultBean ok(Byte flag, String message, Object obj, List list){
        return new BiddingResultBean(flag,message,obj,list);
    }
}
