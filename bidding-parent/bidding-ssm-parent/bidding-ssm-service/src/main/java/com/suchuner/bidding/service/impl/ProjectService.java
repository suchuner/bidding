package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utils.JsonUtils;
import com.suchuner.bidding.mapper.ProjectMapper;
import com.suchuner.bidding.pojo.*;
import com.suchuner.bidding.service.*;
import com.suchuner.bidding.service.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author suchuner
 */
@Service
public class ProjectService implements IProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private IExpertService expertService;

    @Autowired
    private IProjectExpertService projectExpertService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IEnrollService enrollService;

    @Value("${BIDDING_PROJECT_NUM_PREFIX}")
    private String BIDDING_PROJECT_NUM_PREFIX;

    @Value("${BIDDING_PROJECT_NUM_START}")
    private String BIDDING_PROJECT_NUM_START;

    @Value("${BIDDING_PROJECT_NUM_SUFFIX}")
    private String BIDDING_PROJECT_NUM_SUFFIX;


    @Value("${BIDDING_SYSTEM_USER_EXPIRE}")
    private Integer BIDDING_SYSTEM_USER_EXPIRE;

    @Value("${BIDDING.EMAIL.ACCOUNT}")
    private String emailAccount;

    @Value("${BIDDING.REQUIRE.PASS.SUPPLIER.NUM}")
    private int REQUIRE_PASS_SUPPLIER_NUM;

    @Value("${BIDDING.MARGIN.CASH}")
    private Long MARGIN_CASH;

    private String BIDDING_PROJECT_REDIS_KEY="BIDDING_PROJECT_REDIS_KEY";

    public void addProject(Project project) throws Exception {
        try {
            if(!jedisClient.exists(BIDDING_PROJECT_REDIS_KEY)){
                jedisClient.set(BIDDING_PROJECT_REDIS_KEY,BIDDING_PROJECT_NUM_START);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw  new BiddingException(" Redis缓存服务器未开启,请开启Redis服务器!");
        }
        StringBuffer projectNum=new StringBuffer(BIDDING_PROJECT_NUM_PREFIX);
        projectNum.append(jedisClient.incr(BIDDING_PROJECT_REDIS_KEY));
        projectNum.append(BIDDING_PROJECT_NUM_SUFFIX);
        project.setProjectnum(projectNum.toString());
        //设置项目的状态为未审核
        project.setStatus(Project.STATUS_CHECK_NO);
        project.setIsrebidding(Project.IS_REBIDDING_NO);
        project.setIsbegin(Project.IS_BEGIN_YES);
        projectMapper.insert(project);
    }

    /**该方法用于通过项目的id和改变项目的状态码来做项目的审核
     * @param project
     * @param statusCode
     */
    public void doProjectCheckByStatusCode(Project project, Integer statusCode) throws Exception{
        switch (statusCode){
            case Project.STATUS_CHECK_YES_PASS_NO :
                if(Project.STATUS_CHECK_NO == project.getStatus()){
                project.setStatus(Project.STATUS_CHECK_YES_PASS_NO);projectMapper.updateByPrimaryKeySelective(project);
                }else{
                    throw new BiddingException("项目审核流程不符合逻辑,请按照审核流程进行!");
                }
                break;
            case Project.STATUS_CHECK_YES_PASS_YES :
                if(Project.STATUS_CHECK_NO==project.getStatus()){
                    project.setStatus(Project.STATUS_CHECK_YES_PASS_YES);projectMapper.updateByPrimaryKeySelective(project);
                }else{
                    throw new BiddingException("项目审核流程不符合逻辑,请按照审核流程进行!");
                }
                break;
            case Project.STATUS_TENDER_START :
                if(Project.STATUS_CHECK_YES_PASS_YES==project.getStatus()){
                    project.setStatus(Project.STATUS_TENDER_START);projectMapper.updateByPrimaryKeySelective(project);
                }else{
                    throw new BiddingException("项目审核流程不符合逻辑,请按照审核流程进行!");
                }
                break;
            case Project.STATUS_TENDERING :
                if(Project.STATUS_TENDER_START==project.getStatus()){
                    project.setStatus(Project.STATUS_TENDERING);projectMapper.updateByPrimaryKeySelective(project);
                }else{
                    throw new BiddingException("项目审核流程不符合逻辑,请按照审核流程进行!");
                }
                break;
            case Project.STATUS_TENDER_SUCCESS :
                if(Project.STATUS_TENDERING==project.getStatus()){
                    project.setStatus(Project.STATUS_TENDER_SUCCESS);projectMapper.updateByPrimaryKeySelective(project);
                }else{
                    throw new BiddingException("项目审核流程不符合逻辑,请按照审核流程进行!");
                }
                break;
            case Project.STATUS_TENDER_FAILURE :
                if(Project.STATUS_TENDERING==project.getStatus()){
                    project.setStatus(Project.STATUS_TENDER_FAILURE);projectMapper.updateByPrimaryKeySelective(project);
                }else{
                    throw new BiddingException("项目审核流程不符合逻辑,请按照审核流程进行!");
                }
            break;
            default:throw new BiddingException("非法参数异常,项目状态码有误!");
        }
    }

    public Project getProjectByPid(Long pid) throws Exception {
        Project project = projectMapper.selectByPrimaryKey(pid);
        if(project==null){
            throw new BiddingException("非法参数异常,该项目不存在!");
        }
        return project;
    }

    public List<Project> selectProjectsByStatusCode(Integer statusCode) throws Exception{
        if(statusCode==null){
            throw new BiddingException("非法参数异常,状态码不能为空!");
        }
        List<Project> projectList =null;
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        //为避免statusCode为空报错,在执行之前判断该状态码是否为空
        criteria.andStatusEqualTo(statusCode);
        switch (statusCode){
            case Project.STATUS_CHECK_NO : projectList=projectMapper.selectByExample(projectExample); break;
            case Project.STATUS_CHECK_YES_PASS_NO : projectList=projectMapper.selectByExample(projectExample); break;
            case Project.STATUS_CHECK_YES_PASS_YES: projectList=projectMapper.selectByExample(projectExample); break;
            case Project.STATUS_TENDER_START: projectList=projectMapper.selectByExample(projectExample); break;
            case Project.STATUS_TENDERING : projectList=projectMapper.selectByExample(projectExample); break;
            case Project.STATUS_TENDER_SUCCESS : projectList=projectMapper.selectByExample(projectExample); break;
            case Project.STATUS_TENDER_FAILURE : projectList=projectMapper.selectByExample(projectExample); break;
            default:throw new BiddingException("非法参数异常,项目状态码有误!");
        }
        return projectList;
    }

    public Integer selectProjectCountByStatusCode(Integer statusCode) throws Exception {
        if(statusCode==null){
            throw new BiddingException("非法参数异常,状态码不能为空!");
        }
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria criteria = projectExample.createCriteria();
        //为避免statusCode为空报错,在执行之前判断该状态码是否为空
        criteria.andStatusEqualTo(statusCode);
        switch (statusCode){
            case Project.STATUS_CHECK_NO : return projectMapper.countByExample(projectExample);
            case Project.STATUS_CHECK_YES_PASS_NO : return projectMapper.countByExample(projectExample);
            case Project.STATUS_CHECK_YES_PASS_YES: return projectMapper.countByExample(projectExample);
            case Project.STATUS_TENDER_START: return projectMapper.countByExample(projectExample);
            case Project.STATUS_TENDERING : return projectMapper.countByExample(projectExample);
            case Project.STATUS_TENDER_SUCCESS : return projectMapper.countByExample(projectExample);
            case Project.STATUS_TENDER_FAILURE : return projectMapper.countByExample(projectExample);
            default:throw new BiddingException("非法参数异常,项目状态码有误!");
        }
    }

    public TbUser getLoginUserByLoginToken(String token) throws Exception{
        String jsonUser = jedisClient.get("BIDDING_SYSTEM_USER:USER:" + token);
        if(jsonUser==null||jsonUser.trim().equals("")){
            return null;
        }
        //重新设置登录过期时间
        jedisClient.expire("BIDDING_SYSTEM_USER:USER:"+ token,BIDDING_SYSTEM_USER_EXPIRE);
        TbUser loginUser = JsonUtils.jsonToPojo(jsonUser, TbUser.class);
        return loginUser;
    }

    public void addBiddingNotice(Long pid, String noticeMessage, Date deadline) throws Exception {
        Project project = getProjectByPid(pid);
        if(project.getStatus()==Project.STATUS_CHECK_YES_PASS_YES){
        project.setNotice(noticeMessage);
        //设置项目报名的截止日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(deadline);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date time = calendar.getTime();
        project.setDeadline(time);
        projectMapper.updateByPrimaryKeySelective(project);
        if(project.getIsrebidding()==Project.IS_REBIDDING_YES){
            List<Enroll> enrolls = enrollService.selectProjectToCheckByPid(pid);
            for (Enroll enroll : enrolls) {
                if(enroll.getIsenroll()==Enroll.IS_ENROLL_YES&&enroll.getIsnormal()==Enroll.IS_NORMAL_YES){
                    SimpleMailMessage sm = new SimpleMailMessage();
                    sm.setSentDate(new Date());
                    StringBuffer subject = new StringBuffer("通知:招标项目:'");
                    subject.append(project.getItemname());
                    subject.append("'重新发布招标");
                    sm.setSubject(subject.toString());
                    Supplier supplier = supplierService.getSupplierById(enroll.getSupId());
                    StringBuffer text = new StringBuffer("尊敬的");
                    text.append(supplier.getCompanyname());
                    text.append(",贵公司参与并已成功通过报名审核的招标项目,由于通过报名审核的供应商数量未达到招标要求,所以该项目需要重新发布招标;但是贵公司已经通过了报名审核,即不再需要申请报名;但需要重新下载招标书了解情况,如果你还未缴纳保证金,请于报名截止日期之后,项目竞标日期前两天缴纳.xxx招标系统");
                    sm.setText(text.toString());
                    sm.setFrom(emailAccount);
                    sm.setTo(supplier.getCompanyemail());
                    mailSender.send(sm);
                }
            }
        }
        }else{
            throw new BiddingException("该项目不能提交招标公告,项目进程逻辑异常!");
        }
    }

    public Boolean doJudgeIsRebiddingOrContinue(Project project) throws Exception {
        if(project.getStatus()!=Project.STATUS_TENDER_START){
            throw new BiddingException("该项目操作流程有误,不能执行该操作!");
        }
        List<Enroll> enrolls = enrollService.getEnrollsByPidAndSid(project.getId(),null);
        int count=0;
        for (Enroll enroll : enrolls) {
            if(enroll.getIsenroll()==Enroll.IS_ENROLL_YES&&enroll.getIsnormal()==Enroll.IS_NORMAL_YES){
                count++;
            }
        }
        boolean flag ;
        if(count>=REQUIRE_PASS_SUPPLIER_NUM){
            project.setStatus(Project.STATUS_TENDERING);
            project.setIsrebidding(Project.IS_REBIDDING_NO_CONTINUE);
            flag=true;
        }else{
            project.setStatus(Project.STATUS_CHECK_YES_PASS_YES);
            project.setIsrebidding(Project.IS_REBIDDING_YES);
            project.setNotice("");
            flag=false;
        }
        projectMapper.updateByPrimaryKeySelective(project);
        return flag;
    }

    public Set<Expert> doSelectJudgeForRandomByProjectAndNums(Project project, Integer nums, byte flag) throws Exception {
        if(nums<3||nums > 9||nums%2==0){
            throw  new BiddingException("非法参数异常,随机抽取评标人数在3~9之间(包含3和9),且只能为奇数!");
        }
        //将评标人的id设置到项目评标人表中
        ProjectExpert projectExpert ;
        switch (flag){
            case 0:
                if(projectExpertService.getProjectExpertByProject(project)!=null) throw new BiddingException("操作参数异常,操作终止!");
                projectExpert =new ProjectExpert();
                projectExpert.setPjtId(project.getId());
                break;
            case 1:
                if(projectExpertService.getProjectExpertByProject(project)==null) throw new BiddingException("操作参数异常,操作终止!");
                //根据招标项目获取该-项目评标人-对象
                projectExpert = projectExpertService.getProjectExpertByProject(project);
                //设置之前设置的随机评标人清空,以便更新
                projectExpert.setJudge1Id(null);
                projectExpert.setJudge2Id(null);
                projectExpert.setJudge3Id(null);
                projectExpert.setJudge4Id(null);
                projectExpert.setJudge5Id(null);
                projectExpert.setJudge6Id(null);
                projectExpert.setJudge7Id(null);
                projectExpert.setJudge8Id(null);
                projectExpert.setJudge9Id(null);
                projectExpertService.updateProjectExpertByProjectExpert(projectExpert);
                break;
            default: throw new BiddingException("操作参数异常,操作终止!");
        }
        //设置招标项目的评标人数
        project.setJudgenums(nums);
        projectMapper.updateByPrimaryKeySelective(project);
        //生成随机的评标人
        Integer lastInsertId = expertService.getLastInsertId();
        Random random = new Random();
        Set<Expert> experts = new HashSet<Expert>();
        while(experts.size()<nums){
            int id = random.nextInt(lastInsertId + 1);
            if(id==0)id++;
            Expert expert = expertService.getExpertById((long)id);
            if (expert != null&&expert.getIsnormal()==Expert.ISNOEMAL_YES)experts.add(expert);
        }
        Expert[] arrays =experts.toArray(new Expert[nums]);
        for (int j=1; j<=nums;j++){
            switch (j){
                case 1 : projectExpert.setJudge1Id(arrays[0].getId());break;
                case 2 : projectExpert.setJudge2Id(arrays[1].getId());break;
                case 3 : projectExpert.setJudge3Id(arrays[2].getId());break;
                case 4 : projectExpert.setJudge4Id(arrays[3].getId());break;
                case 5 : projectExpert.setJudge5Id(arrays[4].getId());break;
                case 6 : projectExpert.setJudge6Id(arrays[5].getId());break;
                case 7 : projectExpert.setJudge7Id(arrays[6].getId());break;
                case 8 : projectExpert.setJudge8Id(arrays[7].getId());break;
                case 9 : projectExpert.setJudge9Id(arrays[8].getId());break;
                default: throw new BiddingException("参数错误!");
            }
        }
        switch (flag){
            case 0 : projectExpertService.addProjectExpert(projectExpert); break;
            case 1 : projectExpertService.updateProjectExpertByProjectExpert(projectExpert);break;
            default:throw new BiddingException("非法参数异常!");
        }
        return experts;
    }

    public void updateProject(Project project) throws Exception {
        projectMapper.updateByPrimaryKeySelective(project);
    }
}
