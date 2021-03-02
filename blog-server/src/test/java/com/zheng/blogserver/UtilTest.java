package com.zheng.blogserver;

import com.zheng.blogserver.utils.IDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTest {

    @Test
    public void uuidTest(){
        Integer randomNickname = IDUtil.getId();
        System.out.println(randomNickname);
    }

}
