package com.zheng.blogserver.controller;

import com.zheng.blogserver.beans.CommonResult;
import com.zheng.blogserver.beans.ResultCode;
import com.zheng.blogserver.beans.ResultUtil;
import com.zheng.blogserver.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PatchMapping("/admin/user/password")
    @ApiOperation("修改密码")
    public CommonResult<Integer> updatePassword(Integer id,String password){
        int row = userService.updatePassword(id, password);
        if (row==0) return ResultUtil.faile(ResultCode.SYSTEM_INNER_ERROR);
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }
}
