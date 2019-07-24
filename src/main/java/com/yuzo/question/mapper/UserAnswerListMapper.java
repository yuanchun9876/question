package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.UserAnswerList;

public interface UserAnswerListMapper {
    int deleteByPrimaryKey(String uansId);

    int insert(UserAnswerList record);

    int insertSelective(UserAnswerList record);

    UserAnswerList selectByPrimaryKey(String uansId);

    int updateByPrimaryKeySelective(UserAnswerList record);

    int updateByPrimaryKey(UserAnswerList record);

	List<UserAnswerList> queryUalBy(@Param("utsId")String utsId,  @Param("type")String type);
}