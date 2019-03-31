package com.suchuner.bidding.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.pojo.Expert;
import com.suchuner.bidding.service.IExpertService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author suchuner
 */
public class ExpertAction extends ActionSupport {
    private IExpertService expertService;

    public void setExpertService(IExpertService expertService) {
        this.expertService = expertService;
    }
    private Expert expert;

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
    public void addExpert() throws Exception {
        expertService.addExpert(expert);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"添加评标人成功");
    }

    public String importExpertPage(){
        return "importExpertPage";
    }
    public String toMyInfoPage(){
        return "toMyInfoPage";
    }
    private File expertInfo;
    private String expertInfoFileName;
    private String expertInfoContentType;

    public File getExpertInfo() {
        return expertInfo;
    }

    public void setExpertInfo(File expertInfo) {
        this.expertInfo = expertInfo;
    }

    public String getExpertInfoFileName() {
        return expertInfoFileName;
    }

    public void setExpertInfoFileName(String expertInfoFileName) {
        this.expertInfoFileName = expertInfoFileName;
    }

    public String getExpertInfoContentType() {
        return expertInfoContentType;
    }

    public void setExpertInfoContentType(String expertInfoContentType) {
        this.expertInfoContentType = expertInfoContentType;
    }

    public void doImportExpertByExcel() throws Exception{
        if ((!expertInfoContentType.equals("application/vnd.ms-excel")) && (!expertInfoContentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"上传的文件格式不正确!只能上传excel文件");
            return;
        }
        expertService.doImportExpertByExcel(expertInfo,expertInfoContentType);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"数据导入成功");
    }
    public void getLastInsertId() throws Exception {
        Integer lastInsertId = expertService.getLastInsertId();
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"最后插入的主键id为:"+lastInsertId);
    }
    public String loginPage(){
        return "toLoginPage";
    }
    private Long account;
    private String password;

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() throws Exception {
        String loginToken=expertService.login(account,password);
        if (loginToken == null) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"账号无效或者账号或密码错误!");
            return;
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        CookieUtils.setCookie(request,response,"BIDDING_SYSTEM_EXPERT",loginToken,true);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"登录成功!");
    }
    public void getLoginExpertByToken() throws Exception {
        String token = CookieUtils.getCookieValue(ServletActionContext.getRequest(), "BIDDING_SYSTEM_EXPERT", true);
        Expert expert = expertService.getLoginExpertByLoginToken(token);
        if (expert == null) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"你还未登陆或者登录已过期!");
        }else{
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,expert);
        }
    }
    public void logout() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_EXPERT", true);
        if(loginToken==null||loginToken.trim().equals("")){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"你还未登录!");
        }
        expertService.logout(loginToken);
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String callback;

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public void tellHerIsSelected() throws Exception {
        try {
            expertService.tellHerIsSelected(id);
            if (callback != null && !callback.trim().equals("")) {
                CommonUtils.returnJsonPMessages(ServletActionContext.getResponse(),callback,true,"发送成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (callback != null && !callback.trim().equals("")) {
                CommonUtils.returnJsonPMessages(ServletActionContext.getResponse(),callback,false,"发送失败,请稍后重试!");
            }
        }
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
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_EXPERT", true);
        Expert loginExpert = expertService.getLoginExpertByLoginToken(loginToken);
        try {
            expertService.updatePwd(loginExpert,oldPwd,newPwd);
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"密码修改成功!");
            expertService.logout(loginToken);
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,e.getMessage());
        }
    }
}
