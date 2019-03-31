package com.suchuner.bidding.dao.impl;

import com.suchuner.bidding.dao.IExpertDao;
import com.suchuner.bidding.pojo.Expert;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author suchuner
 */
public class ExpertDao extends HibernateDaoSupport implements IExpertDao {
    public void addExpert(Expert expert) throws Exception{
        this.getHibernateTemplate().save(expert);
    }

    public Expert getExpertByName(String name) throws  Exception{
        String hql="from Expert where name=?";
        List<Expert> list = (List<Expert>) this.getHibernateTemplate().find(hql, name);
        return list.size()>0?list.get(0):null;
    }

    public Integer getLastInsertId() throws Exception {
        String sql = "SELECT id FROM expert ORDER BY id DESC LIMIT 1";
        SQLQuery sqlQuery = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
        List list = sqlQuery.list();
        return Integer.valueOf(list.get(0).toString());
    }

    public Expert getExpertById(Long id) throws Exception {
        return this.getHibernateTemplate().get(Expert.class,id);
    }

    public Expert login(Long account, String md5Password) throws  Exception{
        String hql="from Expert where account = ? and password = ?";
        List<Expert> list = (List<Expert>) this.getHibernateTemplate().find(hql, account+"", md5Password);
        return list.size()>0?list.get(0):null;
    }

    public void updateExpert(Expert expert) {
        this.getHibernateTemplate().update(expert);
    }
}
