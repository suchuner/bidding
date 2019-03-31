package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.Score;

import java.util.List;

/**
 * @author suchuner
 */
public interface IScoreService {
    void addScore(Long pid,Long sid,Long eid,Integer price,Integer bussiness,Integer service,Integer technology) throws  Exception;
    List<Score> getScoresByPidAndSid(Long pid, Long sid,Long eid) throws Exception;
}
