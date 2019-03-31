package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.Expert;
import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.TbUser;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author suchuner
 */
public interface IProjectService {
     void addProject(Project project) throws Exception;

    /**该方法用于对项目进行审核和改变项目的状态
     * @param project
     * @param statusCode 将需要项目设置的状态码传入,传入什么状态就设置为什么状态
     * @throws Exception
     */
     void doProjectCheckByStatusCode(Project project, Integer statusCode) throws Exception;

     Project getProjectByPid(Long pid) throws Exception;

    /**该方法用于通过项目的状态码查询符合该状态码的集合
     * @param statusCode
     * @return 查询到的项目集合
     */
     List<Project> selectProjectsByStatusCode(Integer statusCode) throws Exception;

     Integer selectProjectCountByStatusCode(Integer statusCode) throws Exception;

     TbUser getLoginUserByLoginToken(String token) throws Exception;

    /**添加招标公告,设置投标截止日期
     * @param pid
     * @param noticeMessage
     * @param deadline
     */
     void addBiddingNotice(Long pid, String noticeMessage, Date deadline) throws Exception;

    /**
     * @param project
     * @return 返回为true,则代表可以符合竞标条件,false表示符合条件的供应商未达到规定的数量
     * @throws Exception
     */
     Boolean doJudgeIsRebiddingOrContinue(Project project) throws Exception;

    /**该方法用于为传入的招标项目设置nums个随机的评标人
     * @param project
     * @param nums
     * @param flag 该参数用于指定是否是新生成随机人数还是更新随机人数 0:新生成 1:更新数据
     * @return
     * @throws Exception
     */
     Set<Expert> doSelectJudgeForRandomByProjectAndNums(Project project, Integer nums, byte flag) throws Exception;

     void updateProject(Project project)throws Exception;
}
