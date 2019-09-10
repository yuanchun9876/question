package com.yuzo.question.mapper;

import com.yuzo.question.entity.TestplanClassteam;

public interface TestplanClassteamMapper {
    int deleteByPrimaryKey(String tpctId);

    int insert(TestplanClassteam record);

    int insertSelective(TestplanClassteam record);

    TestplanClassteam selectByPrimaryKey(String tpctId);

    int updateByPrimaryKeySelective(TestplanClassteam record);

    int updateByPrimaryKey(TestplanClassteam record);
}