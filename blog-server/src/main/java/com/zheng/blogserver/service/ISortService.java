package com.zheng.blogserver.service;

import com.zheng.blogserver.beans.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISortService {
    /*
     * 查询所有分类
     * */
    public List<Sort> queryAllSort();

    /*
     * 按id查询分类
     * */
    public Sort querySortById(Integer id);

    /*
    * 查询子分类
    * */
    public List<Sort> queryChildSort(Integer id);

    /*
     * 增加一个分类
     * */
    public int addSort(Sort sort);

    /*
     * 删除一个分类
     * */
    public int deleteSortById(Integer id);

    /*
     * 更新一个分类
     * */
    public int updateSort(Sort sort);

    /*
    * 批量删除分类
    * */
    public int batchDeleteSort(Integer ids[]);

}
