package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Options(useGeneratedKeys = true,keyProperty = "comment_id")
    @Select("select * from zj_comments")
    public List<Comment> queryAllComment();

    public Comment queryCommentById(Integer id);
}
