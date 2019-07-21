package com.yuzo.question.mapper;

import com.yuzo.question.entity.TestPaper;

public interface TestPaperMapper {
    int deleteByPrimaryKey(String tpPpId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(String tpPpId);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
}