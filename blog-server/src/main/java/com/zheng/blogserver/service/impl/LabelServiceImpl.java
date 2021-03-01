package com.zheng.blogserver.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zheng.blogserver.beans.Label;
import com.zheng.blogserver.mapper.LabelMapper;
import com.zheng.blogserver.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements ILabelService {

    @Autowired
    LabelMapper labelMapper;

    /*
    * 查询所有标签
    * */
    @Override
    public List<Label> queryAllLabel() {
        return labelMapper.queryAllLabel();
    }

    /*
    * 按id查询标签
    * */
    @Override
    public Label queryLabelById(Integer id) {
        return labelMapper.queryLabelById(id);
    }

    /*
    * 新增标签，
    * 如果数据库中已有，返回0
    * 如果数据库没有就添加，返回影响行数
    * */
    @Override
    public int addLabel(Label label) {
        String labelName = label.getLabelName();
        Label label1 = labelMapper.queryLabelByName(labelName);
        if (label1 ==null){
            return labelMapper.addLabel(label);
        }else {
            return 0;
        }
    }

    /*
    * 按id删除标签
    * */
    @Override
    public int deleteLabelById(Integer id) {
        return labelMapper.deleteLabelById(id);
    }

    /*
    * 更新标签
    * */
    @Override
    public int updateLabel(Label label) {
        return labelMapper.updateLabel(label);
    }

    /*
    * 批量删除 0：成功 1：失败
    * */
    @Override
    public int batchDeleteLabel(Integer[] ids) {
        int flag = 0;
        int row = 1;
        for (int i=0;i<ids.length;i++){
            if (row==0){
                return flag=1;
            }
            row = deleteLabelById(ids[i]);
        }
        return flag;
    }
}
