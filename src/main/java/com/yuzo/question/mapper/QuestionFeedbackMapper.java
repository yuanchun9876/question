package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.QuestionFeedback;

public interface QuestionFeedbackMapper {
    int deleteByPrimaryKey(String qtfbId);

    int insert(QuestionFeedback record);

    int insertSelective(QuestionFeedback record);

    QuestionFeedback selectByPrimaryKey(String qtfbId);

    int updateByPrimaryKeySelective(QuestionFeedback record);

    int updateByPrimaryKey(QuestionFeedback record);

	List<QuestionFeedback> queryAll();
}