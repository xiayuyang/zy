package com.example.administrator.zy.Util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/26.
 */

public class datautil {
    static SimpleDateFormat format;
    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param dateL
     *            日期
     * @return
     */
    public static final String DF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String formatDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DF_YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }
    /**
     * 获取系统当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }
}
