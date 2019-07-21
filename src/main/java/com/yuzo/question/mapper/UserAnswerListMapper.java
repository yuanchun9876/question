package com.yuzo.question.mapper;

import com.yuzo.question.entity.UserAnswerList;

public interface UserAnswerListMapper {
    int deleteByPrimaryKey(String uansId);

    int insert(UserAnswerList record);

    int insertSelective(UserAnswerList record);

    UserAnswerList selectByPrimaryKey(String uansId);

    int updateByPrimaryKeySelective(UserAnswerList record);

    int updateByPrimaryKey(UserAnswerList record);
}