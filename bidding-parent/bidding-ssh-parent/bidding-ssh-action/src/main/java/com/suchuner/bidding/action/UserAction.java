package com.suchuner.bidding.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.pojo.TbUser;
import com.suchuner.bidding.service.IUserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author suchuner
 */
public class UserAction extends ActionSupport {
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void getUserById() throws Exception {
        TbUser user = userService.getUserById(id);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,user);
    }

    private TbUser user;

    public TbUser getUser() {
        return user;
    }

    public void setUser(TbUser user) {
        this.user = user;
    }

    /**
     * 系统用户的注册功能
     *
     * @throws Exception
     */
    public void addUser() throws Exception {
        userService.addUser(user);
    }

    private String username;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String loginPage() {
        return "toLoginPage";
    }

    public void login() throws Exception {
        String loginToken = userService.login(username, password);
        if (loginToken == null) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"账号无效或者账号或密码错误!");
            return;
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        CookieUtils.setCookie(request, response, "BIDDING_SYSTEM_USER", loginToken, true);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"登录成功!");
    }

    public void getLoginUserByLoginToken() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser loginUser = userService.getLoginUserByLoginToken(loginToken);
        if (loginUser == null) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"用户登录信息已过期,请重新登录!");
        }else{
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,loginUser);
        }
    }

    public void logout() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        if (loginToken == null || loginToken.trim().equals("")) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"你还未登录!");
            return;
        }
        userService.logout(loginToken);
    }

    /**
     * 转入到添加用户的界面
     *
     * @return
     */
    public String importUserPage() {
        return "importUserPage";
    }

    private File userInfo;
    private String userInfoFileName;
    private String userInfoContentType;

    public File getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(File userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserInfoFileName() {
        return userInfoFileName;
    }

    public void setUserInfoFileName(String userInfoFileName) {
        this.userInfoFileName = userInfoFileName;
    }

    public String getUserInfoContentType() {
        return userInfoContentType;
    }

    public void setUserInfoContentType(String userInfoContentType) {
        this.userInfoContentType = userInfoContentType;
    }

    public void doImportUserByExcel() throws Exception {
        if ((!userInfoContentType.equals("application/vnd.ms-excel")) && (!userInfoContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"上传的文件格式不正确!只能上传excel文件");
            return;
        }
        userService.doImportUserByExcel(userInfo, userInfoContentType);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"数据导入成功");
    }
    private String oldPwd;
    private String newPwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public void updatePwd() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser loginUser = userService.getLoginUserByLoginToken(loginToken);
        try {
            userService.updatePwd(loginUser,oldPwd,newPwd);
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"密码修改成功!");
            userService.logout(loginToken);
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,e.getMessage());
        }
    }
}
