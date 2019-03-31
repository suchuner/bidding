package com.suchuner.bidding.mapper;

import com.suchuner.bidding.pojo.Cms;
import com.suchuner.bidding.pojo.CmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsMapper {
    int countByExample(CmsExample example);

    int deleteByExample(CmsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cms record);

    int insertSelective(Cms record);

    List<Cms> selectByExample(CmsExample example);

    Cms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cms record, @Param("example") CmsExample example);

    int updateByExample(@Param("record") Cms record, @Param("example") CmsExample example);

    int updateByPrimaryKeySelective(Cms record);

    int updateByPrimaryKey(Cms record);
}