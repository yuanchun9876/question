package com.yuzo.question.service;

import java.util.List;
import java.util.Map;

import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.TestPlan;
import com.yuzo.question.entity.TestPlanDetailed;
import com.yuzo.question.entity.UserAnswerList;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTestList;

public interface ITestPlanService {

	List<TestPlan> queryAll();

	List<QstnFromType> queryQstnFrom2(String tpId);

	List<QuestionType> queryQstnType2(String tpId);

	List<SubjSection> querySubjSctn(String tpId);
	
	List<SubjectCourse> querySubj(String tpId);

	List<SubjUnit> querySubjUnit(String tpId);

	int save(TestPlan plan);

	TestPlan queryById(String tpId);

	int update(TestPlan plan);

	int dels(String[] ids);

	int saveSet(String tpId, String[] typeIds, Integer[] typeNums, Integer[] typePns, String[] fromIds,
			Integer[] fromNums, String[] subjIds, Integer[] subjNums, String[] unitIds, Integer[] unitNums,
			String[] sctnIds, Integer[] sctnNums);

	List<TestPlanDetailed> queryQstnType(String tpId);

	List<TestPlanDetailed> queryQstnFrom(String tpId);

	List<TestPlanDetailed> querySctn(String tpId);

	List<Question> queryQuesByParams(String qstnTypeId, String qstnFromTypeId, String subjSctnId);

	int saveAnswer(SysUser user, String tpId, String[] qstns0, String[] ans0, String[] qstns2,String[] ans2, String[] qstns4, String[] ans4);

	List<UserMyclass> queryMc();

	List<TestPlan> queryByUserClass(SysUser user, String type);

	List<UserTestList> queryByUserAndTp(String userId, String tpId);

	List<UserAnswerList> queryUalBy(String utsId, String type);

	List<Question> addAnswerByQstn(List<Question> subList);

	List<UserAnswerList> addAnswerByQstnForUal0(List<UserAnswerList> ualList0);

	List<UserAnswerList> addAnswerByQstnForUal2(List<UserAnswerList> ualList2);

	Map<String, Object> queryAnswer(String mcId, String tpId);

	int setScore(String tpId, String[] userIds, String[] points);

	UserTestList queryUtlById(String utsId);

	Map<String, Object> classplanlist(String mcId);

	List<Map<String, Object>> clasTestlist(String mcId);

	
}
