package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.Question;
import com.yuzo.question.entity.StudyCourse;
import com.yuzo.question.entity.StudyCourseQuestion;
import com.yuzo.question.entity.StudyPeriod;
import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;

public interface IStudyCourseService {

	List<StudyCourse> queryAll();

	List<StudyPeriod> queryPeriod();

	int save(StudyCourse crse);

	StudyCourse queryById(String crseId);

	int update(StudyCourse crse);

	int dels(String[] ids);
	
	
	List<SubjSection> querySubjSctn();
	
	List<SubjectCourse> querySubj();

	List<SubjUnit> querySubjUnit();

	int setCrseSctn(String crseId, String[] sctnIds);

	int setCrseQstn(String crseId, String[] qstns);

	List<StudyCourseQuestion> queryScqByCrseId(String crseId);

	Question queryQstnById(String qstnId);

	List<Question> addAnswerByQstn(List<Question> qstnList0);

	SubjUnit queryUnitBySctnId(String subjSctnId);

	Integer totalUnitCount(String crseId, String subjUnitId);

	SubjUnit queryUnitById(String unitId);

	List<SubjSection> querySctnsByUnit(String unitId);

	Integer totalSctnCount(String crseId, String subjSctnId);

	int setCrseQstnFlag(String crseId, String[] qstns, String[] qstnFlags);

	List<StudyCourseQuestion> queryScqByCrseIdForSctn(String crseId);

	int addCrseQstn(String crseId, String qstnId);

	int delCrseQstn(String crseId, String qstnId);

}
