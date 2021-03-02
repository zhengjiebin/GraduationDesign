package com.zheng.blogserver.utils;

public class IDUtil {
    /*
    * 随机生成六位数随机数
    * */
    public static Integer getId() {
        return (int) ((Math.random()*9+1)*100000);
    }

}
