package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Options(useGeneratedKeys = true,keyProperty = "article_id")
    @Select("select * from zj_articles")
    public List<Article> queryAllArticle();

    public Article queryArticleForId(Integer id);
}
