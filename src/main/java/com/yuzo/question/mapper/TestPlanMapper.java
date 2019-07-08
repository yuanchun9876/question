package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.TestPlan;

public interface TestPlanMapper {
    int deleteByPrimaryKey(String tpId);

    int insert(TestPlan record);

    int insertSelective(TestPlan record);

    TestPlan selectByPrimaryKey(String tpId);

    int updateByPrimaryKeySelective(TestPlan record);

    int updateByPrimaryKey(TestPlan record);

	List<TestPlan> queryAll();
}