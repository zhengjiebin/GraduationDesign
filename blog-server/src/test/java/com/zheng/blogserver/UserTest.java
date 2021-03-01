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
        int result = userMapper.updateAvatar(1, "~/Users/Desktop");
        if (result == 0) System.out.println("修改失败");
        System.out.println("修改成功");
    }


    @Test
    public void queryUserBasicInfo(){
        User user = userMapper.queryUserBasicInfo(1);
        System.out.println(user);
    }



    @Test
    public void updateUserBasicInfo(){
        String email="zhengjiebin_king@icloud.com";
        String birthday= "1998/05/23";
        Integer age = 22;
        String telephone = "17859942189";
        String nickName = "郑先森";
        String description = "Follow your dream";
        userMapper.updateUserBasicInfo(email,birthday,age,telephone,nickName,description,1);
        queryUserBasicInfo();
    }

}
