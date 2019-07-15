package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.UserMyclass;

public interface IUserReplyService {

	List<TestPlan> querytp();

	List<UserMyclass> querymc();

	List<Question> queryQstnByTp(String tpId);

	UserMyclass queryMcById(String mcId);

	void updatePoints(String qstnId, String replyType, String userId);

}
