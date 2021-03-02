package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    /*
    * 对文章进行评论
    * 回复一条评论
    * */
    @Insert("insert into zj_comments(comment_id,user_id,article_id,comment_like_count,comment_date,comment_content,parent_comment_id) " +
            "values(#{commentId},#{userId},#{articleId},#{commentLikeCount},#{commentDate},#{commentContent},#{parentCommentId})")
    public int commentToArticle(Comment comment);

    /*
    * 文章总评论数
    * */
    @Select("select count(*) from zj_comments where article_id=#{currentArticle}")
    public int queryArticleCommentCount(Integer currentArticle);

    /*
    * 一条父评论的子评论数
    * */
    @Select("select count(*) from zj_comments where parent_comment_id=#{id}")
    public int queryChileCommentCount(Integer id);

    /*
    * 更新Like数
    * */
    @Update("update zj_comments set comment_like_count=#{count} where comment_id=#{id}")
    public int updateCommentLikeCount(Integer id,Integer count);

    /*
    * 查询一条评论
    * */
    @Select("select * from zj_comments where comment_id=#{id}")
    public Comment queryCommentById(Integer id);

    /*
    * 查询一篇博文下所有父评论
    * */
    @Select("select * from zj_comments where parent_comment_id=0 and article_id=#{currentArticle}")
    public List<Comment> queryAllParentComment(Integer currentArticle);

    /*
    * 删除一条评论
    * */
    @Delete("delete from zj_comments where comment_id=#{id}")
    public int deleteComment(Integer id);

    /*
    * 查询父评论下所有子评论
    * */
    @Select("select * from zj_comments where parent_comment_id=#{id}")
    public List<Comment> queryAllChildComment(Integer id);

}
