package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.WorkList;
import com.yuzo.question.entity.WorkType;

public interface WorkListMapper {
    int deleteByPrimaryKey(String wlId);

    int insert(WorkList record);

    int insertSelective(WorkList record);

    WorkList selectByPrimaryKey(String wlId);

    int updateByPrimaryKeySelective(WorkList record);

    int updateByPrimaryKey(WorkList record);
    
    List<WorkList> queryAll();
}