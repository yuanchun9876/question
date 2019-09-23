package com.yuzo.question.mapper;

import com.yuzo.question.entity.StudyCourseSection;

public interface StudyCourseSectionMapper {
    int deleteByPrimaryKey(String crseSctnId);

    int insert(StudyCourseSection record);

    int insertSelective(StudyCourseSection record);

    StudyCourseSection selectByPrimaryKey(String crseSctnId);

    int updateByPrimaryKeySelective(StudyCourseSection record);

    int updateByPrimaryKey(StudyCourseSection record);
}