package com.zheng.blogserver.service;

import com.zheng.blogserver.beans.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {

    /*
     * 对文章进行评论
     * 回复一条评论
     * */
    public int commentToArticle(Comment comment);

    /*
     * 文章总评论数
     * */
    public int queryArticleCommentCount(Integer currentArticle);

    /*
     * 一条父评论的子评论数
     * */
    public int queryChileCommentCount(Integer id);

    /*
     * 更新Like数
     * */
    public int updateCommentLikeCount(Integer id,Integer count);

    /*
     * 查询一条评论
     * */
    public Comment queryCommentById(Integer id);

    /*
     * 查询一篇博文下所有父评论
     * */
    public List<Comment> queryAllParentComment(Integer currentArticle);

    /*
     * 删除一条评论
     * */
    public int deleteComment(Integer id);

    /*
     * 查询父评论下所有子评论
     * */
    public List<Comment> queryAllChildComment(Integer id);
}
