package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.UserUpdatePoints;
import com.yuzo.question.entity.UserUpdatePointsType;

public interface UserUpdatePointsTypeMapper {
    int deleteByPrimaryKey(String uuptId);

    int insert(UserUpdatePointsType record);

    int insertSelective(UserUpdatePointsType record);

    UserUpdatePointsType selectByPrimaryKey(String uuptId);

    int updateByPrimaryKeySelective(UserUpdatePointsType record);

    int updateByPrimaryKey(UserUpdatePointsType record);

	List<UserUpdatePointsType> queryAll();
}