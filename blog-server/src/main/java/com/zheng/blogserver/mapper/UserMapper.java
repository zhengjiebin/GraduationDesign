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
    @Update("update zj_users set user_profile_photo=#{address} where user_id=#{id}")
    public int updateAvatar(Integer id,String address);


    /*
    * 获取用户基本信息
    * */
    @Select("select * from zj_users where user_id=#{id}")
    public User queryUserBasicInfo(Integer id);

    /*
    * 修改用户基本信息
    * */
    @Update("update zj_users set user_email=#{email},user_birthday=#{birthday},user_age=#{age},user_telephone_number=#{telephone},user_nickname=#{nickName},user_description=#{description} where user_id=#{id}")
    public int updateUserBasicInfo(String email, String birthday, Integer age, String telephone, String nickName, String description, Integer id);



}
