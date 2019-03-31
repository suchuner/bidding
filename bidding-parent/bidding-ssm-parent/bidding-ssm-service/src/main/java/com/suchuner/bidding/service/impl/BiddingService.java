package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utilpojo.BiddingResultBean;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.mapper.BiddingMapper;
import com.suchuner.bidding.pojo.*;
import com.suchuner.bidding.service.IBiddingService;
import com.suchuner.bidding.service.IProjectService;
import com.suchuner.bidding.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author suchuner
 */
@Service
public class BiddingService implements IBiddingService {
    @Autowired
    private BiddingMapper biddingMapper;

    @Autowired
    private IScoreService scoreService;

    @Autowired
    private IProjectService projectService;

    @Value("${BIDDING.MARGIN.CASH}")
    private Long MARGIN_CASH;

    public void addBidding(Bidding bidding) throws Exception {
        bidding.setIswinner(Bidding.IS_WINNER_NO);
        bidding.setIsBegin(Bidding.IS_BEGIN_YES);
        biddingMapper.insert(bidding);
    }

    public void updateBidding(Bidding bidding) throws Exception {
        biddingMapper.updateByPrimaryKeySelective(bidding);
    }

    public List<Bidding> getBiddingsBySid(Long sid, Byte isBegin) throws Exception {
        BiddingExample biddingExample =  new BiddingExample();
        BiddingExample.Criteria criteria = biddingExample.createCriteria();
        criteria.andSupIdEqualTo(sid);
        criteria.andIsmarginEqualTo(Bidding.IS_MARGIN_YES);
        criteria.andIsBeginEqualTo(isBegin);
        return biddingMapper.selectByExample(biddingExample);
    }
    public Integer getBiddingsCountBySid(Long sid, Byte isBegin) {
        BiddingExample biddingExample =  new BiddingExample();
        BiddingExample.Criteria criteria = biddingExample.createCriteria();
        criteria.andSupIdEqualTo(sid);
        criteria.andIsmarginEqualTo(Bidding.IS_MARGIN_YES);
        criteria.andIsBeginEqualTo(isBegin);
        return biddingMapper.countByExample(biddingExample);
    }



    public void doSupplierMarginSubmit(Long pid, Long sid, String marginDoc) throws Exception {
        //为该项目生成竞标表
        Bidding bidding = new Bidding();
        bidding.setPjtId(pid);
        bidding.setSupId(sid);
        bidding.setMargindoc(marginDoc);
        bidding.setMargin(MARGIN_CASH);
        bidding.setIsmargin(Bidding.IS_MARGIN_NO);
        addBidding(bidding);
    }

    public List<Bidding> getBiddingsByPid(Long pid,Boolean isMargin,Boolean isBegin) throws Exception{
        BiddingExample biddingExample =  new BiddingExample();
        BiddingExample.Criteria criteria = biddingExample.createCriteria();
        criteria.andPjtIdEqualTo(pid);
        if(isMargin)criteria.andIsmarginEqualTo((int) Enroll.IS_MARGIN_YES);
        else criteria.andIsmarginEqualTo((int) Enroll.IS_MARGIN_NO);
        if(isBegin!=null){
            if(isBegin) criteria.andIsBeginEqualTo(Bidding.IS_BEGIN_YES);
            else criteria.andIsBeginEqualTo(Bidding.IS_BEGIN_NO);
        }
        return biddingMapper.selectByExample(biddingExample);
    }
    public Integer getBiddingsCountByPid(Long pid,Boolean isMargin,Boolean isBegin) {
        BiddingExample biddingExample =  new BiddingExample();
        BiddingExample.Criteria criteria = biddingExample.createCriteria();
        criteria.andPjtIdEqualTo(pid);
        if(isMargin)criteria.andIsmarginEqualTo((int) Enroll.IS_MARGIN_YES);
        else criteria.andIsmarginEqualTo((int) Enroll.IS_MARGIN_NO);
        if(isBegin!=null){
            if(isBegin) criteria.andIsBeginEqualTo(Bidding.IS_BEGIN_YES);
            else criteria.andIsBeginEqualTo(Bidding.IS_BEGIN_NO);
        }
        return biddingMapper.countByExample(biddingExample);
    }

    public void doCheckSupplierMarginByBidding(Bidding bidding,Byte isMaigin) throws Exception{
        switch (isMaigin){
            case 0: bidding.setIsmargin(Bidding.IS_MARGIN_YES);break;
            case 1: bidding.setIsmargin(Bidding.IS_MARGIN_NO);break;
            default:throw new BiddingException("非法参数异常,操作终止!");
        }
        biddingMapper.updateByPrimaryKeySelective(bidding);
    }


    public Bidding getBiddingByPidAndSid(Long pid, Long sid) throws Exception{
        BiddingExample biddingExample = new BiddingExample();
        BiddingExample.Criteria criteria = biddingExample.createCriteria();
        criteria.andPjtIdEqualTo(pid);
        criteria.andSupIdEqualTo(sid);
        List<Bidding> biddings = biddingMapper.selectByExample(biddingExample);
        return biddings.size()>0?biddings.get(0):null;
    }

    public void doSupplierBidDocSubmit(Bidding bidding) throws  Exception{
        biddingMapper.updateByPrimaryKeySelective(bidding);
    }

    public void doScoreAVGByPidAndSid(Long pid, Long sid) throws Exception {
        Project project = projectService.getProjectByPid(pid);
        List<Score> scores = scoreService.getScoresByPidAndSid(pid, sid,null);
        if(project.getJudgenums()>scores.size()){
            throw new BiddingException("请稍后再试,评标人未全部完成供应商的评分工作;该操作终止!");
        }
        Bidding bidding = getBiddingByPidAndSid(pid, sid);
        Double priceScore = 0.0;
        Double bussinessScore = 0.0;
        Double serviceScore = 0.0;
        Double technologyScore = 0.0;
        for (Score score : scores) {
            priceScore= score.getPrice()+priceScore;
            bussinessScore=score.getBussiness()+bussinessScore;
            serviceScore=score.getService()+serviceScore;
            technologyScore=score.getTechnology()+technologyScore;
        }
        bidding.setPrice(priceScore / scores.size());
        bidding.setBussiness(bussinessScore / scores.size());
        bidding.setService(serviceScore / scores.size());
        bidding.setTechnology(technologyScore / scores.size());
        bidding.setTotalscore((priceScore+bussinessScore+serviceScore+technologyScore) / scores.size());
        biddingMapper.updateByPrimaryKeySelective(bidding);
    }

    /**
     * 有且只有一个中标者
     */
    public static final byte IS_EXIST_WINNER_YES=0;
    /**
     * 存在多个中标者,需要重新投标
     */
    public static final byte IS_EXIST_WINNER_MORE=1;

    public BiddingResultBean doJudgeWinnerExistOneOrMore(Long pid,Boolean isBegin) throws Exception {
        List<Bidding> biddings = getBiddingsByPid(pid,true,isBegin);
        if(biddings.get(0).getTotalscore()==null){
            throw new BiddingException("业务逻辑错误!");
        }
        Double flag = biddings.get(0).getTotalscore();
        for (Bidding bidding : biddings) {
            if (bidding.getTotalscore() > flag) {
                flag = bidding.getTotalscore();
            }
        }
        BiddingExample biddingExample = new BiddingExample();
        BiddingExample.Criteria criteria = biddingExample.createCriteria();
        criteria.andTotalscoreEqualTo(flag);
        List<Bidding> biddings1 = biddingMapper.selectByExample(biddingExample);
        if(biddings1.size()>1){
            StringBuffer record =new StringBuffer();
            for (int i=0;i<biddings1.size();i++) {
                record.append(biddings1.get(i).getSupId());
                if(i!=biddings1.size()-1){
                    record.append(",");
                }
            }
            return BiddingResultBean.ok(BiddingService.IS_EXIST_WINNER_MORE,null,record);
        }else{
            return BiddingResultBean.ok(BiddingService.IS_EXIST_WINNER_YES,null,biddings1.get(0));
        }
    }

    public BiddingResultBean selectTheBestWinnerOrReBidding(Long pid,Boolean isBegin) throws Exception {
        BiddingResultBean biddingResultBean = doJudgeWinnerExistOneOrMore(pid,isBegin);
        Project project = projectService.getProjectByPid(pid);
        if(biddingResultBean.getFlag()==BiddingService.IS_EXIST_WINNER_YES) {
            project.setWinner(((Bidding)biddingResultBean.getObj()).getSupId());
            project.setEnddate(new Date());
            project.setStatus(Project.STATUS_TENDER_SUCCESS);
            projectService.updateProject(project);
            Bidding bidding = getBiddingByPidAndSid(pid, ((Bidding)biddingResultBean.getObj()).getSupId());
            bidding.setIswinner(Bidding.IS_WINNER_YES);
            updateBidding(bidding);
            return BiddingResultBean.ok(BiddingService.IS_EXIST_WINNER_YES,"中标人已经产生!",((Bidding) biddingResultBean.getObj()).getSupId());
        }else{
            project.setIsbegin(Project.IS_BEGIN_NO);
            project.setStatus(Project.STATUS_TENDERING);
            project.setMoreWinnerId(biddingResultBean.getObj().toString());
            projectService.updateProject(project);
            Long[] longs = CommonUtils.numStringsConvertToLongArr(project.getMoreWinnerId());
            for (Long aLong : longs) {
                Bidding bidding = getBiddingByPidAndSid(pid, aLong);
                bidding.setIsBegin(Bidding.IS_BEGIN_NO);
                updateBidding(bidding);
            }
            return BiddingResultBean.ok(BiddingService.IS_EXIST_WINNER_MORE,"存在多位中标者,最高分相同者重新投标",biddingResultBean.getObj());
        }
    }

    public Bidding getBiddingById(Long id) throws Exception{
        Bidding bidding = biddingMapper.selectByPrimaryKey(id);
        if(bidding==null){
            throw new BiddingException("非法参数异常,操作终止!");
        }
        return bidding;
    }
}
