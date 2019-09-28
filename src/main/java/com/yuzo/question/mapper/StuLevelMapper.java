package com.yuzo.question.mapper;

import com.yuzo.question.entity.StuLevel;

public interface StuLevelMapper {
    int deleteByPrimaryKey(String userId);

    int insert(StuLevel record);

    int insertSelective(StuLevel record);

    StuLevel selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(StuLevel record);

    int updateByPrimaryKey(StuLevel record);
}