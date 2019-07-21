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

public interface ITestPlanService {

	List<TestPlan> queryAll();

	List<QstnFromType> queryQstnFrom();

	List<QuestionType> queryQstnType();

	List<SubjSection> querySubjSctn();
	
	List<SubjectCourse> querySubj();

	List<SubjUnit> querySubjUnit();

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

	int saveAnswer(SysUser user, String tpId, String[] qstns0, String[] ans0, String[] qstns4, String[] ans4);
}
