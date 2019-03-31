package com.suchuner.bidding.dao;

import com.suchuner.bidding.pojo.Expert;

/**
 * @author suchuner
 */
public interface IExpertDao {
     void addExpert(Expert expert) throws Exception;

     Expert getExpertByName(String name) throws Exception;

     Integer getLastInsertId() throws Exception;

     Expert getExpertById(Long id) throws  Exception;

    Expert login(Long account, String md5Password) throws Exception;

    void updateExpert(Expert expert);
}
