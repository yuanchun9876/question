package com.yuzo.question.mapper;

import com.yuzo.question.entity.StudyCourseQuestion;

public interface StudyCourseQuestionMapper {
    int deleteByPrimaryKey(String crseQstnId);

    int insert(StudyCourseQuestion record);

    int insertSelective(StudyCourseQuestion record);

    StudyCourseQuestion selectByPrimaryKey(String crseQstnId);

    int updateByPrimaryKeySelective(StudyCourseQuestion record);

    int updateByPrimaryKey(StudyCourseQuestion record);
}