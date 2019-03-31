package com.suchuner.bidding.dao;

import com.suchuner.bidding.pojo.TbUser;

/**
 * @author suchuner
 */
public interface IUserDao {
    TbUser getUserById(Long id) throws Exception;

    void addUser(TbUser user) throws Exception;

    TbUser login(String username, String md5Password);

    TbUser getUserByUserNameAndRealName(String userName, String realName);

    void update(TbUser user) throws Exception;
}
