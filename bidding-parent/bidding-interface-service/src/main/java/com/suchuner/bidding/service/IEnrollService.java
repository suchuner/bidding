package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.Enroll;

import java.util.List;

/**
 * @author suchuner
 */
public interface IEnrollService {

     void addEnroll(Enroll enroll) throws Exception;

     void doCheckProjectEnrollToSuccess(Enroll enroll) throws Exception;

     List<Enroll> selectProjectToCheckByPid(Long pid) throws Exception;

     void doCheckProjectEnrollToFailure(Enroll enroll, String message) throws  Exception;

    /**该方法为校验方法,防止一个供应商多次报名同一招标项目
     * @param pjtId
     * @param sid
     * @return
     * @throws Exception
     */
     List<Enroll> getEnrollsByPidAndSid(Long pjtId, Long sid) throws Exception;

     void deleteEnroll(Enroll enroll) throws Exception;

    /**
     * @param sid
     * @param checkCode 0:代表查询报名通过的项目报名,1:代表查询不通过的项目报名
     * @return
     * @throws Exception
     */
     List<Enroll> selectSupplierEnrollsInfoBySid(Long sid,Byte checkCode) throws Exception;

    Enroll getEnrollById(Long id) throws  Exception;

    Integer selectProjectCountToCheckByPid(Long pid) throws Exception;

    Integer selectSupplierEnrollsCountInfoBySid(Long sid, Byte checkCode) throws Exception;
}
