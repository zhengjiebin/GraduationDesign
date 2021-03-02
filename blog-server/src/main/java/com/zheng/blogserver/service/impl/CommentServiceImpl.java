package com.zheng.blogserver.service.impl;

import com.zheng.blogserver.beans.Comment;
import com.zheng.blogserver.mapper.CommentMapper;
import com.zheng.blogserver.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    /*
    * 对文章进行评论
    * */
    @Override
    public int commentToArticle(Comment comment) {

        return commentMapper.commentToArticle(comment);
    }

    @Override
    public int queryArticleCommentCount(Integer currentArticle) {
        return 0;
    }

    @Override
    public int queryChileCommentCount(Integer id) {
        return 0;
    }

    @Override
    public int updateCommentLikeCount(Integer id, Integer count) {
        return 0;
    }

    @Override
    public Comment queryCommentById(Integer id) {
        return null;
    }

    @Override
    public List<Comment> queryAllParentComment(Integer currentArticle) {
        return null;
    }

    @Override
    public int deleteComment(Integer id) {
        return 0;
    }

    @Override
    public List<Comment> queryAllChildComment(Integer id) {
        return null;
    }
}
