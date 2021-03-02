package com.zheng.blogserver.controller;

import com.alibaba.druid.util.StringUtils;
import com.zheng.blogserver.beans.CommonResult;
import com.zheng.blogserver.beans.ResultCode;
import com.zheng.blogserver.beans.ResultUtil;
import com.zheng.blogserver.beans.User;
import com.zheng.blogserver.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Value("${avatar.path}")
    private String filePath;


    @PatchMapping("/admin/user/password")
    @ApiOperation("修改密码")
    public CommonResult<Integer> updatePassword(Integer id,String password){
        int row = userService.updatePassword(id, password);
        if (row==0) return ResultUtil.faile(ResultCode.SYSTEM_INNER_ERROR);
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @PostMapping("/admin/upload")
    @ApiOperation("修改头像")
    public CommonResult<Object> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtil.faile(ResultCode.PARAM_IS_BLANK);
        }
        String fileName = file.getOriginalFilename();
        String fileFullName = filePath+fileName;
        File dest = new File(fileFullName);
        try {
            file.transferTo(dest);
            userService.updateAvatar(fileFullName);
            return ResultUtil.successNoData(ResultCode.SUCCESS);
        } catch (IOException e) {
            System.out.println(e);
        }
        return ResultUtil.faile(ResultCode.SYSTEM_INNER_ERROR);
    }

    @GetMapping("/user")
    @ApiOperation("查询用户信息")
    public CommonResult<User> queryUserBasicInfo(){
        User user = userService.queryUserBasicInfo();
        if (user==null){
            return ResultUtil.faile(ResultCode.USER_NOT_EXIST);
        }
        return ResultUtil.success(user,ResultCode.SUCCESS);
    }

    @GetMapping("/admin/password")
    @ApiOperation("按用户名查找密码")
    public CommonResult<Object> queryPassword(String username){
        String password = userService.queryUserPasswordByName(username);
        if (StringUtils.isEmpty(username)){
            return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        }
        return ResultUtil.success(password,ResultCode.SUCCESS);
    }
}
