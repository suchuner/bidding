package com.suchuner.bidding.mapper;

import com.suchuner.bidding.pojo.Enroll;
import com.suchuner.bidding.pojo.EnrollExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnrollMapper {
    int countByExample(EnrollExample example);

    int deleteByExample(EnrollExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Enroll record);

    int insertSelective(Enroll record);

    List<Enroll> selectByExample(EnrollExample example);

    Enroll selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByExample(@Param("record") Enroll record, @Param("example") EnrollExample example);

    int updateByPrimaryKeySelective(Enroll record);

    int updateByPrimaryKey(Enroll record);
}