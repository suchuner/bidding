package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utils.JsonUtils;
import com.suchuner.bidding.dao.ISupplierDao;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.service.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author suchuner
 */
public class SupplierService implements ISupplierService {
    private ISupplierDao supplierDao;

    public void setSupplierDao(ISupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    private Jedis jedis;

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public void addSupplier(Supplier supplier) throws Exception {
        //取公司的电话进行md5转换,然后取生成的字符串的前12位转换为大写作为生成的供应商密码
        String genPassword = DigestUtils.md5DigestAsHex(supplier.getCallnum().getBytes()).substring(0, 12).toUpperCase();
        String password = DigestUtils.md5DigestAsHex(genPassword.getBytes());
        supplier.setPassword(password);
        //设置供应商账户未激活
        supplier.setIsalive(Supplier.ALIVE_NO);
        //设置账户正常
        supplier.setIsnormal(Supplier.NORMAL_YES);
        //以下内容为供应商如果审核未通过,再次申请注册时,更新供应商提交的数据(使用hibernate快照更新),通过供应商的公司名称和公司邮件来判断该供应商是否存在
       Supplier isExistSupplier = supplierDao.getSupplierByCompanyNameAndCompanyEmail(supplier.getCompanyname(),supplier.getCompanyemail());
       if(isExistSupplier!=null){
           supplier.setId(isExistSupplier.getId());
           BeanUtils.copyProperties(supplier,isExistSupplier,Supplier.class);
           return ;
       }
        supplierDao.addSupplier(supplier);
    }

    public Supplier getSupplierById(Long id) throws Exception {
        Supplier supplier = supplierDao.getSupplierById(id);
        if(supplier==null){
            throw new BiddingException("非法参数异常,该供应商不存在!");
        }
        return supplier;
    }

    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    private String emailAccount;

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public void doCheckSupplierToAlive(Supplier supplier) throws Exception {
        try {
            SimpleMailMessage ssm = new SimpleMailMessage();
            ssm.setFrom(emailAccount);
            ssm.setSubject("恭喜你注册成功");
            StringBuffer buffer = new StringBuffer("贵公司在本招标网站的登录账号为:");
            buffer.append(supplier.getCompanyemail());
            String genPassword = DigestUtils.md5DigestAsHex(supplier.getCallnum().getBytes()).substring(0, 12).toUpperCase();
            buffer.append(",初始登录密码为:");
            buffer.append(genPassword);
            buffer.append(".感谢您的注册,xxx招标系统");
            ssm.setText(buffer.toString());
            ssm.setSentDate(new Date());
            ssm.setTo(supplier.getCompanyemail());
            mailSender.send(ssm);
        } catch (MailException e) {
            e.printStackTrace();
            throw new BiddingException("邮件发送失败,请检查网络状态是否正常,该审核失败,网络正常后请重新审核.");
        }
        //设置账户注册成功
        supplier.setIsalive(Supplier.ALIVE_YES);
        //设置账户正常
        supplier.setIsnormal(Supplier.NORMAL_YES);
    }

    public void doCheckSupplierToNotAlive(Supplier supplier, String message) throws Exception {
        try {
            SimpleMailMessage ssm = new SimpleMailMessage();
            ssm.setFrom(emailAccount);
            ssm.setSubject("很遗憾,注册失败");
            StringBuffer buffer = new StringBuffer("贵公司在本网站中提交的资料审核不通过,原因为:");
            buffer.append(message);
            buffer.append(";如果贵公司需要继续申请,请在注册页面重新填写数据并等待审核结果, xxx招标系统");
            ssm.setText(buffer.toString());
            ssm.setSentDate(new Date());
            ssm.setTo(supplier.getCompanyemail());
            mailSender.send(ssm);
        } catch (MailException e) {
            e.printStackTrace();
            throw new BiddingException("邮件发送失败,请检查网络状态是否正常,该审核失败,网络正常后请重新审核.");
        }
        //设置账户注册失败
        supplier.setIsalive(Supplier.ALIVE_NO);
        //设置账户不正常
        supplier.setIsnormal(Supplier.NORMAL_NO);
    }

    public List<Supplier> selectSupplierByIsAliveAndIsNormal() throws Exception{
        List<Supplier> list = supplierDao.selectSupplierByIsAliveAndIsNormal();
        return list;
    }

    public Integer selectSupplierCountByIsAliveAndIsNormal() throws Exception {
        Integer count  =supplierDao.selectSupplierCountByIsAliveAndIsNormal();
        return count;
    }

    private Integer BIDDING_SYSTEM_USER_EXPIRE;

    public void setBIDDING_SYSTEM_USER_EXPIRE(Integer BIDDING_SYSTEM_USER_EXPIRE) {
        this.BIDDING_SYSTEM_USER_EXPIRE = BIDDING_SYSTEM_USER_EXPIRE;
    }

    public String login(String companyemail, String password) throws Exception {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        Supplier loginSupplier = supplierDao.login(companyemail, md5Password);
        String loginToken = null;
        if(loginSupplier!=null){
            try {
                loginToken=UUID.randomUUID().toString();
                jedis.set("BIDDING_SYSTEM_USER:SUPPLIER:"+loginToken, JsonUtils.objectToJson(loginSupplier));
                jedis.expire("BIDDING_SYSTEM_USER:SUPPLIER:"+loginToken,BIDDING_SYSTEM_USER_EXPIRE);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
            }
        }
        return loginToken ;
    }
    public Supplier getLoginSupplierByLoginToken(String token) throws Exception{
        String jsonSupplier=null;
        try {
            jsonSupplier = jedis.get("BIDDING_SYSTEM_USER:SUPPLIER:" + token);
            if(jsonSupplier==null||jsonSupplier.trim().equals("")){
                return null;
            }
            //重新设置登录过期时间
            jedis.expire("BIDDING_SYSTEM_USER:SUPPLIER:"+ token,BIDDING_SYSTEM_USER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
        }
        Supplier loginSupplier = JsonUtils.jsonToPojo(jsonSupplier, Supplier.class);
        return loginSupplier;
    }

    public void logout(String token) {
        try {
            jedis.expire("BIDDING_SYSTEM_USER:SUPPLIER:"+token,0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
        }
    }

    public Supplier getSupplierByCompanyNameAndCompanyEmail(String companyname, String companyemail) throws Exception {
        return supplierDao.getSupplierByCompanyNameAndCompanyEmail(companyname, companyemail);
    }

    public void updatePwd(Supplier loginSupplier, String oldPwd, String newPwd) throws Exception {
        if(!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(loginSupplier.getPassword())){
            throw new BiddingException("原密码错误!");
        }else{
            loginSupplier.setPassword(DigestUtils.md5DigestAsHex(newPwd.getBytes()));
            supplierDao.updateSupplier(loginSupplier);
        }
    }
}
