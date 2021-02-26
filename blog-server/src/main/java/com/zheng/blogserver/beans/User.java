package com.zheng.blogserver.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userIp;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userProfilePhoto;
    private String userRegistrationTime;
    private Date userBirthday;
    private Integer userAge;
    private String userTelephoneNumber;
    private String userNickname;
}
