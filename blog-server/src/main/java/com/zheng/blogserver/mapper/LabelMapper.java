package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Label;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LabelMapper {

    /*
    * 查询所有标签
    * */
    @Select("select * from zj_labels")
    public List<Label> queryAllLabel();

    /*
    * 按id查询标签
    * */
    @Select("select * from zj_labels where label_id=#{id}")
    public Label queryLabelById(Integer id);

    /*
    * 添加一个标签
    * */
    @Options(useGeneratedKeys = true,keyProperty = "labelId",keyColumn = "label_id")
    @Insert("insert into zj_labels(label_name,label_alias,label_description) values(#{labelName},#{labelAlias},#{labelDescription})")
    public int addLabel(Label label);

    /*
    * 按id删除标签
    * */
    @Delete("delete from zj_labels where label_id=#{id}")
    public int deleteLabelById(Integer id);

    /*
    * 修改标签
    * */
    @Update("update zj_labels set label_id=#{labelId},label_name=#{labelName},label_alias=#{labelAlias},label_description=#{labelDescription}")
    public int updateLabel(Label label);


}
