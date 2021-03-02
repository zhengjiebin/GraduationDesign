package com.zheng.blogserver.service;

import com.zheng.blogserver.beans.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    /*
     * 修改密码
     * */
    public int updatePassword(Integer id,String password);

    /*
     * 修改头像
     * */
    public int updateAvatar(String address);

    /*
     * 获取用户基本信息
     * */
    public User queryUserBasicInfo();

    /*
     * 查询密码
     * */
    public String queryUserPasswordByName(String username);

}
