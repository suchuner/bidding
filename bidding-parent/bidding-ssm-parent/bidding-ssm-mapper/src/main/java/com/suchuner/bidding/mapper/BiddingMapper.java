package com.suchuner.bidding.mapper;

import com.suchuner.bidding.pojo.Bidding;
import com.suchuner.bidding.pojo.BiddingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BiddingMapper {
    int countByExample(BiddingExample example);

    int deleteByExample(BiddingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bidding record);

    int insertSelective(Bidding record);

    List<Bidding> selectByExample(BiddingExample example);

    Bidding selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bidding record, @Param("example") BiddingExample example);

    int updateByExample(@Param("record") Bidding record, @Param("example") BiddingExample example);

    int updateByPrimaryKeySelective(Bidding record);

    int updateByPrimaryKey(Bidding record);
}