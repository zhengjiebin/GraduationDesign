package com.zheng.blogserver.service;

import com.zheng.blogserver.beans.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILabelService {

    /*
    * 查询所有标签
    * */
    public List<Label> queryAllLabel();

    /*
    * 按id查询标签
    * */
    public Label queryLabelById(Integer id);

    /*
    * 增加一个新标签
    * */
    public int addLabel(Label label);

    /*
    * 按id删除一个标签
    * */
    public int deleteLabelById(Integer id);

    /*
    * 修改标签信息
    * */
    public int updateLabel(Label label);

    /*
    * 批量删除标签
    * */
    public int batchDeleteLabel(Integer[] ids);

}
