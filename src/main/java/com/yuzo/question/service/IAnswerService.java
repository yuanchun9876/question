package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.Answer;

public interface IAnswerService {

	List<Answer> queryByQstnId(String id);

}
