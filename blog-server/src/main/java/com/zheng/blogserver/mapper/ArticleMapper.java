package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Article;
import com.zheng.blogserver.beans.ArticleInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper{

    /*
    * 博文发表
    * */
    @Insert("insert into zj_articles(article_id,user_id,article_title,article_content,article_views,article_comment_count,article_date,article_like_count) " +
            "values(#{articleId},#{userId},#{articleTitle},#{articleContent},#{articleViews},#{articleCommentCount},#{articleDate},#{articleLikeCount})")
    public int addArticle(Article article);

    /*
    * 删除博文
    * */
    @Delete("delete from zj_articles where article_id=#{id}")
    public int deleteArticleById(Integer id);

    /*
    * 修改博文
    * */
    @Update("update zj_articles set article_title=#{title},article_content=#{content} where article_id=#{id}")
    public int updateArticle(String title,String content,Integer id);

    /*
    * 查询所有博文信息
    * */
    @Select("select * from zj_articles")
    public List<Article> queryArticleAll();

    /*
    * 按id查询博文信息
    * */
    @Select("select article_title,article_content from zj_articles where article_id=#{id}")
    public ArticleInfo queryArticleInfo(Integer id);

    /*
    * 总博文数
    * */
    @Select("select count(*) from zj_articles")
    public Integer allArticleCount();

    /*
    * 修改评论总数
    * */
    @Update("update zj_articles set article_comment_count=#{count} where article_id=#{id}")
    public int updateCommentCount(Integer count,Integer id);

    /*
    * 修改喜欢总数
    * */
    @Update("update zj_articles set article_like_count=#{count} where article_id=#{id}")
    public int updateArticleLikeCount(Integer count,Integer id);

    /*
    * 修改访问量
    * */
    @Update("update zj_articles set article_views=#{count} where article_id=#{id}")
    public int updateArticleViews(Integer count,Integer id);
}
