package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.pojo.Expert;
import com.suchuner.bidding.pojo.Score;
import com.suchuner.bidding.service.IExpertService;
import com.suchuner.bidding.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author suchuner
 */
@Controller
public class ScoreController {
    @Autowired
    private IScoreService scoreService;

    @Autowired
    private IExpertService expertService;

    @RequestMapping("/score/addScore")
    public void addScore(Long pid, Long sid, Integer price, Integer bussiness, Integer service, Integer technology , HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_EXPERT", true);
        Expert expert = expertService.getLoginExpertByLoginToken(token);
        if(expert==null){
            CommonUtils.returnMessages(response,false,"你还没有登录!");
            return ;
        }
        try {
            scoreService.addScore(pid,sid,expert.getId(),price,bussiness,service,technology);
            CommonUtils.returnMessages(response,true,"添加分数成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,false,"添加分数失败!");
        }
    }
    @RequestMapping("/score/getScoresByPidAndSid/{pid}/{sid}")
    public void getScoresByPidAndSid(@PathVariable Long pid,@PathVariable Long sid,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_EXPERT", true);
        Expert expert = expertService.getLoginExpertByLoginToken(token);
        if(expert==null){
            CommonUtils.returnMessages(response,false,"你还没有登录!");
            return ;
        }
        List<Score> scores = scoreService.getScoresByPidAndSid(pid, sid, expert.getId());
        if(scores.isEmpty())CommonUtils.returnMessages(response,false,null);
        else CommonUtils.returnMessages(response,true,scores.get(0));
    }
}
