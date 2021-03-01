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
    public int updateAvatar(Integer id,String address);

    /*
     * 获取用户基本信息
     * */
    public User queryUserBasicInfo(Integer id);

    /*
     * 修改用户基本信息
     * */
    public int updateUserBasicInfo(String email, String birthday, Integer age, String telephone, String nickName, String description, Integer id);


}
