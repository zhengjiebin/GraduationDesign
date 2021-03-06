package com.zheng.blogserver;

import com.zheng.blogserver.beans.Sort;
import com.zheng.blogserver.mapper.SortMapper;
import com.zheng.blogserver.utils.IDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SortTest {

    @Autowired
    SortMapper sortMapper;

    @Test
    public void queryAllSort(){
        List<Sort> sorts = sortMapper.queryAllSort();
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    @Test
    public void querySortById(){
        Sort sort = sortMapper.querySortById(3);
        System.out.println(sort);
    }

    @Test
    public void addSort(){
        Sort sort = new Sort(IDUtil.getId(),"生活","Life","life",1);
        int i = sortMapper.addSort(sort);
        queryAllSort();
    }

    @Test
    public void deleteSortById(){
        sortMapper.deleteSortById(3);
        queryAllSort();
    }

    @Test
    public void updateSort(){
        Sort sort = new Sort(IDUtil.getId(),"摄影","摄影","生活",0);
        sortMapper.updateSort(sort);
        queryAllSort();
    }

    @Test
    public void querySortByName(){
        Sort sort = sortMapper.querySortByName("摄影");
        System.out.println(sort);
    }

    @Test
    public void queryChildSort(){
        List<Sort> sorts = sortMapper.queryChildSort(1);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }
}
