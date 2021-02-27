package com.zheng.blogserver.service.impl;

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

    @Override
    public List<Label> queryAllLabel() {
        return labelMapper.queryAllLabel();
    }

    @Override
    public Label queryLabelById(Integer id) {
        return labelMapper.queryLabelById(id);
    }

    @Override
    public int addLabel(Label label) {
        return labelMapper.addLabel(label);
    }

    @Override
    public int deleteLabelById(Integer id) {
        return labelMapper.deleteLabelById(id);
    }

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
        for (int i=0;i<ids.length;i++){
            deleteLabelById(ids[i]);
        }
        return flag;
    }
}
