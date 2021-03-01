package com.zheng.blogserver.service.impl;

import com.zheng.blogserver.beans.Sort;
import com.zheng.blogserver.mapper.SortMapper;
import com.zheng.blogserver.service.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements ISortService {

    @Autowired
    SortMapper sortMapper;

    /*
    * 查询所有分类
    * */
    @Override
    public List<Sort> queryAllSort() {
        return sortMapper.queryAllSort();
    }

    /*
    * 按id查询分类
    * */
    @Override
    public Sort querySortById(Integer id) {
        return sortMapper.querySortById(id);
    }

    /*
    * 查询子分类
    * */
    @Override
    public List<Sort> queryChildSort(Integer id) {
        return sortMapper.queryChildSort(id);
    }

    /*
    * 新增一个新分类
    * */
    @Override
    public int addSort(Sort sort) {
        String sortName = sort.getSortName();
        Sort sort1 = sortMapper.querySortByName(sortName);
        if (sort1==null) return sortMapper.addSort(sort);
        return 0;
    }

    /*
    * 按id删除一个分类
    * */
    @Override
    public int deleteSortById(Integer id) {
        return sortMapper.deleteSortById(id);
    }

    /*
    * 更新一个分类
    * */
    @Override
    public int updateSort(Sort sort) {
        return sortMapper.updateSort(sort);
    }

    /*
    * 批量删除分类:
    * 0:成功
    * 1：失败
    * */
    @Override
    public int batchDeleteSort(Integer[] ids) {
        int flag = 0;
        int row = 1;
        for (int i = 0;i<ids.length;i++){
            if(row==0){
                return flag = 1;
            }
            row = deleteSortById(ids[i]);
        }
        return flag;
    }
}
