package com.suchuner.bidding.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.common.utils.DirFileMakeUtil;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.pojo.TbUser;
import com.suchuner.bidding.service.ISupplierService;
import com.suchuner.bidding.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author suchuner
 */
public class SupplierAction extends ActionSupport {
    private ISupplierService supplierService;

    public void setSupplierService(ISupplierService supplierService) {
        this.supplierService = supplierService;
    }

    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    private File bizLicDoc;
    private String bizLicDocFileName;
    private String bizLicDocContentType;

    public File getBizLicDoc() {
        return bizLicDoc;
    }

    public void setBizLicDoc(File bizLicDoc) {
        this.bizLicDoc = bizLicDoc;
    }

    public String getBizLicDocFileName() {
        return bizLicDocFileName;
    }

    public void setBizLicDocFileName(String bizLicDocFileName) {
        this.bizLicDocFileName = bizLicDocFileName;
    }

    public String getBizLicDocContentType() {
        return bizLicDocContentType;
    }

    public void setBizLicDocContentType(String bizLicDocContentType) {
        this.bizLicDocContentType = bizLicDocContentType;
    }

    private File taxRegDoc;
    private String taxRegDocFileName;
    private String taxRegDocContentType;

    public File getTaxRegDoc() {
        return taxRegDoc;
    }

    public void setTaxRegDoc(File taxRegDoc) {
        this.taxRegDoc = taxRegDoc;
    }

    public String getTaxRegDocFileName() {
        return taxRegDocFileName;
    }

    public void setTaxRegDocFileName(String taxRegDocFileName) {
        this.taxRegDocFileName = taxRegDocFileName;
    }

    public String getTaxRegDocContentType() {
        return taxRegDocContentType;
    }

    public void setTaxRegDocContentType(String taxRegDocContentType) {
        this.taxRegDocContentType = taxRegDocContentType;
    }

    private File orgCodeDoc;
    private String orgCodeDocFileName;
    private String orgCodeDocContentType;

    public File getOrgCodeDoc() {
        return orgCodeDoc;
    }

    public void setOrgCodeDoc(File orgCodeDoc) {
        this.orgCodeDoc = orgCodeDoc;
    }

    public String getOrgCodeDocFileName() {
        return orgCodeDocFileName;
    }

    public void setOrgCodeDocFileName(String orgCodeDocFileName) {
        this.orgCodeDocFileName = orgCodeDocFileName;
    }

    public String getOrgCodeDocContentType() {
        return orgCodeDocContentType;
    }

    public void setOrgCodeDocContentType(String orgCodeDocContentType) {
        this.orgCodeDocContentType = orgCodeDocContentType;
    }
    private String BASE_DIR;


    public void setBASE_DIR(String BASE_DIR) {
        this.BASE_DIR = BASE_DIR;
    }

   public String toMyInfoPage(){
        return "toMyInfoPage";
    }

    public void addSupplier() throws Exception {
        Date currDate = new Date();
        if(supplier.getBizlicenddate().before(currDate)){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"注册失败!营业执照已过期!");
            return;
        }
        if(supplier.getTaxregenddate().before(currDate)){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"注册失败!税务登记证已过期!");
            return;
        }
        if(supplier.getOrgcodeenddate().before(currDate)){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"注册失败!组织机构代码已过期!");
            return;
        }
        //设置各个文件有效日期必须大于当前日期一个星期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,7);
        Date time = calendar.getTime();
        if(supplier.getBizlicenddate().before(time)){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"注册失败!营业执照有效截止日期快过期了(距离过期小于一个星期)!");
            return;
        }
        if(supplier.getTaxregenddate().before(time)){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"注册失败!税务登记证有效截止日期快过期了(距离过期小于一个星期)!");
            return;
        }
        if(supplier.getOrgcodeenddate().before(time)){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"注册失败!组织机构代码有效截止日期快过期了(距离过期小于一个星期)!");
            return;
        }
        Supplier addSupplier = supplierService.getSupplierByCompanyNameAndCompanyEmail(supplier.getCompanyname(), supplier.getCompanyemail());
        if(addSupplier!=null&&addSupplier.getIsalive()==Supplier.ALIVE_NO){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"该供应商已提交注册信息,请不要重复提交!");
            return ;
        }
        if(addSupplier!=null&&addSupplier.getIsalive()==Supplier.ALIVE_YES){
           CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"该供应商已成功注册并通过审核,请不要重复注册!");
           return ;
       }
        try {
            File descFile ;
            descFile = DirFileMakeUtil.getUploadDirFile(BASE_DIR, this.supplier.getCompanyname(),DirFileMakeUtil.SORT_CODE_SUPPLIER,bizLicDocFileName);
            FileUtils.copyFile(bizLicDoc,descFile);
            this.supplier.setBizlicdoc(descFile.getPath());
            descFile = DirFileMakeUtil.getUploadDirFile(BASE_DIR, this.supplier.getCompanyname(),DirFileMakeUtil.SORT_CODE_SUPPLIER,taxRegDocFileName);
            FileUtils.copyFile(taxRegDoc,descFile);
            this.supplier.setTaxregdoc(descFile.getPath());
            descFile = DirFileMakeUtil.getUploadDirFile(BASE_DIR, this.supplier.getCompanyname(),DirFileMakeUtil.SORT_CODE_SUPPLIER,orgCodeDocFileName);
            FileUtils.copyFile(orgCodeDoc,descFile);
            this.supplier.setOrgcodedoc(descFile.getPath());
            supplierService.addSupplier(this.supplier);
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"提交成功,请等待审核结果!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"提交失败,请稍后再试!");
        }
    }

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void getSupplierById() throws Exception {
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,supplierService.getSupplierById(id));
    }
    public String loginPage(){
        return "toLoginPage";
    }

    public void login() throws Exception{
        String loginToken =supplierService.login(supplier.getCompanyemail(),supplier.getPassword());
        if (loginToken!=null&&!loginToken.trim().equals("")){
            Supplier loginSupplier = supplierService.getLoginSupplierByLoginToken(loginToken);
            if(loginSupplier.getIsalive()==Supplier.ALIVE_YES&&loginSupplier.getIsnormal()==Supplier.NORMAL_YES){
                HttpServletRequest request = ServletActionContext.getRequest();
                HttpServletResponse response = ServletActionContext.getResponse();
                CookieUtils.setCookie(request,response,"BIDDING_SYSTEM_SUPPLIER",loginToken,true);
                CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"供应商登录成功");
            }else if(loginSupplier.getIsalive()==Supplier.ALIVE_NO&&loginSupplier.getIsnormal()==Supplier.NORMAL_NO){
               CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"您的账户未通过审核,请重新在注册页面提交资料,等待审核!");
            }else if(loginSupplier.getIsalive()==Supplier.ALIVE_NO&&loginSupplier.getIsnormal()==Supplier.NORMAL_YES){
                CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"您的账户还未审核,请等待审核完成!");
            }else{
                CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"账号异常,联系管理员了解原因,解除封号!");
            }
        }else{
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"账户无效或账户名或密码错误!请核实后重试!");
        }
    }

    public void logout(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        supplierService.logout(loginToken);
    }
    public void getLoginUserByLoginToken() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        Supplier loginSupplier = supplierService.getLoginSupplierByLoginToken(loginToken);
        if (loginSupplier == null) {
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"用户登录信息已过期,请重新登录!");
        }else{
        CommonUtils.returnMessages(ServletActionContext.getResponse(),true,loginSupplier);
        }
    }
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    public String toDoSupplierCheck(){
        return "toDoSuplierCheckPage";
    }

    public void selectSupplierByIsAliveAndIsNormal() throws  Exception{
        List<Supplier> supplierList = supplierService.selectSupplierByIsAliveAndIsNormal();
        Integer count = supplierService.selectSupplierCountByIsAliveAndIsNormal();
        if(supplierList.isEmpty()){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),0,supplierList);
            return;
        }
        //将查询出来的数据集合设置到值栈当中,以便页面取用.
        //ActionContext.getContext().getValueStack().setValue("supplierList",supplierList);
        CommonUtils.returnMessages(ServletActionContext.getResponse(),count,supplierList);
    }
    public void doCheckSupplierToAlive() throws Exception {
        Supplier supplier = supplierService.getSupplierById(id);
        String token = CookieUtils.getCookieValue(ServletActionContext.getRequest(), "BIDDING_SYSTEM_USER", true);
        TbUser user = userService.getLoginUserByLoginToken(token);
        if(user==null){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"你还未登录!登录后才可以审核!");
            return;
        }
        try {
            //设置供应商的审核员,通过登录的用户获取该用户的id
            supplier.setCheckman(user.getId());
            //设置供应商被审核的审核日期
            supplier.setCheckdate(new Date());
            supplierService.doCheckSupplierToAlive(supplier);
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"审核成功_通过审核!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"审核失败!");
        }
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void doCheckSupplierToNotAlive() throws Exception {
        Supplier supplier = supplierService.getSupplierById(id);
        String token = CookieUtils.getCookieValue(ServletActionContext.getRequest(), "BIDDING_SYSTEM_USER", true);
        TbUser user = userService.getLoginUserByLoginToken(token);
        if(user==null){
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"你还未登录!登录后才可以审核!");
            return;
        }
        try {
            //设置供应商的审核员,通过登录的用户获取该用户的id
            supplier.setCheckman(user.getId());
            //设置供应商被审核的审核日期
            supplier.setCheckdate(new Date());
            supplierService.doCheckSupplierToNotAlive(supplier,message);
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"审核成功_未通过审核!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,"审核失败!"+e.getMessage());
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
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        Supplier loginSupplier = supplierService.getLoginSupplierByLoginToken(loginToken);
        try {
            supplierService.updatePwd(loginSupplier,oldPwd,newPwd);
            CommonUtils.returnMessages(ServletActionContext.getResponse(),true,"密码修改成功!");
            supplierService.logout(loginToken);
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(ServletActionContext.getResponse(),false,e.getMessage());
        }
    }
}
