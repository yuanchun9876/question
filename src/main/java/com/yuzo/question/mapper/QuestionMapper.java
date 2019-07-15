package com.yuzo.question.mapper;

import java.util.List;



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
}