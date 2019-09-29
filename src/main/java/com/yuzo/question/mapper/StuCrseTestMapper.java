package com.yuzo.question.mapper;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.StuCrseTest;

public interface StuCrseTestMapper {
    int deleteByPrimaryKey(String sctId);

    int insert(StuCrseTest record);

    int insertSelective(StuCrseTest record);

    StuCrseTest selectByPrimaryKey(String sctId);

    int updateByPrimaryKeySelective(StuCrseTest record);

    int updateByPrimaryKey(StuCrseTest record);

	Integer querySctMaxNum(@Param("crseId")String crseId,@Param("userId")String userId);
}