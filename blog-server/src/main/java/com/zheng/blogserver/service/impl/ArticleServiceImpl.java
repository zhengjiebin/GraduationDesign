package com.zheng.blogserver.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zheng.blogserver.beans.Article;
import com.zheng.blogserver.beans.ArticleInfo;
import com.zheng.blogserver.mapper.ArticleMapper;
import com.zheng.blogserver.mapper.CommentMapper;
import com.zheng.blogserver.service.IArticleService;
import com.zheng.blogserver.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CommentMapper commentMapper;

    /*
     * 添加博文
     * 0：成功
     * 1：失败
     * */
    @Override
    public int addTitleAndContent(ArticleInfo articleInfo) {
        String articleTitle = articleInfo.getArticleTitle();
        String articleContent = articleInfo.getArticleContent();
        Integer articleId = IDUtil.getId();

        // 判断标题正文是否为空
        if (StringUtils.isEmpty(articleContent) || StringUtils.isEmpty(articleTitle)) {
            return 1;
        }

        // 如果id没有重复就执行插入语句
        if (articleMapper.queryArticleInfo(articleId) == null) {
            // 调用真正的博文发布方法
            Article article = new Article(articleId, 17859942189L, articleTitle, articleContent, 0, 0, new Date(), 0);
            if (articleMapper.addArticle(article) == 0) {
                return 1;
            }
            return 0;
        }

        return 1;
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    /*
    * 删除博文
    * */
    @Override
    public int deleteArticleById(Integer id) {
        return articleMapper.deleteArticleById(id);
    }

    /*
    * 更新博文
    * */
    @Override
    public int updateArticle(String title, String content, Integer id) {
        return articleMapper.updateArticle(title,content,id);
    }

    /*
    * 列出所有博文
    * */
    @Override
    public List<Article> queryArticleAll() {
        return articleMapper.queryArticleAll();
    }

    /*
    * 按id查询博文
    * */
    @Override
    public ArticleInfo queryArticleInfo(Integer id) {
        return articleMapper.queryArticleInfo(id);
    }

    /*
    * 查询文章总数
    * */
    @Override
    public Integer allArticleCount() {
        return articleMapper.allArticleCount();
    }

    /*
    * 更新评论数
    * */
    @Override
    public int updateCommentCount(Integer count, Integer id) {
        int num = commentMapper.queryArticleCommentCount(id);
        return articleMapper.updateCommentCount(num, id);
    }

    /*
    * 从redis中取出点赞数量更新
    * */
    @Override
    public int updateArticleLikeCount(Integer count, Integer id) {
        return 0;
    }

    /*
    * 从redis中取出访问量
    * */
    @Override
    public int updateArticleViews(Integer count, Integer id) {
        return 0;
    }
}
