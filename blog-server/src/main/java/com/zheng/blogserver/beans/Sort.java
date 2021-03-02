package com.zheng.blogserver.beans;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分类实体类")
public class Sort {
    @ApiModelProperty("分类id")
    private Integer sortId;
    @ApiModelProperty("分类名称")
    private String sortName;
    @ApiModelProperty("分类别名")
    private String sortAlias;
    @ApiModelProperty("分类描述")
    private String sortDescription;
    @ApiModelProperty("父分类id")
    private Integer parentSortId;

    public Sort(String randomNickname, String 摄影, String 摄影1, String 生活, int parentSortId) {
    }
}
