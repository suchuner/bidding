package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.mapper.EnrollMapper;
import com.suchuner.bidding.pojo.Enroll;
import com.suchuner.bidding.pojo.EnrollExample;
import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.service.IEnrollService;
import com.suchuner.bidding.service.IProjectService;
import com.suchuner.bidding.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author suchuner
 */
@Service
public class EnrollService implements IEnrollService {
    @Autowired
    private EnrollMapper enrollMapper;

    @Autowired
    private MailSender mailSender;

    @Value("${BIDDING.EMAIL.ACCOUNT}")
    private String emailAccount;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private ISupplierService supplierService;

    @Value("${BIDDING.MARGIN.CASH}")
    private Long MARGIN_CASH;

    public void addEnroll(Enroll enroll) throws Exception {
        enroll.setIsenroll(Enroll.IS_ENROLL_NO);
        enroll.setIslegal(Enroll.IS_MARGIN_NO);
        enroll.setEnrolldate(new Date());
        enrollMapper.insertSelective(enroll);
    }

    public List<Enroll> selectProjectToCheckByPid(Long pid) throws Exception {
        EnrollExample enrollExample = new EnrollExample();
        EnrollExample.Criteria criteria = enrollExample.createCriteria();
        criteria.andPjtIdEqualTo(pid);
        criteria.andIsenrollEqualTo(Enroll.IS_ENROLL_NO);
        criteria.andIsnormalNotEqualTo(Enroll.IS_NORMAL_NO);
        return enrollMapper.selectByExample(enrollExample);
    }

    public void doCheckProjectEnrollToFailure(Enroll enroll, String message) throws Exception {
        Project project = projectService.getProjectByPid(enroll.getPjtId());
        if (project.getStatus() != Project.STATUS_TENDER_START) {
            throw new BiddingException("该招标项目状态异常,无法继续操作!");
        }
        Supplier supplier = supplierService.getSupplierById(enroll.getSupId());
        if (supplier.getIsnormal() != Supplier.NORMAL_YES) {
            throw new BiddingException("该供应商状态异常,无法继续操作!");
        }
        try {
            SimpleMailMessage sm = new SimpleMailMessage();
            sm.setSentDate(new Date());
            sm.setSubject("招标项目:'" + project.getItemname() + "'报名审核未通过");
            StringBuffer buffer = new StringBuffer("尊敬的");
            buffer.append(supplier.getCompanyname());
            buffer.append(",贵公司于'");
            buffer.append(enroll.getEnrolldate().toLocaleString());
            buffer.append("'报名投标的项目(");
            buffer.append(project.getItemname());
            buffer.append(")未通过该项目的报名审核,原因:");
            buffer.append(message);
            buffer.append(";如有需要,可再次申请报名该项目;xxx招标系统");
            sm.setText(buffer.toString());
            sm.setFrom(emailAccount);
            sm.setTo(supplier.getCompanyemail());
            mailSender.send(sm);
        } catch (MailException e) {
            e.printStackTrace();
            throw new BiddingException("邮件发送失败,请检查网络状态是否正常,该审核失败,网络正常后请重新审核.");
        }
        enroll.setIsenroll(Enroll.IS_ENROLL_NO);
        enroll.setIsnormal(Enroll.IS_NORMAL_NO);
        enrollMapper.updateByPrimaryKeySelective(enroll);
    }

    public List<Enroll> getEnrollsByPidAndSid(Long pjtId, Long sid) throws Exception {
        EnrollExample enrollExample = new EnrollExample();
        EnrollExample.Criteria criteria = enrollExample.createCriteria();
        if (pjtId != null) {
            criteria.andPjtIdEqualTo(pjtId);
        }
        if (sid != null) {
            criteria.andSupIdEqualTo(sid);
        }
        return enrollMapper.selectByExample(enrollExample);
    }

    public void deleteEnroll(Enroll enroll) throws Exception {
        EnrollExample enrollExample = new EnrollExample();
        EnrollExample.Criteria criteria = enrollExample.createCriteria();
        criteria.andPjtIdEqualTo(enroll.getPjtId());
        criteria.andSupIdEqualTo(enroll.getSupId());
        enrollMapper.deleteByExample(enrollExample);
    }

    private EnrollExample getConditionByCheckCode(Long sid, Byte checkCode) {
        EnrollExample enrollExample = new EnrollExample();
        EnrollExample.Criteria criteria = enrollExample.createCriteria();
        criteria.andSupIdEqualTo(sid);
        criteria.andIslegalEqualTo(Enroll.IS_MARGIN_NO);
        switch (checkCode) {
            case 0:
                criteria.andIsenrollEqualTo(Enroll.IS_ENROLL_YES);
                criteria.andIsnormalEqualTo(Enroll.IS_NORMAL_YES);
                break;
            case 1:
                criteria.andIsenrollEqualTo(Enroll.IS_ENROLL_NO);
                criteria.andIsnormalEqualTo(Enroll.IS_NORMAL_NO);
                break;
            default:
                throw new BiddingException("非法参数异常,操作终止!");
        }
        return enrollExample;
    }

    public List<Enroll> selectSupplierEnrollsInfoBySid(Long sid, Byte checkCode) throws Exception {
        return enrollMapper.selectByExample(getConditionByCheckCode(sid, checkCode));
    }

    public Integer selectSupplierEnrollsCountInfoBySid(Long sid, Byte checkCode) throws Exception {
        return enrollMapper.countByExample(getConditionByCheckCode(sid, checkCode));
    }

    public Enroll getEnrollById(Long id) throws Exception {
        Enroll enroll = enrollMapper.selectByPrimaryKey(id);
        if (enroll == null) {
            throw new BiddingException("非法参数异常,操作终止!");
        }
        return enroll;
    }

    public Integer selectProjectCountToCheckByPid(Long pid) throws Exception {
        EnrollExample enrollExample = new EnrollExample();
        EnrollExample.Criteria criteria = enrollExample.createCriteria();
        criteria.andPjtIdEqualTo(pid);
        criteria.andIsenrollEqualTo(Enroll.IS_ENROLL_NO);
        criteria.andIsnormalNotEqualTo(Enroll.IS_NORMAL_NO);
        return enrollMapper.countByExample(enrollExample);
    }


    public void doCheckProjectEnrollToSuccess(Enroll enroll) throws Exception {
        Project project = projectService.getProjectByPid(enroll.getPjtId());
        if (project.getStatus() != Project.STATUS_TENDER_START) {
            throw new BiddingException("该招标项目状态异常,无法继续操作!");
        }
        Supplier supplier = supplierService.getSupplierById(enroll.getSupId());
        if (supplier.getIsnormal() != Supplier.NORMAL_YES) {
            throw new BiddingException("该供应商状态异常,无法继续操作!");
        }
        try {
            SimpleMailMessage sm = new SimpleMailMessage();
            sm.setSentDate(new Date());
            sm.setSubject("招标项目:'" + project.getItemname() + "'报名成功");
            StringBuffer buffer = new StringBuffer("尊敬的");
            buffer.append(supplier.getCompanyname());
            buffer.append(",贵公司于'");
            buffer.append(enroll.getEnrolldate().toLocaleString().replace("0:00:00",""));
            buffer.append("'报名投标的项目(");
            buffer.append(project.getItemname());
            buffer.append(")已通过该项目的报名审核,请于报名截止日期之后,项目竞标日期前两天缴纳投标保证金参与竞标,应缴纳的保证金金额为");
            buffer.append(project.getBid());
            buffer.append("(人民币/元);xxx招标系统");
            sm.setText(buffer.toString());
            sm.setFrom(emailAccount);
            sm.setTo(supplier.getCompanyemail());
            mailSender.send(sm);
        } catch (MailException e) {
            e.printStackTrace();
            throw new BiddingException("邮件发送失败,请检查网络状态是否正常,该审核失败,网络正常后请重新审核.");
        }
        enroll.setIsenroll(Enroll.IS_ENROLL_YES);
        enroll.setIsnormal(Enroll.IS_NORMAL_YES);
        enrollMapper.updateByPrimaryKeySelective(enroll);
    }
}
