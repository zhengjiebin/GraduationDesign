package com.zheng.blogserver.controller;

import com.zheng.blogserver.beans.CommonResult;
import com.zheng.blogserver.beans.Label;
import com.zheng.blogserver.beans.ResultCode;
import com.zheng.blogserver.beans.ResultUtil;
import com.zheng.blogserver.service.impl.LabelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/label")
public class LabelController {

    @Autowired
    LabelServiceImpl labelService;

    /*
    * 列出所有标签
    * */
    @GetMapping("/all")
    public CommonResult<List<Label>> queryAllLabel(){
        List<Label> labels = labelService.queryAllLabel();
        return ResultUtil.success(labels, ResultCode.SUCCESS);
    }
}
