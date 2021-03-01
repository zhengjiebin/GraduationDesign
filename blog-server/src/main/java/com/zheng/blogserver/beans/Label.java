package com.zheng.blogserver.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("标签实体类")
public class Label {
    @ApiModelProperty(value = "标签ID",example = "1")
    private Integer labelId;
    @ApiModelProperty("标签名称")
    private String labelName;
    @ApiModelProperty("标签别名")
    private String labelAlias;
    @ApiModelProperty("标签描述")
    private String labelDescription;
}
