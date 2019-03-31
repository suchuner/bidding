package com.suchuner.bidding.common.utilpojo;

import java.util.List;

/**
 * @author suchuner
 */
public class PageBean<T> {
    /**
     * 当前页
     */
    private Long currPage;
    /**
     * 每页显示的记录数
     */
    private Long pageSize;
    /**
     * 总记录数
     */
    private Long totalCount;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 当前需要分页查询的对象集合
     */
    private List<T> list;

    public Long getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Long currPage) {
        this.currPage = currPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalCount,Long pageSize) {
        this.totalPage = totalCount%pageSize!=0?(totalCount/pageSize)+1:totalCount/pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
