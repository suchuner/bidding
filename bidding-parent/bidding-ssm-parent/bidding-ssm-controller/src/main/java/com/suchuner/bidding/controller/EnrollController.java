package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.common.utils.DirFileMakeUtil;
import com.suchuner.bidding.pojo.Enroll;
import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.pojo.TbUser;
import com.suchuner.bidding.service.IEnrollService;
import com.suchuner.bidding.service.IProjectService;
import com.suchuner.bidding.service.ISupplierService;
import com.suchuner.bidding.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author suchuner
 */
@Controller
public class EnrollController {
    @Autowired
    private IEnrollService enrollService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private ISupplierService supplierService;

    @Value("${baseDir}")
    private String baseDir;

    @RequestMapping("/enroll/toCheckEnrollPage/{code}")
    public String toCheckEnrollPage(@PathVariable Byte code) throws Exception {
        switch(code){
            case 0 :return "enroll/enrollNoCheck";
            case 1 :return "enroll/myCheckOutEnroll";
            case 2 :return "enroll/myCheckInEnroll";
            default:return "exception/exception";
        }
    }

    @RequestMapping(value = "/enroll/addEnroll",method = RequestMethod.POST)
    public void addEnroll(Enroll enroll, MultipartFile legaldoc_, MultipartFile taxdoc_, MultipartFile sidoc_, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        Supplier supplier = supplierService.getLoginSupplierByLoginToken(token);
        if(supplier==null){
            CommonUtils.returnMessages(response,false,"你还未登录!");
            return ;
        }
        Project project = projectService.getProjectByPid(enroll.getPjtId());
        if(project.getStatus()!=Project.STATUS_TENDER_START){
            CommonUtils.returnMessages(response,false,"该招标项目状态异常,无法继续操作!");
            return;
        }
        if(project.getDeadline().before(new Date())){
            CommonUtils.returnMessages(response,false,"该招标项目已停止投标报名!");
            return;
        }
        List<Enroll> enrolls=enrollService.getEnrollsByPidAndSid(enroll.getPjtId(),supplier.getId());
        if(!enrolls.isEmpty()) {
            Enroll existEnroll = enrolls.get(0);
            Byte isnormal = existEnroll.getIsnormal();
            if ( Enroll.IS_NORMAL_FRIST == isnormal) {
                CommonUtils.returnMessages(response,false,"该项目你已经报名成功,请等待报名审核结果!");
                return;
            }
            if (Enroll.IS_NORMAL_YES == isnormal) {
                CommonUtils.returnMessages(response,false,"该项目你已经报名成功,并已通过审核,请勿重新提交报名!");
                return;
            }
            if ( Enroll.IS_NORMAL_NO == isnormal) {
                enrollService.deleteEnroll(existEnroll);
            }
        }
        enroll.setSupId(supplier.getId());
        if(!legaldoc_.getContentType().equals("application/pdf")){
            CommonUtils.returnMessages(response,false,"无违法记录证明文件上传文件格式错误(请上传图片  *.pdf)!");
            return;
        }
        if(!taxdoc_.getContentType().equals("application/pdf")){
            CommonUtils.returnMessages(response,false,"纳税证明文件上传文件格式错误(请上传图片  *.pdf)!");
            return;
        }
        if(!sidoc_.getContentType().equals("application/pdf")){
            CommonUtils.returnMessages(response,false,"员工社保缴纳证明文件上传文件格式错误(请上传图片  *.pdf)!");
            return;
        }
        File descFile =null;
        descFile = DirFileMakeUtil.getUploadDirFile(baseDir, supplier.getCompanyname(), DirFileMakeUtil.SORT_CODE_PROJECT_ENROLL, legaldoc_.getOriginalFilename());
        legaldoc_.transferTo(descFile);
        enroll.setLegaldoc(descFile.getPath());
        descFile = DirFileMakeUtil.getUploadDirFile(baseDir,supplier.getCompanyname(),DirFileMakeUtil.SORT_CODE_PROJECT_ENROLL,taxdoc_.getOriginalFilename());
        taxdoc_.transferTo(descFile);
        enroll.setTaxdoc(descFile.getPath());
        descFile=DirFileMakeUtil.getUploadDirFile(baseDir,supplier.getCompanyname(),DirFileMakeUtil.SORT_CODE_PROJECT_ENROLL,sidoc_.getOriginalFilename());
        sidoc_.transferTo(descFile);
        enroll.setSidoc(descFile.getPath());
        enroll.setIsnormal(Enroll.IS_NORMAL_FRIST);
        try {
            enrollService.addEnroll(enroll);
            CommonUtils.returnMessages(response,true,"招标项目报名申请成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,false,"招标项目报名申请失败,请稍后重试!");
        }
    }
    @RequestMapping("/enroll/selectProjectToCheckByPid/{pid}")
    public void selectProjectToCheckByPid(@PathVariable Long pid,HttpServletResponse response) throws Exception {
        List<Enroll> enrolls = enrollService.selectProjectToCheckByPid(pid);
        Integer total  =enrollService.selectProjectCountToCheckByPid(pid);
        CommonUtils.returnMessages(response,total,enrolls);
    }
    @Autowired
    private IUserService userService;

    @RequestMapping("/enroll/doCheckProjectEnrollByPidAndSidToSuccess")
    public void doCheckProjectEnrollByPidAndSidToSuccess(Long pid,Long sid,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser loginUser = userService.getLoginUserByLoginToken(token);
        if(loginUser==null){
            CommonUtils.returnMessages(response,false,"你还未登录!");
            return;
        }
        List<Enroll> enrolls = enrollService.getEnrollsByPidAndSid(pid, sid);
        if(enrolls.isEmpty()){
            CommonUtils.returnMessages(response,false,"未知参数,未知错误!");
            return;
        }
        Enroll enroll = enrolls.get(0);
        enroll.setCrediterId(loginUser.getId());
        enroll.setCheckdate(new Date());
        enroll.setPjtId(pid);
        enroll.setSupId(sid);
        try {
            enrollService.doCheckProjectEnrollToSuccess(enroll);
            CommonUtils.returnMessages(response,true,"审核成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,true,"审核失败!");
        }
    }
    @RequestMapping("/enroll/doCheckProjectEnrollByPidAndSidToFailure")
    public void doCheckProjectEnrollByPidAndSidToFailure(Long pid,Long sid,String message,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser loginUser = userService.getLoginUserByLoginToken(token);
        if(loginUser==null){
            CommonUtils.returnMessages(response,false,"你还未登录!");
            return;
        }
        List<Enroll> enrolls = enrollService.getEnrollsByPidAndSid(pid, sid);
        if(enrolls.isEmpty()){
            CommonUtils.returnMessages(response,true,"未知参数,未知错误!");
            return;
        }
        Enroll enroll = enrolls.get(0);
        enroll.setCrediterId(loginUser.getId());
        enroll.setCheckdate(new Date());
        enroll.setPjtId(pid);
        enroll.setSupId(sid);
        try {
            enrollService.doCheckProjectEnrollToFailure(enroll,message);
            CommonUtils.returnMessages(response,true,"审核成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,false,"审核失败!");
        }
    }
    @RequestMapping("/enroll/selectSupplierEnrollsInfoByLoginSupplier/{checkCode}")
    public void selectSupplierEnrollsInfoByLoginSupplier(@PathVariable Byte checkCode, HttpServletRequest request,HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        Supplier supplier = supplierService.getLoginSupplierByLoginToken(token);
        if(supplier==null){
            throw new BiddingException("你还未登录!");
        }
        List<Enroll> enrolls = enrollService.selectSupplierEnrollsInfoBySid(supplier.getId(),checkCode);
        Integer total = enrollService.selectSupplierEnrollsCountInfoBySid(supplier.getId(),checkCode);
        CommonUtils.returnMessages(response,total,enrolls);
    }
}
