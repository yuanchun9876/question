package com.yuzo.question.mapper;

import com.yuzo.question.entity.TestPater;

public interface TestPaterMapper {
    int deleteByPrimaryKey(String tpPtId);

    int insert(TestPater record);

    int insertSelective(TestPater record);

    TestPater selectByPrimaryKey(String tpPtId);

    int updateByPrimaryKeySelective(TestPater record);

    int updateByPrimaryKey(TestPater record);
}