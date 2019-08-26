package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.TestPlan;

public interface TestPlanMapper {
    int deleteByPrimaryKey(String tpId);

    int insert(TestPlan record);

    int insertSelective(TestPlan record);

    TestPlan selectByPrimaryKey(String tpId);

    int updateByPrimaryKeySelective(TestPlan record);

    int updateByPrimaryKey(TestPlan record);

	List<TestPlan> queryAll();
	// TP_TARGET = #{mcId} and TP_TYPE = #{type}
	List<TestPlan> queryByUserClass(@Param("mcId")String mcId, @Param("type")String type);

	List<TestPlan> queryByUserClassNotType(String mcId);
}