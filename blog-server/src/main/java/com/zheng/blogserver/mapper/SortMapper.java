package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SortMapper {

    @Options(useGeneratedKeys = true,keyProperty = "sort_id")
    @Select("select * from zj_sorts")
    public List<Sort> queryAllSort();

    public Sort querySortById(Integer id);
}
