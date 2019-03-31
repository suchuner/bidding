package com.suchuner.bidding.action;

import com.opensymphony.xwork2.ActionSupport;
import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utilpojo.BiddingFileType;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.service.ISupplierService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @author suchuner
 */
public class FileDownloadAction extends ActionSupport {
    private String fileName;

    private InputStream downloadFile;

    public InputStream getDownloadFile() {
        return downloadFile;
    }

    public void setDownloadFile(InputStream downloadFile) {
        this.downloadFile = downloadFile;
    }

    public String getFileName() {
        return CommonUtils.handleDownloadFileMojibakeByChineseFileName(ServletActionContext.getRequest(),fileName);
    }

    private ISupplierService supplierService;

    public void setSupplierService(ISupplierService supplierService) {
        this.supplierService = supplierService;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Byte flag;

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String execute() throws Exception {
        if(id==null||flag==null){
            throw  new BiddingException("非法参数异常,下载操作终止!");
        }
        Supplier supplier = supplierService.getSupplierById(id);
        String path=null;
        String suffixName ;
        StringBuffer tempName = new StringBuffer(supplier.getCompanyname());
        switch (flag){
            case BiddingFileType.SUPPLIER_FILE_BIZ_CODE :
                path = supplier.getBizlicdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                fileName =tempName.append(BiddingFileType.SUPPLIER_FILE_BIZ_NAME).append(new Date().getTime()).append(suffixName).toString();
            break;
            case BiddingFileType.SUPPLIER_FILE_TAXREG_CODE :
                path = supplier.getTaxregdoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                fileName =tempName.append(BiddingFileType.SUPPLIER_FILE_TAXREG_NAME).append(new Date().getTime()).append(suffixName).toString();
            break;
            case BiddingFileType.SUPPLIER_FILE_ORG_CODE :
                path = supplier.getOrgcodedoc();
                if(StringUtils.isEmpty(path)){
                    throw  new BiddingException("该文件未上传,下载操作终止!");
                }
                suffixName = path.substring(path.lastIndexOf("."));
                fileName =tempName.append(BiddingFileType.SUPPLIER_FILE_ORG_NAME).append(new Date().getTime()).append(suffixName).toString();
            break;
            default:throw  new BiddingException("非法参数异常,下载操作终止!");
        }
        downloadFile = new FileInputStream(path);
        return SUCCESS;
    }
}
