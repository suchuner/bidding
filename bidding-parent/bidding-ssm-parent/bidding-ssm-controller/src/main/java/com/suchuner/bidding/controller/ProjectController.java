package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.common.utils.DirFileMakeUtil;
import com.suchuner.bidding.pojo.Expert;
import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.TbUser;
import com.suchuner.bidding.service.IProjectService;
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
import java.util.*;

/**
 * @author suchuner
 */
@Controller
public class ProjectController {
    @Value("${baseDir}")
    private String baseDir;
    @Autowired
    private IProjectService projectService;

    @RequestMapping("/project/toProjectPage/{pageCode}")
    public String toProjectPage(@PathVariable Integer pageCode){
        switch (pageCode){
            case 0 :return "project/projectApplication";
            case 1 :return "project/projectNoCheck";
            case 2 :return "project/selectProjectNoCheck";
            case 3 :return "project/projectToBegin";
            case 4 :return "project/selectProjectIsTendering";
            case 5 :return "project/projectToBidding";
            case 6 :return "project/chooseJudgeManForProject";
            default:return "exception/exception";
        }
    }
    @RequestMapping(value = "/project/addProject", method = RequestMethod.POST)
    public void addProject(Project project, MultipartFile biddingdoc_, MultipartFile buylistandreqdoc_, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!biddingdoc_.getContentType().equals("application/pdf")) {
            CommonUtils.returnMessages(response,false,"上传的文件格式不正确,请上传pdf格式的文件!");
            return;
        }
        String filename = biddingdoc_.getOriginalFilename();
        File destFile = DirFileMakeUtil.getUploadDirFile(baseDir,project.getItemname(),DirFileMakeUtil.SORT_CODE_PROJECT,filename);
        biddingdoc_.transferTo(destFile);
        project.setBiddingdoc(destFile.getPath());
        //为满足如果招标书中存在采购需求和技术要求,则不需要上传,即不上传就不处理,上传了才处理
        if (buylistandreqdoc_!=null) {
            if (!buylistandreqdoc_.getContentType().equals("application/pdf")) {
                CommonUtils.returnMessages(response,false,"上传的文件格式不正确,请上传pdf格式的文件!");
                return;
            }
            String filename2 = buylistandreqdoc_.getOriginalFilename();
            File destFile2 = DirFileMakeUtil.getUploadDirFile(baseDir,project.getItemname(),DirFileMakeUtil.SORT_CODE_PROJECT,filename2);
            buylistandreqdoc_.transferTo(destFile2);
            project.setBuylistandreqdoc(destFile2.getPath());
        }
        //以下内容为了获取登录者的信息,设置项目的申请人
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = projectService.getLoginUserByLoginToken(loginToken);
        if(user==null){
            CommonUtils.returnMessages(response,false,"您还未登录,或者登录身份已过期!");
            return;
        }
        project.setStarter(user.getId());
        project.setStartdate(new Date());
        projectService.addProject(project);
        CommonUtils.returnMessages(response,true,"招标项目申请提交成功");
    }
    @RequestMapping(value="/project/doProjectCheckByStatusCode/{id}/{statusCode}",method = RequestMethod.GET)
    public void doProjectCheckByStatusCode(@PathVariable(value = "id") Long pid, @PathVariable Integer statusCode, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Project project = projectService.getProjectByPid(pid);
        //项目的审核,只有当项目未审核时才能设置审核员
        if(project.getStatus()==Project.STATUS_CHECK_NO){
        //以下内容为了获取登录者的信息,设置项目的审核人
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = projectService.getLoginUserByLoginToken(loginToken);
        if(user==null){
            CommonUtils.returnMessages(response,false,"您还未登录,或者登录身份已过期!");
            return;
        }
        //项目的审核,只有当项目未审核时才能设置审核员
        project.setChecker(user.getId());
        project.setCheckerdate(new Date());
        }
        try {
            projectService.doProjectCheckByStatusCode(project,statusCode);
            CommonUtils.returnMessages(response,true,"招标项目审核成功!");
        }catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,false,"招标项目审核失败!"+e.getMessage());
        }
    }

    @RequestMapping("/project/selectProjectsByStatus/{statusCode}")
    public void selectProjectsByStatusCode(@PathVariable Integer statusCode,HttpServletResponse response) throws Exception {
        List<Project> projectList =projectService.selectProjectsByStatusCode(statusCode);
        Integer total = projectService.selectProjectCountByStatusCode(statusCode);
        CommonUtils.returnMessages(response,total,projectList);
    }

    /**添加项目公告
     * @param id
     * @param noticeMessage
     * @param deadline
     * @throws Exception
     */
    @RequestMapping(value = "/project/addBiddingNotice",method = RequestMethod.POST)
    public void addBiddingNotice(Long id,String noticeMessage,Date deadline,Long margin,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = projectService.getLoginUserByLoginToken(loginToken);
        if(user==null){
            CommonUtils.returnMessages(response,false,"您还未登录,或者登录身份已过期!");
            return;
        }
        try {
            projectService.addBiddingNotice(id,noticeMessage,deadline,margin);
            CommonUtils.returnMessages(response,true,"添加招标公告成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,false,"添加招标公告失败!"+e.getMessage());
        }
    }

    /**该方法用于将项目发布招标
     * @param pid
     * @throws Exception
     */
    @RequestMapping("/project/beginTender/{pid}")
    public void beginTender(@PathVariable Long pid,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = projectService.getLoginUserByLoginToken(loginToken);
        if(user==null){
            CommonUtils.returnMessages(response,false,"您还未登录,或者登录身份已过期!");
            return;
        }
        try {
            Project project = projectService.getProjectByPid(pid);
            project.setDateline(new Date());
            projectService.doProjectCheckByStatusCode(project,Project.STATUS_TENDER_START);
            CommonUtils.returnMessages(response,true,"招标项目:"+project.getItemname()+";项目编号:"+project.getProjectnum()+";发布成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response,false,"发布失败!");
        }
    }

    @RequestMapping("/project/getProjectByPid/{id}")
    public void getProjectByPid(@PathVariable(value = "id") Long pid,HttpServletResponse response) throws Exception {
        CommonUtils.returnMessages(response,true,projectService.getProjectByPid(pid));
    }

    @RequestMapping("/project/doJudgeIsRebiddingOrContinue/{pid}")
    public void doJudgeIsRebiddingOrContinue(@PathVariable Long pid,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = projectService.getLoginUserByLoginToken(loginToken);
        if(user==null){
            CommonUtils.returnMessages(response,false,"您还未登录,或者登录身份已过期!");
            return;
        }
        Project project = projectService.getProjectByPid(pid);
        if(project.getDeadline().after(new Date())){
            CommonUtils.returnMessages(response,false,"该项目正处于供应商报名阶段,还未超过报名截止日期,不能进行操作.请报名结束后再试!");
            return;
        }
        if(projectService.doJudgeIsRebiddingOrContinue(project)){
            CommonUtils.returnMessages(response,true,"该项目的报名供应商数量符合规定,招标继续!");
        }else{
            CommonUtils.returnMessages(response,false,"该项目的报名供应商数量不符合规定,请重新发布招标!");
        }
    }
    @RequestMapping("/project/doSelectJudgeForRandomByPidAndNums/{flag}")
    public void doSelectJudgeForRandomByPidAndNums(Long pid,Integer nums,@PathVariable byte flag,HttpServletRequest request,HttpServletResponse response) throws Exception {
        String loginToken = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = projectService.getLoginUserByLoginToken(loginToken);
        if(user==null){
            CommonUtils.returnMessages(response,false,"您还未登录,或者登录身份已过期!");
            return;
        }
        Project project = projectService.getProjectByPid(pid);
        if(project.getDeadline().after(new Date())){
            CommonUtils.returnMessages(response,false,"请在供应商报名截止日期之后进行该操作,供应商的报名截止日期为:"+project.getDeadline().toLocaleString());
            return;
        }
        Set<Expert> experts = projectService.doSelectJudgeForRandomByProjectAndNums(project, nums, flag);
        CommonUtils.returnMessages(response,experts.size(),experts);
    }
}
