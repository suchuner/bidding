package com.suchuner.bidding.mapper;

import com.suchuner.bidding.pojo.Oper;
import com.suchuner.bidding.pojo.OperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperMapper {
    int countByExample(OperExample example);

    int deleteByExample(OperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Oper record);

    int insertSelective(Oper record);

    List<Oper> selectByExample(OperExample example);

    Oper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Oper record, @Param("example") OperExample example);

    int updateByExample(@Param("record") Oper record, @Param("example") OperExample example);

    int updateByPrimaryKeySelective(Oper record);

    int updateByPrimaryKey(Oper record);
}