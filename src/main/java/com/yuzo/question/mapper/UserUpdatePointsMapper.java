package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.UserUpdatePoints;

public interface UserUpdatePointsMapper {
    int deleteByPrimaryKey(String uupId);

    int insert(UserUpdatePoints record);

    int insertSelective(UserUpdatePoints record);

    UserUpdatePoints selectByPrimaryKey(String uupId);

    int updateByPrimaryKeySelective(UserUpdatePoints record);

    int updateByPrimaryKey(UserUpdatePoints record);

	List<UserUpdatePoints> queryByUser(String userId);
}