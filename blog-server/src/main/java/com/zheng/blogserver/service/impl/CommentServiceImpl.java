package com.zheng.blogserver.service.impl;

import com.zheng.blogserver.beans.Article;
import com.zheng.blogserver.beans.Comment;
import com.zheng.blogserver.mapper.ArticleMapper;
import com.zheng.blogserver.mapper.CommentMapper;
import com.zheng.blogserver.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /*
    * 对文章进行评论,查询当前文章有多少评论再+1
    * */
    @Override
    public int commentToArticle(Comment comment) {

        return commentMapper.commentToArticle(comment);
    }

    /*
    * 查询当前文章的评论数
    * */
    @Override
    public int queryArticleCommentCount(Integer currentArticle) {
        return commentMapper.queryArticleCommentCount(currentArticle);
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
