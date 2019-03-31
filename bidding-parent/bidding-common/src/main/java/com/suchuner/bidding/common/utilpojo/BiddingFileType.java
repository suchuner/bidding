package com.suchuner.bidding.common.utilpojo;

/**
 * @author suchuner
 */
public class BiddingFileType {
    /**
     * 营业执照
     */
    public static final byte SUPPLIER_FILE_BIZ_CODE=0;
    /**
     *税务登记证
     */
    public static final byte SUPPLIER_FILE_TAXREG_CODE=1;
    /**
     *组织代码机构证
     */
    public static final byte SUPPLIER_FILE_ORG_CODE=2;

    public static final String SUPPLIER_FILE_BIZ_NAME="_营业执照_";
    public static final String SUPPLIER_FILE_TAXREG_NAME="_税务登记证_";
    public static final String SUPPLIER_FILE_ORG_NAME="_组织代码机构证_";

    /**
     *招标书
     */
    public static final byte PROJECT_FILE_BIDDINGDOC_CODE=0;
    /**
     *采购清单与技术要求
     */
    public static final byte PROJECT_FILE_BUYLIST_AND_TECHREQ_CODE=1;
    /**
     *投标须知
     */
    public static final byte PROJECT_FILE_BIDDINGREQ_CODE=2;
    /**
     *其他补充文件
     */
    public static final byte PROJECT_FILE_OTHERDOC_CODE=3;

    public static final String PROJECT_FILE_BIDDINGDOC_NAME="_招标书_";
    public static final String PROJECT_FILE_BUYLIST_AND_TECHREQ_NAME="_采购清单与技术要求_";
    public static final String PROJECT_FILE_BIDDINGREQ_NAME="_投标须知_";
    public static final String PROJECT_FILE_OTHERDOC_NAME="_其他补充文件_";

    public static final byte BIDDING_FILE_MARGIN_CODE=0;
    public static final byte BIDDING_FILE_BIDDOC_CODE=1;
    public static final byte BIDDING_FILE_BUYLISTPRICE_CODE=2;
    public static final byte BIDDING_FILE_OTHERDOC_CODE=3;

    public static final String BIDDING_FILE_MARGIN_NAME="_保证金_";
    public static final String BIDDING_FILE_BIDDOC_NAME="_投标文件_";
    public static final String BIDDING_FILE_BUYLISTPRICE_NAME="_采购报价清单_";
    public static final String BIDDING_FILE_OTHERDOC_NAME="_其他补充文件_";

    /**
     * 无重大违法记录证明文件
     */
    public static final byte ENROLL_FILE_LEGAL_CODE=0;
    /**
     * 依法纳税证明文件
     */
    public static final byte ENROLL_FILE_TAX_CODE=1;
    /**
     * 员工缴纳社保证明文件
     */
    public static final byte ENROLL_FILE_SI_CODE=2;


    public static final String ENROLL_FILE_LEGAL_NAME="_无重大违法记录文件_";

    public static final String   ENROLL_FILE_TAX_NAME="_依法纳税证明文件_";

    public static final String    ENROLL_FILE_SI_NAME="_员工缴纳社保证明文件_";


}
