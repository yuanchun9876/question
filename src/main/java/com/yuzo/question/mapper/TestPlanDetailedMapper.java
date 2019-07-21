package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.TestPlanDetailed;

public interface TestPlanDetailedMapper {
    int deleteByPrimaryKey(String tpDtdId);

    int insert(TestPlanDetailed record);

    int insertSelective(TestPlanDetailed record);

    TestPlanDetailed selectByPrimaryKey(String tpDtdId);

    int updateByPrimaryKeySelective(TestPlanDetailed record);

    int updateByPrimaryKey(TestPlanDetailed record);

	void delsByPlan(String string);

	List<TestPlanDetailed> queryWhere(@Param("tpId")String tpId, @Param("type")String type);
}