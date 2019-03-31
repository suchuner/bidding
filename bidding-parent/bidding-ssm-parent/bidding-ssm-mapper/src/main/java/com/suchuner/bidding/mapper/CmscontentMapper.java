package com.suchuner.bidding.mapper;

import com.suchuner.bidding.pojo.Cmscontent;
import com.suchuner.bidding.pojo.CmscontentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmscontentMapper {
    int countByExample(CmscontentExample example);

    int deleteByExample(CmscontentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cmscontent record);

    int insertSelective(Cmscontent record);

    List<Cmscontent> selectByExample(CmscontentExample example);

    Cmscontent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cmscontent record, @Param("example") CmscontentExample example);

    int updateByExample(@Param("record") Cmscontent record, @Param("example") CmscontentExample example);

    int updateByPrimaryKeySelective(Cmscontent record);

    int updateByPrimaryKey(Cmscontent record);
}