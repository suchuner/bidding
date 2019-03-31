package com.suchuner.bidding.dao.impl;

import com.suchuner.bidding.dao.IUserDao;
import com.suchuner.bidding.pojo.TbUser;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author suchuner
 */
public class UserDao extends HibernateDaoSupport implements IUserDao {
    public TbUser getUserById(Long id) throws Exception {
        return this.getHibernateTemplate().get(TbUser.class,id);
    }

    public void addUser(TbUser user) throws Exception {
        this.getHibernateTemplate().save(user);
    }

    public TbUser login(String username, String md5Password) {
        String hql = "from TbUser where username = ? and password = ?";
        List<TbUser> list = (List<TbUser>) this.getHibernateTemplate().find(hql, username, md5Password);
        return list.size()>0?list.get(0):null;
    }

    public TbUser getUserByUserNameAndRealName(String userName, String realName) {
        String hql = "from TbUser where username = ? and name = ?";
        List<TbUser> list = (List<TbUser>) this.getHibernateTemplate().find(hql, userName, realName);
        return list.size()>0?list.get(0):null;
    }

    public void update(TbUser user) throws Exception{
        this.getHibernateTemplate().update(user);
    }
}
