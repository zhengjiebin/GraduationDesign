package com.zheng.blogserver.service.impl;

import com.zheng.blogserver.beans.User;
import com.zheng.blogserver.mapper.UserMapper;
import com.zheng.blogserver.service.IUserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int updatePassword(Integer id, String password) {
        return userMapper.updatePassword(id,password);
    }

    @Override
    public int updateAvatar(Integer id, String address) {
        return 0;
    }

    @Override
    public User queryUserBasicInfo(Integer id) {
        return null;
    }

    @Override
    public int updateUserBasicInfo(String email, String birthday, Integer age, String telephone, String nickName, String description, Integer id) {
        return 0;
    }
}
