package com.zheng.blogserver.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String userPassword;
    @ApiModelProperty("用户头像")
    private String userProfilePhoto;
    @ApiModelProperty("用户手机号码")
    private String userTelephoneNumber;
    @ApiModelProperty("用户昵称")
    private String userNickname;
}
