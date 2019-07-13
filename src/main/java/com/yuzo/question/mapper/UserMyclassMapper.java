package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.UserMyclass;

public interface UserMyclassMapper {
    int deleteByPrimaryKey(String mcId);

    int insert(UserMyclass record);

    int insertSelective(UserMyclass record);

    UserMyclass selectByPrimaryKey(String mcId);

    int updateByPrimaryKeySelective(UserMyclass record);

    int updateByPrimaryKey(UserMyclass record);

	List<UserMyclass> queryAll();
}