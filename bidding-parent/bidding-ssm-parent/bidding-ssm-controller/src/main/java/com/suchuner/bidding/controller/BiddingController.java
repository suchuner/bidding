package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.exception.BiddingException;
import com.suchuner.bidding.common.utilpojo.BiddingResultBean;
import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.common.utils.DirFileMakeUtil;
import com.suchuner.bidding.pojo.Bidding;
import com.suchuner.bidding.pojo.Supplier;
import com.suchuner.bidding.pojo.TbUser;
import com.suchuner.bidding.service.IBiddingService;
import com.suchuner.bidding.service.ISupplierService;
import com.suchuner.bidding.service.IUserService;
import com.suchuner.bidding.service.impl.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suchuner
 */
@Controller
public class BiddingController {
    @Autowired
    private IBiddingService biddingService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IUserService userService;


    @Value("${baseDir}")
    private String baseDir;

    @RequestMapping("/bidding/toBiddingPage/{pageCode}")
    public String toBiddingPage(@PathVariable Byte pageCode) {
        switch (pageCode) {
            case 0:
                return "bidding/biddingNoCheck";
            case 1:
                return "bidding/myBidding";
            case 2:
                return "bidding/scoreAVG";
            case 3:
                return "bidding/bestSupplier";
            case 4:
                return "bidding/myBidding2";
            default:
                return "exception/exception";
        }
    }

    @RequestMapping("/bidding/getBiddingByPidAndSid/{pid}/{sid}")
    public void getBiddingByPidAndSid(@PathVariable Long pid, @PathVariable Long sid, HttpServletResponse response) throws Exception {
        Bidding bidding = biddingService.getBiddingByPidAndSid(pid, sid);
        CommonUtils.returnMessages(response, true, bidding);
    }

    @RequestMapping("/bidding/doSupplierMarginSubmit")
    public void doSupplierMarginSubmit(Long pid, Long sid, MultipartFile marginDoc_, HttpServletResponse response) throws Exception {
        if (!marginDoc_.getContentType().equals("image/jpeg")) {
            CommonUtils.returnMessages(response, false, "保证金证明文件未上传或文件格式错误(请上传图片  *.jpg)!");
            return;
        }
        File descFile = DirFileMakeUtil.getUploadDirFile(baseDir, supplierService.getSupplierById(sid).getCompanyname(), DirFileMakeUtil.SORT_CODE_PROJECT_MARGIN, marginDoc_.getOriginalFilename());
        marginDoc_.transferTo(descFile);
        Bidding bidding = biddingService.getBiddingByPidAndSid(pid, sid);
        if (bidding == null) {
            try {
                biddingService.doSupplierMarginSubmit(pid, sid, descFile.getPath());
                CommonUtils.returnMessages(response, true, "保证金证明文件提交成功!");
            } catch (Exception e) {
                e.printStackTrace();
                CommonUtils.returnMessages(response, false, "保证金证明文件提交失败!");
            }
        } else {
            try {
                DirFileMakeUtil.deleteExistFile(bidding.getMargindoc());
                bidding.setMargindoc(descFile.getPath());
                biddingService.updateBidding(bidding);
                CommonUtils.returnMessages(response, true, "保证金证明文件更新成功!");
            } catch (Exception e) {
                e.printStackTrace();
                CommonUtils.returnMessages(response, false, "保证金证明文件更新失败!");
            }
        }
    }

    @RequestMapping("/bidding/selectSupplierMarginsToCheckByPid/{pid}")
    public void selectSupplierMarginsToCheckByPid(@PathVariable Long pid, HttpServletResponse response) throws Exception {
        Integer total = biddingService.getBiddingsCountByPid(pid, false, null);
        CommonUtils.returnMessages(response, total, biddingService.getBiddingsByPid(pid, false, null));
    }

    @RequestMapping("/bidding/selectSupplierByPid/{pid}/{isBegin}")
    public void selectSupplierByPid(@PathVariable Long pid, @PathVariable Byte isBegin, HttpServletResponse response) throws Exception {
        Integer total = biddingService.getBiddingsCountByPid(pid, true, isBegin == Bidding.IS_BEGIN_YES);
        CommonUtils.returnMessages(response, total, biddingService.getBiddingsByPid(pid, true, isBegin == Bidding.IS_BEGIN_YES));
    }

    @RequestMapping("bidding/doCheckSupplierMarginByPidAndSid/{pid}/{sid}/{isMargin}")
    public void doCheckSupplierMarginByPidAndSid(@PathVariable Long pid, @PathVariable Long sid, @PathVariable Byte isMargin, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_USER", true);
        TbUser user = userService.getLoginUserByLoginToken(token);
        if (user == null) {
            CommonUtils.returnMessages(response, false, "你还未登录!");
            return;
        }
        Bidding bidding = biddingService.getBiddingByPidAndSid(pid, sid);
        bidding.setMarginId(user.getId());
        try {
            biddingService.doCheckSupplierMarginByBidding(bidding, isMargin);
            CommonUtils.returnMessages(response, true, "审核成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response, false, "审核失败!");
        }
    }

    @RequestMapping("/bidding/selectMyBiddingsBysid/{isBegin}")
    public void selectMyBiddingsBysid(HttpServletRequest request, HttpServletResponse response, @PathVariable Byte isBegin) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        Supplier supplier = supplierService.getLoginSupplierByLoginToken(token);
        if (supplier == null) {
            throw new BiddingException("你还未登录!");
        }
        if (!isBegin.equals(Bidding.IS_BEGIN_NO) && !isBegin.equals(Bidding.IS_BEGIN_YES)) {
            throw new BiddingException("非法参数异常,操作终止!");
        }
        Integer total = biddingService.getBiddingsCountBySid(supplier.getId(), isBegin);
        CommonUtils.returnMessages(response, total, biddingService.getBiddingsBySid(supplier.getId(), isBegin));
    }

    @RequestMapping("/bidding/doSupplierBidDocSubmit")
    public void doSupplierBidDocSubmit(Long pid, Long sid, MultipartFile bidDoc_, MultipartFile listPriceDoc_, MultipartFile otherDoc_, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_SUPPLIER", true);
        Supplier supplier = supplierService.getLoginSupplierByLoginToken(token);
        if (supplier == null) {
            CommonUtils.returnMessages(response, false, "你还未登录!");
            return;
        }
        if (!bidDoc_.getContentType().equals("application/pdf")) {
            CommonUtils.returnMessages(response, false, "投标文件未上传或文件格式错误(请上传  *.pdf)!");
            return;
        }
        Bidding bidding = biddingService.getBiddingByPidAndSid(pid, sid);
        DirFileMakeUtil.deleteExistFile(bidding.getBiddoc());
        DirFileMakeUtil.deleteExistFile(bidding.getListpricedoc());
        DirFileMakeUtil.deleteExistFile(bidding.getOtherdoc());
        File destFile;
        destFile = DirFileMakeUtil.getUploadDirFile(baseDir, supplier.getCompanyname(), DirFileMakeUtil.SORT_CODE_PROJECT_SUPPLIER_BID_DOC, bidDoc_.getOriginalFilename());
        bidDoc_.transferTo(destFile);
        bidding.setBiddoc(destFile.getPath());
        if (listPriceDoc_ != null) {
            if (!listPriceDoc_.getContentType().equals("application/pdf")) {
                CommonUtils.returnMessages(response, false, "采购清单报价文件格式错误(请上传  *.pdf)!");
                return;
            }
            destFile = DirFileMakeUtil.getUploadDirFile(baseDir, supplier.getCompanyname(), DirFileMakeUtil.SORT_CODE_PROJECT_SUPPLIER_BID_DOC, listPriceDoc_.getOriginalFilename());
            listPriceDoc_.transferTo(destFile);
            bidding.setListpricedoc(destFile.getPath());
        }
        if (otherDoc_ != null) {
            if (!otherDoc_.getContentType().equals("application/pdf")) {
                CommonUtils.returnMessages(response, false, "其他补充文件格式错误(请上传  *.pdf)!");
                return;
            }
            destFile = DirFileMakeUtil.getUploadDirFile(baseDir, supplier.getCompanyname(), DirFileMakeUtil.SORT_CODE_PROJECT_SUPPLIER_BID_DOC, otherDoc_.getOriginalFilename());
            otherDoc_.transferTo(destFile);
            bidding.setOtherdoc(destFile.getPath());
        }
        try {
            biddingService.doSupplierBidDocSubmit(bidding);
            CommonUtils.returnMessages(response, true, "投标书提交成功!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response, false, "投标书提交失败!");
        }
    }

    @RequestMapping("/bidding/doScoreAVGByPidAndSid/{pid}/{sid}")
    public void doScoreAVGByPidAndSid(@PathVariable Long pid, @PathVariable Long sid, HttpServletResponse response) throws Exception {
        try {
            biddingService.doScoreAVGByPidAndSid(pid, sid);
            CommonUtils.returnMessages(response, true, "计算完成!");
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response, false, "计算失败!原因:" + e.getMessage());
        }
    }

    @RequestMapping("/bidding/selectTheBestWinnerOrReBidding/{pid}/{isBegin}")
    public void selectTheBestWinnerOrReBidding(@PathVariable Long pid, @PathVariable Byte isBegin, HttpServletResponse response) throws Exception {
        try {
            BiddingResultBean biddingResultBean = biddingService.selectTheBestWinnerOrReBidding(pid, isBegin == Bidding.IS_BEGIN_YES);
            List<Supplier> list = new ArrayList<>();
            if (biddingResultBean.getFlag() == BiddingService.IS_EXIST_WINNER_YES) {
                list.add(supplierService.getSupplierById(Long.valueOf(biddingResultBean.getObj().toString())));
                CommonUtils.returnMessages(response, 1, list);
            } else {
                Long[] longs = CommonUtils.numStringsConvertToLongArr(biddingResultBean.getObj().toString());
                for (Long aLong : longs) {
                    list.add(supplierService.getSupplierById(aLong));
                }
                CommonUtils.returnMessages(response, list.size(), list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            CommonUtils.returnMessages(response, false, "错误!原因:" + e.getMessage());
        }
    }
}
