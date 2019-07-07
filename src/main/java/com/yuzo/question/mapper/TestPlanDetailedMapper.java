package com.yuzo.question.mapper;

import com.yuzo.question.entity.TestPlanDetailed;

public interface TestPlanDetailedMapper {
    int deleteByPrimaryKey(String tpDtdId);

    int insert(TestPlanDetailed record);

    int insertSelective(TestPlanDetailed record);

    TestPlanDetailed selectByPrimaryKey(String tpDtdId);

    int updateByPrimaryKeySelective(TestPlanDetailed record);

    int updateByPrimaryKey(TestPlanDetailed record);
}