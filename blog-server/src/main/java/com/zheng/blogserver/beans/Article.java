package com.zheng.blogserver.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer articleId;
    private String articleTitle;
    private String articleContent;
    private Integer articleViews;
    private Integer articleCommentCount;
    private Date articleDate;
    private Integer articleLikeCount;
    private Integer userId;
}
