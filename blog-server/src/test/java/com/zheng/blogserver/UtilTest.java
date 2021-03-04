package com.zheng.blogserver;

import com.zheng.blogserver.utils.IDUtil;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class UtilTest {

    @Test
    public void uuidTest(){
        Integer randomNickname = IDUtil.getId();
        System.out.println(randomNickname);

    }

    @Test
    public void test(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        long date = new Date().getTime();// 获取当前时间

        System.out.println(date); // 输出已经格式化的现在时间（24小时制）
    }

}
