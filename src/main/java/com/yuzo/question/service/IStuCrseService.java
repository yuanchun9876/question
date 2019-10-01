package com.yuzo.question.service;

import java.util.List;
import java.util.Map;

import com.yuzo.question.entity.Answer;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StuCrseList;
import com.yuzo.question.entity.StuCrseTest;
import com.yuzo.question.entity.StuLevel;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.SysUser;

public interface IStuCrseService {

	List<StudyCourse> queryStudyCourse();

	StudyCourse queryCrseById(String crseId);

	List<Question> queryQstnFlag(String crseId, String type, String flag);

	List<Question> addAnswerByQstn(List<Question> qsListFlag0);

	void saveAnswer(SysUser user, Integer sctlen, String crseId, String[] qstns0, String[] ans0, String[] qstns2, String[] ans2);

	List<StuCrseTest> queryStuCrseTest(String crseId, String userId);

	List<StuCrseList> queryStuCrseListByType(String sctId, String type);

	List<StuCrseList> addAnswerByQstnForScl0(List<StuCrseList> sclList0);

	List<StuCrseList> addAnswerByQstnForScl2(List<StuCrseList> sclList2);

	StuCrseTest queryById(String sctId);

	List<StuCrseTest> querySctByCrseId(String crseId, String userId);

	List<StuCrseList> querySclByCrseAndUser(String crseId, String userId);

	List<Map<String, Object>> querySclCountByCrseAndUser(String crseId, String userId);

	Integer totalSctnYes(String crseId, String userId, String string);

	List<Map<String, Object>> queryMcSclList(String crseId, String mcId);

	Question queryQstnById(String qstnId);

	List<Answer> queryByQstnId(String qstnId);

	List<StuCrseList> totalUal(String crseId, String mcId, String qstnId);

	Map<String, Object> querySclsByCrseAndMc(String crseId, String mcId);

	Map<String, Object> querySctnsByCrseAndMc(String crseId, String mcId);

	StuLevel querySlById(String userId);

}
