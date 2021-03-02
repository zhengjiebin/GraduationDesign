package com.zheng.blogserver;

import com.zheng.blogserver.beans.Article;
import com.zheng.blogserver.beans.ArticleInfo;
import com.zheng.blogserver.mapper.ArticleMapper;
import io.swagger.annotations.ApiModelProperty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void addArticle(){
        Article article = new Article(4,1,"hello world","hello world!",0,0,new Date("2021/03/01"),0);
        int i = articleMapper.addArticle(article);
        if (i==0) {
            System.out.println("发表失败");
        }else {
            System.out.println("发表成功");
        }
    }

    @Test
    public void deleteArticleById(){
        int i = articleMapper.deleteArticleById(4);
        if (i==0) {
            System.out.println("删除失败");
        }else {
            System.out.println("删除成功");
        }
    }

    @Test
    public void updateArticle(){
        String title = "你好，世界";
        String content = "你好，世界";
        Integer id = 3;
        int i = articleMapper.updateArticle(title, content, id);
        if (i==0) {
            System.out.println("修改失败");
        }else {
            System.out.println("修改成功");
        }
    }

    @Test
    public void queryArticleAll(){
        List<Article> articles = articleMapper.queryArticleAll();
        for (Article article : articles) {
            System.out.println(article);

            Date articleDate = article.getArticleDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(format.format(articleDate.getTime()));
        }
    }

    @Test
    public void queryArticleInfo(){
        ArticleInfo articleInfo = articleMapper.queryArticleInfo(3);
        System.out.println(articleInfo);
    }

    @Test
    public void allArticleCount(){
        System.out.println(articleMapper.allArticleCount());
    }

    @Test
    public void updateCommentCount(){
        if (articleMapper.updateCommentCount(100,3)==1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void updateArticleLikeCount(){
        if (articleMapper.updateArticleLikeCount(100,3)==1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void updateArticleViews(){
        if (articleMapper.updateArticleViews(100,3)==1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }
}
