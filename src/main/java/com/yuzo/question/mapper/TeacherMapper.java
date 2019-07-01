package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.Teacher;



public interface TeacherMapper {
	
    int deleteByPrimaryKey(String tchId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tchId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

	List<Teacher> queryAll();
}