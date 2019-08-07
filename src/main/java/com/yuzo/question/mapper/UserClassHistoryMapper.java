package com.yuzo.question.mapper;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.UserClassHistory;

public interface UserClassHistoryMapper {
    int deleteByPrimaryKey(String ucId);

    int insert(UserClassHistory record);

    int insertSelective(UserClassHistory record);

    UserClassHistory selectByPrimaryKey(String ucId);

    int updateByPrimaryKeySelective(UserClassHistory record);

    int updateByPrimaryKey(UserClassHistory record);

	int updateState(String userId);

	UserClassHistory queryByUserId(String userId);

	int updateBeforeClass(@Param("userId")String userId, @Param("mcId")String mcId);
}