package com.zheng.blogserver.controller;

import com.zheng.blogserver.beans.CommonResult;
import com.zheng.blogserver.beans.ResultCode;
import com.zheng.blogserver.beans.ResultUtil;
import com.zheng.blogserver.beans.Sort;
import com.zheng.blogserver.service.impl.SortServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "分类管理")
public class SortController {

    @Autowired
    SortServiceImpl sortService;

    @GetMapping("/sort")
    @ApiOperation("查询所有分类")
    public CommonResult<List<Sort>> queryAllSort(){
        return ResultUtil.success(sortService.queryAllSort(), ResultCode.SUCCESS);
    }

    @GetMapping("/sort/{id}")
    @ApiOperation("按id查询分类")
    public CommonResult<Sort> querySortById(@PathVariable("id") Integer id){
        Sort sort = sortService.querySortById(id);
        if (sort==null) return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        return ResultUtil.success(sort,ResultCode.SUCCESS);
    }

    @GetMapping("/sort/child")
    @ApiOperation("查询子分类")
    public CommonResult<List<Sort>> queryChildSort(@Param("id") Integer id){
        List<Sort> sorts = sortService.queryChildSort(id);
        if (sorts.isEmpty()) return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        return ResultUtil.success(sorts,ResultCode.SUCCESS);
    }

    @PutMapping("/admin/sort")
    @ApiOperation("添加新分类")
    @ApiImplicitParams({@ApiImplicitParam(name = "sortId",value = "分类id",defaultValue = "1"),
            @ApiImplicitParam(name = "parentSortId",value = "父分类id",defaultValue = "1")})
    public CommonResult<Integer> addSort(Sort sort){
        int row = sortService.addSort(sort);
        if (row==0) return ResultUtil.faile(ResultCode.DATA_ALREADY_EXISTED);
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @DeleteMapping("/admin/sort/{id}")
    @ApiOperation("按id删除分类")
    public CommonResult<Integer> deleteSortById(@PathVariable("id") Integer id){
        int row = sortService.deleteSortById(id);
        if (row==0) return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @DeleteMapping("/admin/sort/batch")
    @ApiOperation("批量删除分类")
    public CommonResult<Integer> batchDeleteSort(Integer[] ids){
        int i = sortService.batchDeleteSort(ids);
        if (i==1) ResultUtil.faile(ResultCode.SYSTEM_INNER_ERROR);
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @PatchMapping("/admin/sort")
    @ApiOperation("修改分类")
    @ApiImplicitParams({@ApiImplicitParam(name = "sortId",value = "分类id",defaultValue = "1"),
            @ApiImplicitParam(name = "parentSortId",value = "父分类id",defaultValue = "1")})
    public CommonResult<Sort> updateSort(Sort sort){
        try {
            int row = sortService.updateSort(sort);
        }catch (Exception e){
            return ResultUtil.faile(ResultCode.DATA_IS_WRONG);
        }
        return ResultUtil.success(sort,ResultCode.SUCCESS);
    }

}
