package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LabelMapper {

    @Options(useGeneratedKeys = true,keyProperty = "label_id")
    @Select("select * from zj_labels")
    public List<Label> queryAllLabel();

    public Label queryLabelById(Integer id);
}
