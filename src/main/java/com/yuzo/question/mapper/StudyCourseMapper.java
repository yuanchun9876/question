package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.StudyCourse;

public interface StudyCourseMapper {
    int deleteByPrimaryKey(String crseId);

    int insert(StudyCourse record);

    int insertSelective(StudyCourse record);

    StudyCourse selectByPrimaryKey(String crseId);

    int updateByPrimaryKeySelective(StudyCourse record);

    int updateByPrimaryKey(StudyCourse record);

	List<StudyCourse> query();

	List<StudyCourse> queryNextByNum(String crseNum);

	List<StudyCourse> queryPrevByNum(@Param("crseNum")String crseNum, @Param("start")String start);
}