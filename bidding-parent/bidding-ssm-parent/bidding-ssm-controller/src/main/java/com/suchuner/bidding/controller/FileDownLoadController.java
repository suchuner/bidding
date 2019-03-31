package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utilpojo.BiddingFileType;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.pojo.Bidding;
import com.suchuner.bidding.pojo.Enroll;
import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.service.IBiddingService;
import com.suchuner.bidding.service.IEnrollService;
import com.suchuner.bidding.service.IProjectService;
import com.suchuner.bidding.service.ISupplierService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;

/**
 * @author suchuner
 */
@Controller
public class FileDownLoadController {
    @Autowired
    private IProjectService projectService;

    @Autowired
    private IBiddingService biddingService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IEnrollService enrollService;

    @RequestMapping("/download/downloadFile/{id}/{flag}")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id, @PathVariable Byte flag) throws Exception {
        if(id==null||flag==null){
            throw  new BiddingException("非法参数异常,下载操作终止!");
        }
        Project project = projectService.getProjectByPid(id);
        String path = null;
        String suffixName =null;
        StringBuffer tempName = new StringBuffer(project.getProjectnum()).append("_").append(project.getItemname());
        switch (flag){
            case BiddingFileType.PROJECT_FILE_BIDDINGDOC_CODE :
                path=project.getBiddingdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.PROJECT_FILE_BIDDINGDOC_NAME);
            break;
            case BiddingFileType.PROJECT_FILE_BUYLIST_AND_TECHREQ_CODE :
                path=project.getBuylistandreqdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.PROJECT_FILE_BUYLIST_AND_TECHREQ_NAME);
            break;
            case BiddingFileType.PROJECT_FILE_BIDDINGREQ_CODE :
                path=project.getBiddingrequiredoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.PROJECT_FILE_BIDDINGREQ_NAME);
            break;
            case BiddingFileType.PROJECT_FILE_OTHERDOC_CODE :
                path=project.getOtherdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.PROJECT_FILE_OTHERDOC_NAME);
            break;
            default:throw  new BiddingException("非法参数异常,操作终止!");
        }

        File downloadFile = new File(path);
        String fileName = CommonUtils.handleDownloadFileMojibakeByChineseFileName(request,tempName.append(suffixName).toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",fileName);
     //   headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName+\"");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //HttpStatus的状态必须为ok,微软系列的不支持其他状态下的文件下载;即微软系列的浏览器只能通过OK的状态来下载文件
       //使用FileUtils时当文件数据过大的时候（大概超过40M左右）就会容易内存溢出
        return new ResponseEntity<>(FileUtils.readFileToByteArray(downloadFile), headers, HttpStatus.OK);
    }
    @RequestMapping("/download/downloadFiles/{id}/{flag}")
    public ResponseEntity<byte[]> downloadFiles(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id,@PathVariable Byte flag) throws Exception {
        if(id==null||flag==null){
            throw  new BiddingException("非法参数异常,下载操作终止!");
        }
        Bidding bidding = biddingService.getBiddingById(id);
        Supplier supplier = supplierService.getSupplierById(bidding.getSupId());
        Project project = projectService.getProjectByPid(bidding.getPjtId());
        String path = null;
        String suffixName =null;
        StringBuffer tempName = new StringBuffer(supplier.getShortname());
        switch (flag){
            case BiddingFileType.BIDDING_FILE_MARGIN_CODE :
                path=bidding.getMargindoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.BIDDING_FILE_MARGIN_NAME);
            break;
            case BiddingFileType.BIDDING_FILE_BIDDOC_CODE :
                path=bidding.getBiddoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.BIDDING_FILE_BIDDOC_NAME);
            break;
            case BiddingFileType.BIDDING_FILE_BUYLISTPRICE_CODE :
                path=bidding.getListpricedoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.BIDDING_FILE_BUYLISTPRICE_NAME);
            break;
            case BiddingFileType.BIDDING_FILE_OTHERDOC_CODE :
                path=bidding.getOtherdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.BIDDING_FILE_OTHERDOC_NAME);
            break;
            default:throw  new BiddingException("非法参数异常,操作终止!");
        }
        File downloadFile = new File(path);
        String fileName = CommonUtils.handleDownloadFileMojibakeByChineseFileName(request,tempName.append(project.getProjectnum()).append("_").append(project.getItemname()).append(suffixName).toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",fileName);
        //   headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName+\"");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //HttpStatus的状态必须为ok,微软系列的不支持其他状态下的文件下载;即微软系列的浏览器只能通过OK的状态来下载文件
        //使用FileUtils时当文件数据过大的时候（大概超过40M左右）就会容易内存溢出
        return new ResponseEntity<>(FileUtils.readFileToByteArray(downloadFile), headers, HttpStatus.OK);
    }
    @RequestMapping("/download/download/{id}/{flag}")
    public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response, @PathVariable Long id,@PathVariable Byte flag) throws Exception {
        if(id==null||flag==null){
            throw  new BiddingException("非法参数异常,下载操作终止!");
        }
        Enroll enroll = enrollService.getEnrollById(id);
        Supplier supplier = supplierService.getSupplierById(enroll.getSupId());
        String path = null;
        String suffixName =null;
        StringBuffer tempName = new StringBuffer(supplier.getShortname());
        switch (flag){
            case BiddingFileType.ENROLL_FILE_LEGAL_CODE :
                path=enroll.getLegaldoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.ENROLL_FILE_LEGAL_NAME);
            break;
            case BiddingFileType.ENROLL_FILE_TAX_CODE :
                path=enroll.getTaxdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.ENROLL_FILE_TAX_NAME);
            break;
            case BiddingFileType.ENROLL_FILE_SI_CODE :
                path=enroll.getSidoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                tempName.append(BiddingFileType.ENROLL_FILE_SI_NAME);
             break;
            default:throw  new BiddingException("非法参数异常,操作终止!");
        }
        File downloadFile = new File(path);
        String fileName = CommonUtils.handleDownloadFileMojibakeByChineseFileName(request,tempName.append(new Date().getTime()).append(suffixName).toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",fileName);
        //   headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName+\"");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //HttpStatus的状态必须为ok,微软系列的不支持其他状态下的文件下载;即微软系列的浏览器只能通过OK的状态来下载文件
        //使用FileUtils时当文件数据过大的时候（大概超过40M左右）就会容易内存溢出
        return new ResponseEntity<>(FileUtils.readFileToByteArray(downloadFile), headers, HttpStatus.OK);
    }

}
