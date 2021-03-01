package com.zheng.blogserver.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("用户ip")
    private String userIp;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String userPassword;
    @ApiModelProperty("用户邮箱")
    private String userEmail;
    @ApiModelProperty("用户头像")
    private String userProfilePhoto;
    @ApiModelProperty("注册时间")
    private String userRegistrationTime;
    @ApiModelProperty("用户生日")
    private Date userBirthday;
    @ApiModelProperty("用户年龄")
    private Integer userAge;
    @ApiModelProperty("用户手机号码")
    private String userTelephoneNumber;
    @ApiModelProperty("用户昵称")
    private String userNickname;
    @ApiModelProperty("用户简介")
    private String userDescription;

    public User(String userEmail, Date userBirthday, Integer userAge, String userTelephoneNumber, String userNickname, String userDescription) {
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
        this.userAge = userAge;
        this.userTelephoneNumber = userTelephoneNumber;
        this.userNickname = userNickname;
        this.userDescription = userDescription;
    }
}
