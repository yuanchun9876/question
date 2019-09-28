package com.yuzo.question.mapper;

import com.yuzo.question.entity.StuCrseTest;

public interface StuCrseTestMapper {
    int deleteByPrimaryKey(String sctId);

    int insert(StuCrseTest record);

    int insertSelective(StuCrseTest record);

    StuCrseTest selectByPrimaryKey(String sctId);

    int updateByPrimaryKeySelective(StuCrseTest record);

    int updateByPrimaryKey(StuCrseTest record);
}