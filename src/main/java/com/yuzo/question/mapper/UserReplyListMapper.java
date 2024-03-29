package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.UserReplyList;

public interface UserReplyListMapper {
    int deleteByPrimaryKey(String urId);

    int insert(UserReplyList record);

    int insertSelective(UserReplyList record);

    UserReplyList selectByPrimaryKey(String urId);

    int updateByPrimaryKeySelective(UserReplyList record);

    int updateByPrimaryKey(UserReplyList record);

	List<UserReplyList> queryByUser(String userId);
}