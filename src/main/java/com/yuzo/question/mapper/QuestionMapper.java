package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.yuzo.question.entity.Question;



public interface QuestionMapper {
    int deleteByPrimaryKey(String qstnId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String qstnId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    @Select("select QSTN_ID, QSTN_TITLE, QSTN_INPUT_TIME, QSTN_PICTEXT\r\n" + 
    		",qttype.QSTN_TYPE_NAME QSTN_TYPE_ID, qtfrom.QSTN_FROM_TYPE_CODE QSTN_FROM_TYPE_ID,  sctn.SUBJ_SCTN_TITLE SUBJ_SCTN_ID \r\n" + 
    		"FROM question qstn  \r\n" + 
    		"	left JOIN question_type qttype  on qttype.QSTN_TYPE_ID = qstn.QSTN_TYPE_ID\r\n" + 
    		"	LEFT JOIN qstn_from_type  qtfrom on qtfrom.QSTN_FROM_TYPE_ID = qstn.QSTN_FROM_TYPE_ID\r\n" + 
    		"	LEFT JOIN subj_section sctn on sctn.SUBJ_SCTN_ID = qstn.SUBJ_SCTN_ID ")
    @ResultMap("BaseResultMap")
	List<Question> queryAll();
}