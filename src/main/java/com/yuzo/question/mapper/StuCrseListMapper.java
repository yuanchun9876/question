package com.yuzo.question.mapper;

import com.yuzo.question.entity.StuCrseList;

public interface StuCrseListMapper {
    int deleteByPrimaryKey(String sclId);

    int insert(StuCrseList record);

    int insertSelective(StuCrseList record);

    StuCrseList selectByPrimaryKey(String sclId);

    int updateByPrimaryKeySelective(StuCrseList record);

    int updateByPrimaryKey(StuCrseList record);
}