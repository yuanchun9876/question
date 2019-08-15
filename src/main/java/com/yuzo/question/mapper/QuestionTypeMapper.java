package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.yuzo.question.entity.QuestionType;



public interface QuestionTypeMapper {
    int deleteByPrimaryKey(String qstnTypeId);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    QuestionType selectByPrimaryKey(String qstnTypeId);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);

    @Select("  select \r\n" + 
    		"   QSTN_TYPE_ID, QSTN_TYPE_NAME, QSTN_TYPE_INFO, QSTN_TYPE_COUNT \r\n" + 
    		"    from question_type")
    @ResultMap("BaseResultMap")
	List<QuestionType> queryAll();
}