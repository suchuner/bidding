package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.mapper.ScoreMapper;
import com.suchuner.bidding.pojo.Score;
import com.suchuner.bidding.pojo.ScoreExample;
import com.suchuner.bidding.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suchuner
 */
@Service
public class ScoreService implements IScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    public void addScore(Long pid, Long sid, Long eid, Integer price, Integer bussiness, Integer service, Integer technology) throws Exception {
        List<Score> scores = getScoresByPidAndSid(pid, sid, eid);
        Score score ;
        if (scores.isEmpty()) {
            score = new Score();
            score.setPjtId(pid);
            score.setSupId(sid);
            score.setJudgeId(eid);
            score.setPrice(price);
            score.setBussiness(bussiness);
            score.setService(service);
            score.setTechnology(technology);
            scoreMapper.insertSelective(score);
        } else {
            score = scores.get(0);
            score.setPrice(price);
            score.setBussiness(bussiness);
            score.setService(service);
            score.setTechnology(technology);
            updateScores(score);
        }
    }

    public List<Score> getScoresByPidAndSid(Long pid, Long sid, Long eid) throws Exception {
        ScoreExample scoreExample = new ScoreExample();
        ScoreExample.Criteria criteria = scoreExample.createCriteria();
        criteria.andPjtIdEqualTo(pid);
        criteria.andSupIdEqualTo(sid);
        if(eid!=null) criteria.andJudgeIdEqualTo(eid);
        return scoreMapper.selectByExample(scoreExample);
    }

    public void updateScores(Score score) {
        scoreMapper.updateByPrimaryKeySelective(score);
    }
}
