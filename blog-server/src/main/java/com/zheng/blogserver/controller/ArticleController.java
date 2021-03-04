package com.zheng.blogserver.controller;

import com.zheng.blogserver.beans.*;
import com.zheng.blogserver.service.impl.ArticleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "博文管理")
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @PostMapping("/admin/article")
    @ApiOperation("发表博文")
    public CommonResult<Article> addArticle(ArticleInfo articleInfo){
        if (articleService.addTitleAndContent(articleInfo) == 1) {
            ResultUtil.faile(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @DeleteMapping("/admin/article")
    @ApiOperation("删除博文")
    public CommonResult<Integer> deleteArticle(Integer id){
        if(articleService.deleteArticleById(id) == 0){
            return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        }
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @PatchMapping("/admin/article/{id}")
    @ApiOperation("更新博文")
    public CommonResult<Integer> updateArticle(ArticleInfo articleInfo,@PathVariable Integer id){
        String articleTitle = articleInfo.getArticleTitle();
        String articleContent = articleInfo.getArticleContent();
        if (articleService.updateArticle(articleTitle,articleContent,id)==0){
            return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        }
        return ResultUtil.successNoData(ResultCode.SUCCESS);
    }

    @GetMapping("/article")
    @ApiOperation("所有博文")
    public CommonResult<List<Article>> queryArticleAll(){
        List<Article> articles = articleService.queryArticleAll();
        if (articles == null){
            return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        }
        return ResultUtil.success(articles,ResultCode.SUCCESS);
    }

    @GetMapping("/article/{id}")
    @ApiOperation("按id查询博文")
    public CommonResult<ArticleInfo> queryArticleById(@PathVariable Integer id){
        ArticleInfo articleInfo = articleService.queryArticleInfo(id);
        if (articleInfo == null){
            return ResultUtil.faile(ResultCode.RESULE_DATA_NONE);
        }
        return ResultUtil.success(articleInfo,ResultCode.SUCCESS);
    }

    @GetMapping("/article/count")
    @ApiOperation("查询博文数量")
    public CommonResult<Integer> queryArticleCount(){
        Integer count = articleService.allArticleCount();
        return ResultUtil.success(count,ResultCode.SUCCESS);
    }


}
