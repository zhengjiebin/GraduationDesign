package com.zheng.blogserver.service;

import com.zheng.blogserver.beans.Article;
import com.zheng.blogserver.beans.ArticleInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticleService {
    /*
     * 博文发表
     * */
    public int addArticle(Article article);

    public int addTitleAndContent(ArticleInfo articleInfo);

    /*
     * 删除博文
     * */
    public int deleteArticleById(Integer id);

    /*
     * 修改博文
     * */
    public int updateArticle(String title,String content,Integer id);

    /*
     * 查询所有博文信息
     * */
    public List<Article> queryArticleAll();

    /*
     * 按id查询博文信息
     * */
    public ArticleInfo queryArticleInfo(Integer id);

    /*
     * 总博文数
     * */
    public Integer allArticleCount();

    /*
     * 修改评论总数
     * */
    public int updateCommentCount(Integer count,Integer id);

    /*
     * 修改喜欢总数
     * */
    public int updateArticleLikeCount(Integer count,Integer id);

    /*
     * 修改访问量
     * */
    public int updateArticleViews(Integer count,Integer id);


}
