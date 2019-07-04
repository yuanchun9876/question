package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;

public interface IAnswerService {

	List<Answer> queryByQstnId(String id);

	Question queryQstnById(String id);

	int save(Answer ans);

	Answer queryById(String id);

	int update(Answer ans);

	int dels(String[] ids);

}
