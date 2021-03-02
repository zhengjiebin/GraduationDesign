package com.zheng.blogserver.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("博文基本信息")
public class ArticleInfo {
    @ApiModelProperty("博文标题")
    private String articleTitle;
    @ApiModelProperty("博文内容")
    private String articleContent;
}
