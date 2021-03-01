package com.zheng.blogserver.controller;

import com.zheng.blogserver.beans.CommonResult;
import com.zheng.blogserver.beans.Label;
import com.zheng.blogserver.beans.ResultCode;
import com.zheng.blogserver.beans.ResultUtil;
import com.zheng.blogserver.service.impl.LabelServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "标签管理")
public class LabelController {

    @Autowired
    LabelServiceImpl labelService;

    @GetMapping("/label")
    @ApiOperation("列出所有标签")
    public CommonResult<List<Label>> queryAllLabel(){
        List<Label> labels = labelService.queryAllLabel();
        return ResultUtil.success(labels, ResultCode.SUCCESS);
    }

    @GetMapping("/label/{id}")
    @ApiOperation("按id查询标签")
    public CommonResult<Label> queryLabelById(@PathVariable("id") Integer id){
        Label label = labelService.queryLabelById(id);
        if(label==null) return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        return ResultUtil.success(label,ResultCode.SUCCESS);
    }



    @PutMapping ("/admin/label")
    @ApiOperation("添加新标签")
    @ApiImplicitParam(name = "labelId",value = "标签id",defaultValue = "1")
    public CommonResult<Integer> addLabel(Label label){
        int row = labelService.addLabel(label);
        if (row == 0){
            return ResultUtil.faile(ResultCode.DATA_ALREADY_EXISTED);
        }
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @DeleteMapping("/admin/label/{id}")
    @ApiOperation("删除标签")
    public CommonResult<Integer> deleteLabel(@PathVariable("id") Integer id){
        int row = labelService.deleteLabelById(id);
        if (row==0){
            return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        }else {
            return ResultUtil.successNoData(ResultCode.SUCCESS);
        }
    }

    @DeleteMapping("/admin/label/batch")
    @ApiOperation("批量删除")
    public CommonResult<Integer> patchDaleteLabel(Integer[] ids){
        int i = labelService.batchDeleteLabel(ids);
        if (i==1) ResultUtil.faile(ResultCode.SYSTEM_INNER_ERROR);
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @PatchMapping("/admin/label")
    @ApiOperation("修改标签")
    @ApiImplicitParam(name = "labelId",value = "标签id",defaultValue = "1")
    public CommonResult<Label> updateLabel(Label label){
        try {
            int row = labelService.updateLabel(label);
        }catch (Exception e){
            return ResultUtil.faile(ResultCode.DATA_IS_WRONG);
        }
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }
}
