package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.Question;
import com.yuzo.question.page.QuestionPage;



public interface QuestionMapper {
	
    int deleteByPrimaryKey(String qstnId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String qstnId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

	List<Question> queryAll(QuestionPage page);
	
	int queryCountByXxx(QuestionPage page);

	List<Question> queryQstnByTpId(String tpId);

	List<Question> queryQuesByParams(@Param("qstnTypeId")String qstnTypeId, @Param("qstnFromTypeId")String qstnFromTypeId, @Param("subjSctnId")String subjSctnId);

	List<Question> selectAll();

	List<Question> queryQstnByCrse(@Param("crseId")String crseId, @Param("type")String type, @Param("flag")String flag );


	List<Question> queryBySctnId(String subjSctnId);
}