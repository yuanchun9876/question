package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.WorkType;

public interface WorkTypeMapper {
    int deleteByPrimaryKey(String wtId);

    int insert(WorkType record);

    int insertSelective(WorkType record);

  
    WorkType selectByPrimaryKey(String wtId);

    int updateByPrimaryKeySelective(WorkType record);

    int updateByPrimaryKey(WorkType record);
    
    List<WorkType> queryAll();
}