package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.TbUser;

import java.io.File;

/**
 * @author suchuner
 */
public interface IUserService {
     TbUser getUserById(Long id) throws Exception;

     void addUser(TbUser user) throws Exception;

    /**该方法用于登录,如果用户存在,返回一个登录口令,不存在,返回null
     * @param username
     * @param password
     * @return
     */
     String login(String username, String password);

     void doImportUserByExcel(File userInfo, String userInfoContentType) throws Exception;

    /**该方法用于通过登录口令来获取登录的用户
     * @param token
     * @return
     */
     TbUser getLoginUserByLoginToken(String token) throws Exception;


     void logout(String token) throws Exception;

    void updatePwd(TbUser loginUser, String oldPwd, String newPwd) throws Exception;
}
