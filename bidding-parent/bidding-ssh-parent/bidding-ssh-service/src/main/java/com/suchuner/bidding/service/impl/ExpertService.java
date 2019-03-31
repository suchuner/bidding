package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utils.JsonUtils;
import com.suchuner.bidding.dao.IExpertDao;
import com.suchuner.bidding.pojo.Expert;
import com.suchuner.bidding.service.IExpertService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @author suchuner
 */
public class ExpertService implements IExpertService {
    private IExpertDao expertDao;

    public void setExpertDao(IExpertDao expertDao) {
        this.expertDao = expertDao;
    }

    public void addExpert(Expert expert) throws Exception {
         expertDao.addExpert(expert);
    }

    public void doImportExpertByExcel(File expertInfo, String expertInfoContentType) throws Exception{
        Workbook sheets = null;
        Sheet sheet = null;
        if(expertInfoContentType.equals("application/vnd.ms-excel")){
            sheets = new HSSFWorkbook(new FileInputStream(expertInfo));
            sheet = sheets.getSheetAt(0);
        }
        if(expertInfoContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            sheets = new XSSFWorkbook(new FileInputStream(expertInfo));
            sheet = sheets.getSheetAt(0);
        }
        int lastRowNum = sheet.getLastRowNum();
        Expert expert = null;
        for (int i =1;i<=lastRowNum;i++){
            String name = sheet.getRow(i).getCell(0).getStringCellValue();
            expert=expertDao.getExpertByName(name);
            if(expert==null){
                expert =new Expert();
            }
            expert.setName(name);
            expert.setGender(sheet.getRow(i).getCell(1).getStringCellValue().trim().equals("男")?1:0);
            sheet.getRow(i).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            expert.setAge(Long.valueOf(sheet.getRow(i).getCell(2).getStringCellValue()));
            sheet.getRow(i).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            expert.setPhone(sheet.getRow(i).getCell(3).getStringCellValue());
            String education = sheet.getRow(i).getCell(4).getStringCellValue();
            if(education.trim().equals("专科")){
                expert.setEducation(0);
            }
            if(education.trim().equals("本科")){
                expert.setEducation(1);
            }
            if(education.trim().equals("硕士")){
                expert.setEducation(2);
            }
            if(education.trim().equals("博士")){
                expert.setEducation(3);
            }
            sheet.getRow(i).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            expert.setEmail(sheet.getRow(i).getCell(5).getStringCellValue());
            expert.setAddress(sheet.getRow(i).getCell(6).getStringCellValue());
            //使用评标人的手机号作为登录的账号
            expert.setAccount(expert.getPhone());
            //使用评标人的手机号加密作为登录的密码
            String genPassword = DigestUtils.md5DigestAsHex(expert.getPhone().getBytes());
            expert.setPassword(genPassword);
            //使用评标人的账号和密码拼接作为身份识别码
            String genAccount = DigestUtils.md5DigestAsHex(expert.getAccount().getBytes());
            expert.setCode(genAccount+genPassword);
            expert.setIsnormal(Expert.ISNOEMAL_YES);
            if(expert.getId()==null){
                expertDao.addExpert(expert);
            }
        }
    }

    public Integer getLastInsertId() throws Exception {
        return expertDao.getLastInsertId();
    }

    public Expert getExpertById(Long id) throws Exception {
        Expert expert = expertDao.getExpertById(id);
        if(expert==null){
            throw new BiddingException("非法参数异常,该评标人不存在!");
        }
        return expert;
    }
    private Integer BIDDING_SYSTEM_USER_EXPIRE;

    public void setBIDDING_SYSTEM_USER_EXPIRE(Integer BIDDING_SYSTEM_USER_EXPIRE) {
        this.BIDDING_SYSTEM_USER_EXPIRE = BIDDING_SYSTEM_USER_EXPIRE;
    }
    private Jedis jedis;

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public String login(Long account, String password) throws Exception {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        Expert expert = expertDao.login(account,md5Password);
        String loginToken = null;
        if(expert!=null){
            try {
                loginToken = UUID.randomUUID().toString();
                jedis.set("BIDDING_SYSTEM_USER:EXPERT:" +loginToken, JsonUtils.objectToJson(expert));
                jedis.expire("BIDDING_SYSTEM_USER:EXPERT:"+ loginToken,BIDDING_SYSTEM_USER_EXPIRE);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
            }
        }
        return loginToken;
    }

    public Expert getLoginExpertByLoginToken(String token) throws Exception {
        String jsonExpert = jedis.get("BIDDING_SYSTEM_USER:EXPERT:" + token);
        if(jsonExpert==null||jsonExpert.trim().equals("")){
            return null;
        }
        //重新设置登录过期时间
        try {
            jedis.expire("BIDDING_SYSTEM_USER:EXPERT:"+ token,BIDDING_SYSTEM_USER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
        }
        return JsonUtils.jsonToPojo(jsonExpert, Expert.class);
    }

    public void logout(String token) {
        try {
            jedis.expire("BIDDING_SYSTEM_USER:EXPERT:"+ token,0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
        }
    }
    private MailSender mailSender;
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    private String emailAccount;

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public void tellHerIsSelected(Long id) throws Exception {
        Expert expert = getExpertById(id);
        try {
            SimpleMailMessage ssm = new SimpleMailMessage();
            ssm.setFrom(emailAccount);
            ssm.setSubject("项目评标");
            StringBuffer buffer = new StringBuffer("尊敬的");
            buffer.append(expert.getName());
            if(expert.getGender()==0) buffer.append("(女士);");
            else buffer.append("(先生);");
            buffer.append("你被我招标系统选中作为项目的评标人,请登录系统查看项目信息,谢谢. xxx招标系统");
            ssm.setText(buffer.toString());
            ssm.setSentDate(new Date());
            ssm.setTo(expert.getEmail());
            mailSender.send(ssm);
        } catch (MailException e) {
            e.printStackTrace();
            throw new BiddingException("邮件发送失败,请检查网络状态是否正常,该审核失败,网络正常后请重新审核.");
        }
    }

    public void updatePwd(Expert loginExpert, String oldPwd, String newPwd) throws Exception {
        if(!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(loginExpert.getPassword())){
            throw new BiddingException("原密码错误!");
        }else{
            loginExpert.setPassword(DigestUtils.md5DigestAsHex(newPwd.getBytes()));
            expertDao.updateExpert(loginExpert);
        }
    }
}
