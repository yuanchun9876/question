package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.SysUser;

public interface IStuCrseService {

	List<StudyCourse> queryStudyCourse();

	StudyCourse queryCrseById(String crseId);

	List<Question> queryQstnFlag(String crseId, String type, String flag);

	List<Question> addAnswerByQstn(List<Question> qsListFlag0);

	void saveAnswer(SysUser user, String crseId, String[] qstns0, String[] ans0, String[] qstns2, String[] ans2);

}
