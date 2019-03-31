package com.suchuner.bidding.mapper;

import com.suchuner.bidding.pojo.ProjectExpert;
import com.suchuner.bidding.pojo.ProjectExpertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectExpertMapper {
    int countByExample(ProjectExpertExample example);

    int deleteByExample(ProjectExpertExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectExpert record);

    int insertSelective(ProjectExpert record);

    List<ProjectExpert> selectByExample(ProjectExpertExample example);

    ProjectExpert selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectExpert record, @Param("example") ProjectExpertExample example);

    int updateByExample(@Param("record") ProjectExpert record, @Param("example") ProjectExpertExample example);

    int updateByPrimaryKeySelective(ProjectExpert record);

    int updateByPrimaryKey(ProjectExpert record);
}