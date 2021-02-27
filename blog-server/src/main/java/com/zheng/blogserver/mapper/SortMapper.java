package com.zheng.blogserver.mapper;

import com.zheng.blogserver.beans.Sort;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SortMapper {

    /*
    * 查询所有分类
    * */
    @Select("select * from zj_sorts")
    public List<Sort> queryAllSort();

    /*
    * 按id查询分类
    * */
    @Select("select * from zj_sorts where sort_id=#{id}")
    public Sort querySortById(Integer id);

    /*
    * 增加一个分类
    * */
    @Insert("insert into zj_sorts(sort_name,sort_alias,sort_description,parent_sort_id) values(#{sortName},#{sortAlias},#{sortDescription},#{parentSortId})")
    public int addSort(Sort sort);

    /*
    * 删除一个分类
    * */
    @Delete("delete from zj_sorts where sort_id=#{sortID}")
    public int deleteSortById(Integer id);

    /*
    * 更新一个分类
    * */
    @Update("update zj_sorts set sort_name=#{sortName},sort_alias=#{sortAlias},sort_description=#{sortDescription},parent_sort_id=#{parentSortId} where sort_id=#{sortId}")
    public int updateSort(Sort sort);
}
