package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.Expert;

import java.io.File;

/**
 * @author suchuner
 */
public interface IExpertService {
     void addExpert(Expert expert) throws Exception;

     void doImportExpertByExcel(File expertInfo, String expertInfoContentType) throws Exception;

     /**该方法用于取出评标人数据库表中的最后一个评标人的id,用于随机抽取评标人
      * @return
      * @throws Exception
      */
     Integer getLastInsertId() throws Exception;

     Expert getExpertById(Long id) throws  Exception;

     String login(Long account, String password) throws Exception;

     Expert getLoginExpertByLoginToken(String token) throws  Exception;

     void logout(String loginToken)throws Exception;

    void tellHerIsSelected(Long id) throws Exception;

    void updatePwd(Expert loginExpert, String oldPwd, String newPwd) throws Exception;
}
