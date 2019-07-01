package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.yuzo.question.entity.Answer;



public interface AnswerMapper {
    int deleteByPrimaryKey(String ansId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(String ansId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
    
    @Select("select ANS_ID, QSTN_ID, ANS_CONTENT, ANS_ISRIGHT  from  answer  where   QSTN_ID  = #{qstnId}")
    @ResultMap("BaseResultMap")
	List<Answer> queryByQstnId(String qstnId);
}