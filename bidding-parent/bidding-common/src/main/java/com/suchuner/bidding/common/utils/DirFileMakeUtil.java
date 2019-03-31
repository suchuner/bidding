package com.suchuner.bidding.common.utils;


import java.io.File;
import java.io.IOException;

/**
 * 该类用于创建上传文件的保存路径
 * @author suchuner
 */
public class DirFileMakeUtil {
    private DirFileMakeUtil(){}

    /**
     * 供应商
     */
    public static final byte SORT_CODE_SUPPLIER =0;
    /**
     * 招标项目
     */
    public static final byte SORT_CODE_PROJECT =1;
    /**
     * 项目报名
     */
    public static final byte SORT_CODE_PROJECT_ENROLL = 2;

    /**
     * 招标项目保证金
     */
    public static final byte SORT_CODE_PROJECT_MARGIN = 3;
    /**
     * 招标项目供应商投标书
     */
    public static final byte SORT_CODE_PROJECT_SUPPLIER_BID_DOC = 4;
    /**
     * 通过公司名称和文件名称生成文件路径(不包含盘符路径,需要自定义),该文件目录仅为分离目录
     *
     * @param projectName
     * @param fileName
     * @param sortCode 用于将目录分类
     * @return
     */
    private static String getUploadFileDir(String projectName,Byte sortCode, String fileName) {
        String itemName;
        switch (sortCode){
            case 0:itemName="供应商"; break;
            case 1:itemName="招标项目"; break;
            case 2:itemName="招标项目报名"; break;
            case 3:itemName="招标项目保证金"; break;
            case 4:itemName="招标项目供应商投标书"; break;
            default: itemName="其他";break;
        }
        int code = (projectName + fileName).hashCode();
        int dir1 = code & 0xf;
        int code2 = fileName.hashCode();
        int dir2 = code2 & 0xf;
        return new StringBuffer("/").append(itemName).append("/").append(projectName).append("/").append(dir1).append("/").append(dir2).append("/").toString();
    }

    /**
     * 根据参数自动返回目标文件,但该文件为空
     *
     * @param baseDir
     * @param projectName
     * @param FileName
     * @param sortCode 目录分类码
     * @return
     * @throws IOException
     */
    public static File getUploadDirFile(String baseDir, String projectName,Byte sortCode, String FileName) throws IOException {
        String uploadFileDir = getUploadFileDir(projectName,sortCode ,FileName);
        String urlDir = baseDir + uploadFileDir;
        File urlDirFile = new File(urlDir);
        if (!urlDirFile.exists()) {
            urlDirFile.mkdirs();
        }
       File nullFile = new File(urlDir+FileName);
        return nullFile;
    }

    /**用于删除存在的文件,如果传入为空,则无操作
     * @param filePath 文件的全路径
     */
    public static void deleteExistFile(String filePath){
        if(filePath!=null&&!filePath.equals("")){
            new File(filePath).delete();
        }
    }
}
