package com.zheng.blogserver;

import com.zheng.blogserver.beans.User;
import com.zheng.blogserver.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void updatePassword(){
        int result = userMapper.updatePassword(1, "Zjb19980623");
        if (!(result == 0))
            System.out.println("修改失败");
        System.out.println("修改成功");
    }

    @Test
    public void updateAvatar(){
        int result = userMapper.updateAvatar("~/Users/Desktop");
        if (result == 0) System.out.println("修改失败");
        System.out.println("修改成功");
    }


    @Test
    public void queryUserBasicInfo(){
        User user = userMapper.queryUserBasicInfo();
        System.out.println(user);
    }


    @Test
    public void queryUserPassword(){
        System.out.println(userMapper.queryUserPasswordByName("root"));
    }

}
