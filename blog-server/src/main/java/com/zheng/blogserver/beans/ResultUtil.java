package com.zheng.blogserver.beans;

public class ResultUtil {
    //成功，不返回具体数据
    public static <T> CommonResult<T> successNoData(ResultCode code){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMsg());
        return result;
    }
    //成功，返回数据
    public static <T> CommonResult<T> success(T t,ResultCode code){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMsg());
        result.setData(t);
        return result;
    }

    //失败，返回失败信息
    public static <T> CommonResult<T> faile(ResultCode code){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMsg());
        return result;
    }

    //失败，返回失败信息
    public static <T> CommonResult<T> faileAndData(T t,ResultCode code){
        CommonResult<T> result = new CommonResult<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMsg());
        result.setData(t);
        return result;
    }
}
