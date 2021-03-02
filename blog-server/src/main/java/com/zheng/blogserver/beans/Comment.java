package com.zheng.blogserver.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("评论实体类")
public class Comment {
    @ApiModelProperty("评论id")
    private Integer commentId;
    @ApiModelProperty("发表用户id")
    private Integer userId;
    @ApiModelProperty("评论博文id")
    private Integer articleId;
    @ApiModelProperty("点赞数")
    private Integer commentLikeCount;
    @ApiModelProperty("评论日期")
    private Date commentDate;
    @ApiModelProperty("评论内容")
    private String CommentContent;
    @ApiModelProperty("父评论id")
    private Integer parentCommentId;
}
