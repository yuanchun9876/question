package com.yuzo.question.mapper;

import com.yuzo.question.entity.UserTestList;

public interface UserTestListMapper {
    int deleteByPrimaryKey(String utsId);

    int insert(UserTestList record);

    int insertSelective(UserTestList record);

    UserTestList selectByPrimaryKey(String utsId);

    int updateByPrimaryKeySelective(UserTestList record);

    int updateByPrimaryKey(UserTestList record);
}