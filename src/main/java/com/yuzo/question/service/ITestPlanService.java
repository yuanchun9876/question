package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.QstnFromType;
import com.yuzo.question.entity.QuestionType;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.TestPlan;

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
}
