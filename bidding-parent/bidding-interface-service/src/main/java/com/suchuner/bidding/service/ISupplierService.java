package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.Supplier;

import java.util.List;

/**
 * @author suchuner
 */
public interface ISupplierService {
     void addSupplier(Supplier supplier) throws Exception;

     Supplier getSupplierById(Long id) throws Exception;

    /**该方法用于做供应商注册审核通过,并通过邮件发送供应商的登录账号和密码给供应商的联系人的邮件
     * @param supplier
     */
     void doCheckSupplierToAlive(Supplier supplier) throws Exception;

    /**该方法用于做供应商注册审核不通过,并给供应商返回失败原因
     * @param supplier
     * @param message
     */
     void doCheckSupplierToNotAlive(Supplier supplier, String message) throws Exception;

    /**该方法用于获取所有未被审核的供应商(未注册成功,但账户正常)
     * @return 包含所有未被审核的供应商的集合
     */
     List<Supplier> selectSupplierByIsAliveAndIsNormal() throws Exception;
    Integer  selectSupplierCountByIsAliveAndIsNormal() throws Exception;

    /**该方法用于供应的登录,账户和密码为供应商的公司邮件号,和密码
     * @param companyemail
     * @param password
     * @return
     * @throws Exception
     */
     String login(String companyemail, String password) throws Exception;

     Supplier getLoginSupplierByLoginToken(String token) throws Exception;

     void logout(String token);

    /**根据供应商的公司邮箱和公司名称获取该供应商
     * @param companyemail
     * @param companyname
     * @return
     */
     Supplier getSupplierByCompanyNameAndCompanyEmail(String companyname,String companyemail ) throws Exception;

    void updatePwd(Supplier loginSupplier, String oldPwd, String newPwd) throws Exception;
}
