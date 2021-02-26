package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true,keyProperty = "user_id")
    @Select("select * from zj_users")
    public List<User> queryUser();

    public User queryForId(Integer id);
}
