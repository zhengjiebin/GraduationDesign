package com.zheng.blogserver.utils;

import ch.qos.logback.core.util.DatePatternToRegexUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtil {
    /*
    * 随机生成六位数随机数
    * */
    public static Integer getId() {
        return (int) ((Math.random()*9+1)*100000);
    }

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date(); // 获取当前时间
        return sdf.format(date); // 输出已经格式化的现在时间（24小时制）
    }
}
