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
@ApiModel("博文实体类")
public class Article {
    @ApiModelProperty("博文id")
    private Integer articleId;
    @ApiModelProperty("发表用户id")
    private Long userId;
    @ApiModelProperty("博文标题")
    private String articleTitle;
    @ApiModelProperty("博文内容")
    private String articleContent;
    @ApiModelProperty("浏览量")
    private Integer articleViews;
    @ApiModelProperty("评论总数")
    private Integer articleCommentCount;
    @ApiModelProperty("发表时间")
    private Date articleDate;
    @ApiModelProperty("喜欢总数")
    private Integer articleLikeCount;

}
