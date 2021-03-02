package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    /*
    * 修改密码
    * */
    @Update("update zj_users set user_password=#{password} where user_id=#{id}")
    public int updatePassword(Integer id,String password);

    /*
    * 修改头像
    * */
    @Update("update zj_users set user_profile_photo=#{address} where user_id=17859942189")
    public int updateAvatar(String address);

    /*
    * 获取用户基本信息
    * */
    @Select("select * from zj_users where user_id=17859942189")
    public User queryUserBasicInfo();

    /*
    * 按用户名查密码
    * */
    @Select("select user_password from zj_users where user_name=#{username}")
    public String queryUserPasswordByName(String username);

}
