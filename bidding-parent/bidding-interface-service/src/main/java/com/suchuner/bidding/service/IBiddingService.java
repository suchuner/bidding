package com.suchuner.bidding.service;

import com.suchuner.bidding.common.utilpojo.BiddingResultBean;
import com.suchuner.bidding.pojo.Bidding;

import java.util.List;

/**
 * @author suchuner
 */
public interface IBiddingService {
     void addBidding(Bidding bidding) throws  Exception;

     void updateBidding(Bidding bidding) throws  Exception;

    List<Bidding> getBiddingsBySid(Long sid, Byte isBegin) throws Exception;

     void doSupplierMarginSubmit(Long pid, Long sid, String marginDoc) throws Exception;

    /**项目查询供应商的竞标信息
     * @param pid  项目的id
     * @param isMargin false:表示查询未提交保证金的所有的供应商,true:表示查询所有提交了保证金的供应商(该项目下)
     * @param isBegin null :代表第一轮招标,第二轮招标 都需要被查询 true 表示只需要查询第一轮的 false 表示查询第二轮
     * @return
     * @throws Exception
     */
     List<Bidding> getBiddingsByPid(Long pid,Boolean isMargin,Boolean isBegin) throws Exception;

     Integer getBiddingsCountByPid(Long pid,Boolean isMargin,Boolean isBegin);

     void doCheckSupplierMarginByBidding(Bidding bidding,Byte isMaigin) throws Exception;


     Bidding getBiddingByPidAndSid(Long pid,Long sid) throws Exception;

    void doSupplierBidDocSubmit(Bidding bidding) throws Exception;

    void doScoreAVGByPidAndSid(Long pid,Long sid) throws Exception;

    /**
     * @param pid
     * @return flag==0,有且只有一个中标者,obj为供应商id;flag==1,存在多个中标者,obj为包含多个供应商id的Long数组
     * @throws Exception
     */
    BiddingResultBean doJudgeWinnerExistOneOrMore(Long pid,Boolean isBegin) throws Exception;

    BiddingResultBean selectTheBestWinnerOrReBidding(Long pid,Boolean isBegin) throws Exception;

    Bidding getBiddingById(Long id) throws Exception;

    Integer getBiddingsCountBySid(Long sid, Byte isBegin);

}
