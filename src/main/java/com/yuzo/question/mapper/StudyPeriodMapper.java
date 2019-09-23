package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.StudyPeriod;

public interface StudyPeriodMapper {
    int deleteByPrimaryKey(String pdId);

    int insert(StudyPeriod record);

    int insertSelective(StudyPeriod record);

    StudyPeriod selectByPrimaryKey(String pdId);

    int updateByPrimaryKeySelective(StudyPeriod record);

    int updateByPrimaryKey(StudyPeriod record);

	List<StudyPeriod> query();
}