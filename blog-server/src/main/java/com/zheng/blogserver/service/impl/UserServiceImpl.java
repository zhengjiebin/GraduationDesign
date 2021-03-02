package com.zheng.blogserver.service.impl;

import com.zheng.blogserver.beans.User;
import com.zheng.blogserver.mapper.UserMapper;
import com.zheng.blogserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /*
    * 修改密码
    * */
    @Override
    public int updatePassword(Integer id, String password) {
        return userMapper.updatePassword(id,password);
    }

    /*
    * 修改头像
    * */
    @Override
    public int updateAvatar(String address) {
        return userMapper.updateAvatar(address);
    }

    /*
    * 查询用户信息
    * */
    @Override
    public User queryUserBasicInfo() {
        return userMapper.queryUserBasicInfo();
    }

    /*
    * 按名称查询密码
    * */
    @Override
    public String queryUserPasswordByName(String username) {
        return userMapper.queryUserPasswordByName(username);
    }
}
