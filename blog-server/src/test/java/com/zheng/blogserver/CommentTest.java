package com.zheng.blogserver;

import com.zheng.blogserver.beans.Comment;
import com.zheng.blogserver.mapper.CommentMapper;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentTest {

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void commentToArticle(){
        Comment comment = new Comment(6,1,1,0,DateUtil.now(),"继续回复",4);
        int row = commentMapper.commentToArticle(comment);
        if (row == 0) System.out.println("评论失败");
    }

    @Test
    public void queryArticleCommentCount(){
        int count = commentMapper.queryArticleCommentCount(1);
        System.out.println(count);
    }

    @Test
    public void updateCommentLikeCount(){
        int row = commentMapper.updateCommentLikeCount(5, 23);
        if (row == 0) {
            System.out.println("更新失败");
        }else {
            System.out.println("更新成功");
        }
    }

    @Test
    public void deleteComment(){
        int row = commentMapper.deleteComment(3);
        if (row == 0) {
            System.out.println("删除失败");
        }else {
            System.out.println("删除成功");
        }
    }

    @Test
    public void queryChildComment(){
        List<Comment> comments = commentMapper.queryAllChildComment(4);
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

    @Test
    public void queryChileCommentCount(){
        int i = commentMapper.queryChileCommentCount(1);
        System.out.println(i);
    }

    @Test
    public void queryAllParentComment(){
        List<Comment> comments = commentMapper.queryAllParentComment(1);
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

    @Test
    public void queryCommentById(){
        System.out.println(commentMapper.queryCommentById(1));
    }
}
