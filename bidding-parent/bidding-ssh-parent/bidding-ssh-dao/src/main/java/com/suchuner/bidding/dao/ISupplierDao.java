package com.suchuner.bidding.dao;

import com.suchuner.bidding.pojo.Supplier;

import java.util.List;

/**
 * @author suchuner
 */
public interface ISupplierDao {
     void addSupplier(Supplier supplier) throws Exception;

     Supplier getSupplierById(Long id) throws Exception;

    /**该方法通过供应商的公司名称和公司邮箱判断该供应商是否存在
     * @param companyname
     * @param companyemail
     * @return 存在则返回该对象,不存在则返回null
     */
    Supplier getSupplierByCompanyNameAndCompanyEmail(String companyname, String companyemail) throws Exception;

    List<Supplier> selectSupplierByIsAliveAndIsNormal() throws Exception;

    Supplier login(String companyemail, String password) throws Exception;

    Integer selectSupplierCountByIsAliveAndIsNormal()throws Exception;

    void updateSupplier(Supplier supplier) throws Exception;
}
