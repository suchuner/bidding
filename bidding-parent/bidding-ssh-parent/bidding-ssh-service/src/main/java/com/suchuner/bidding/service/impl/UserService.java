package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utils.JsonUtils;
import com.suchuner.bidding.dao.IUserDao;
import com.suchuner.bidding.pojo.TbUser;
import com.suchuner.bidding.service.IUserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * @author suchuner
 */
public class UserService implements IUserService {
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public TbUser getUserById(Long id) throws Exception {
        TbUser user = userDao.getUserById(id);
        if(user==null){
            throw  new BiddingException("该用户不存在!");
        }
        return user;
    }

    public void addUser(TbUser user) throws Exception{
        //将密码进行md5加密
       user.setPassword( DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userDao.addUser(user);
    }

    private Jedis jedis;

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    private Integer BIDDING_SYSTEM_USER_EXPIRE;

    public void setBIDDING_SYSTEM_USER_EXPIRE(Integer BIDDING_SYSTEM_USER_EXPIRE) {
        this.BIDDING_SYSTEM_USER_EXPIRE = BIDDING_SYSTEM_USER_EXPIRE;
    }

    /**根据用户和密码登录
     * @param username
     * @param password
     * @return
     */
    public String login(String username, String password) {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        TbUser loginUser = userDao.login(username, md5Password);
        String loginToken =null;
        if(loginUser!=null) {
            try {
                loginToken = UUID.randomUUID().toString();
                jedis.set("BIDDING_SYSTEM_USER:USER:" +loginToken, JsonUtils.objectToJson(loginUser));
                jedis.expire("BIDDING_SYSTEM_USER:USER:"+ loginToken,BIDDING_SYSTEM_USER_EXPIRE);
            } catch (Exception e) {
                e.printStackTrace();
                throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
            }
        }
        return loginToken;
    }

    /**导入用户信息,如果用户在数据库中存在,则更新该用户信息,不存在,则添加用户信息
     * @param userInfo
     * @param userInfoContentType
     * @throws Exception
     */
    public void doImportUserByExcel(File userInfo, String userInfoContentType) throws Exception {
        Workbook sheets = null;
        Sheet sheet = null;
        if(userInfoContentType.equals("application/vnd.ms-excel")){
             sheets = new HSSFWorkbook(new FileInputStream(userInfo));
             sheet = sheets.getSheetAt(0);
        }
        if(userInfoContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            sheets = new XSSFWorkbook(new FileInputStream(userInfo));
            sheet = sheets.getSheetAt(0);
        }
        int lastRowNum = sheet.getLastRowNum();
        TbUser user = null;
        for (int i = 1;i<=lastRowNum;i++){
            String userName = sheet.getRow(i).getCell(0).getStringCellValue();
            String realName = sheet.getRow(i).getCell(1).getStringCellValue();
            user = userDao.getUserByUserNameAndRealName(userName, realName);
            if(user==null){
                user=new TbUser();
            }
            user.setUsername(userName);
            //使用用户名作为默认的登录密码
            String genPassword = DigestUtils.md5DigestAsHex(userName.getBytes());
            user.setPassword(genPassword);
            user.setName(realName);
            user.setGender(sheet.getRow(i).getCell(2).getStringCellValue().trim().equals("男")? 1 : 0);
            sheet.getRow(i).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            user.setEmail(sheet.getRow(i).getCell(3).getStringCellValue());
            sheet.getRow(i).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            user.setTele(sheet.getRow(i).getCell(4).getStringCellValue());
            user.setAddress(sheet.getRow(i).getCell(5).getStringCellValue());
            user.setIsnormal(TbUser.ISNORMAL_YES);
            if(user.getId()==null){
                userDao.addUser(user);
            }
        }
    }

    public TbUser getLoginUserByLoginToken(String token) throws Exception{
        String jsonUser = jedis.get("BIDDING_SYSTEM_USER:USER:" + token);
        if(jsonUser==null||jsonUser.trim().equals("")){
            return null;
        }
        //重新设置登录过期时间
        try {
            jedis.expire("BIDDING_SYSTEM_USER:USER:"+ token,BIDDING_SYSTEM_USER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
        }
        return JsonUtils.jsonToPojo(jsonUser, TbUser.class);
    }

    public void logout(String token) throws Exception{
        try {
            jedis.expire("BIDDING_SYSTEM_USER:USER:"+ token,0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BiddingException("Redis缓存服务器未开启,请开启Redis服务器!");
        }
    }

    public void updatePwd(TbUser loginUser, String oldPwd, String newPwd) throws Exception {
        if(!DigestUtils.md5DigestAsHex(oldPwd.getBytes()).equals(loginUser.getPassword())){
            throw new BiddingException("原密码错误!");
        }else{
            loginUser.setPassword(DigestUtils.md5DigestAsHex(newPwd.getBytes()));
            userDao.update(loginUser);
        }
    }

}
