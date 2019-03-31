package com.suchuner.bidding.dao.impl;

import com.suchuner.bidding.dao.ISupplierDao;
import com.suchuner.bidding.pojo.Supplier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author suchuner
 */
public class SupplierDao extends HibernateDaoSupport implements ISupplierDao {
    public void addSupplier(Supplier supplier) throws Exception {
        this.getHibernateTemplate().save(supplier);
    }

    public Supplier getSupplierById(Long id) throws Exception {
        return this.getHibernateTemplate().get(Supplier.class,id);
    }

    public Supplier getSupplierByCompanyNameAndCompanyEmail(String companyname, String companyemail)throws Exception {
        String hql="from Supplier where companyname = ? and companyemail =?";
        List<Supplier> list = (List<Supplier>) this.getHibernateTemplate().find(hql, companyname, companyemail);
        return list.size()>0?list.get(0):null;
    }

    public List<Supplier> selectSupplierByIsAliveAndIsNormal() throws Exception{
        String hql = "from Supplier where isalive = ? and isnormal = ?";
        List<Supplier> list = (List<Supplier>) this.getHibernateTemplate().find(hql, Supplier.ALIVE_NO, Supplier.NORMAL_YES);
        return list;
    }

    public Supplier login(String companyemail, String password) throws Exception {
        String hql="from Supplier where companyemail = ? and password = ?";
        List<Supplier> list = (List<Supplier>) this.getHibernateTemplate().find(hql, companyemail, password);
        return list.size()>0?list.get(0):null;
    }

    public Integer selectSupplierCountByIsAliveAndIsNormal() throws Exception {
        String hql = "select count(*) from Supplier where isalive = ? and isnormal = ?";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, Supplier.ALIVE_NO, Supplier.NORMAL_YES);
        return list.size()>0?Integer.valueOf(list.get(0).toString()):null;
    }

    public void updateSupplier(Supplier supplier) throws Exception{
        this.getHibernateTemplate().update(supplier);
    }
}
