package com.suchuner.bidding.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suchuner
 */
public class CommonUtils {
    private CommonUtils() {
    }

    /**
     * 该方法用于将数字字符串,中间的数字用,[逗号隔开],转换为Long的数组
     * 例如: "1,2,3,4,5" -->Long[]{1,2,3,4,5}
     *
     * @param nums
     * @return
     */
    public static Long[] numStringsConvertToLongArr(String nums) {
        String[] strings = nums.split(",");
        Long[] temp = new Long[strings.length];
        for (int i = 0; i < strings.length; i++) {
            temp[i] = Long.valueOf(strings[i]);
        }
        return temp;
    }

    private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};

    /**
     * 该方法用于判断是否是微软系列的浏览器,用于解决下载文件时中文名乱码的问题
     *
     * @param request
     * @return
     */
    public static boolean isMSBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal))
                return true;
        }
        return false;
    }

    /**该方法用于解决文件下载中文件名称中含有中文时乱码的问题,返回一个处理好的名称[该名称兼容各种浏览器下载]
     * @param request
     * @param fileName
     * @return
     */
    public static String handleDownloadFileMojibakeByChineseFileName(HttpServletRequest request, String fileName) {
        try {
            if (isMSBrowser(request)) {//微软系列浏览器
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {//符合w3c规范的浏览器
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**该方法用于返回easyUI中的 grid的值
     * @param response
     * @param total 返回值的属性名为total
     * @param rows 返回值的属性名为rows
     * @throws IOException
     */
    public  static void returnMessages(HttpServletResponse response, Integer total, Object rows) throws IOException {
            Map<String,Object> temp = new HashMap<String,Object>();
            temp.put("total",total);
            temp.put("rows",rows);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(JsonUtils.objectToJson(temp));
    }

    /**
     * @param response
     * @param isSuccess 返回的属性值名称为flag
     * @param messageValue 返回的属性值名称为retMessage
     * @throws IOException
     */
    public  static void returnMessages(HttpServletResponse response, Boolean isSuccess, Object messageValue) throws IOException {
        Map<String,Object> temp = new HashMap<String,Object>();
        temp.put("flag",isSuccess);
        temp.put("retMessage",messageValue);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(JsonUtils.objectToJson(temp));
    }

    /**
     * @param response
     * @param callback 为jsonp回调函数的名称
     * @param isSuccess 需要返回的json数据 true或false
     * @param messageValue 需要返回的json数据
     * @throws IOException
     */
    public static void  returnJsonPMessages(HttpServletResponse response,String callback,Boolean isSuccess,Object messageValue) throws IOException {
        Map<String,Object> temp = new HashMap<String,Object>();
        temp.put("flag",isSuccess);
        temp.put("retMessage",messageValue);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(callback+"("+JsonUtils.objectToJson(temp)+")");
    }
}
