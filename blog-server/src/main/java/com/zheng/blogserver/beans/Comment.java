package com.zheng.blogserver.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer commentId;
    private Integer userId;
    private Integer articleId;
    private Integer commentLikeCount;
    private Date commentDate;
    private String CommentContent;
    private Integer parentCommentId;
}
