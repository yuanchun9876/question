package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.StudyCourseQuestion;

public interface StudyCourseQuestionMapper {
    int deleteByPrimaryKey(String crseQstnId);

    int insert(StudyCourseQuestion record);

    int insertSelective(StudyCourseQuestion record);

    StudyCourseQuestion selectByPrimaryKey(String crseQstnId);

    int updateByPrimaryKeySelective(StudyCourseQuestion record);

    int updateByPrimaryKey(StudyCourseQuestion record);

	int delsByCrseId(String crseId);

	List<StudyCourseQuestion> queryScqByCrseId(String crseId);

	Integer totalUnitCount(@Param("crseId")String crseId, @Param("subjUnitId")String subjUnitId);

	Integer totalSctnCount(@Param("crseId")String crseId, @Param("subjSctnId")String subjSctnId);
}