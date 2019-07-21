package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.page.SubjUnitPage;



public interface ISubjUnitService {

	List<SubjUnit> queryByTchId(String tchId);

	int save(SubjUnit unit);

	SubjUnit queryById(String subjSctnId);

	List<SubjectCourse> querySubjectCourse();

	List<SubjUnit> queryAll();

	int dels(String[] ids);

	List<SubjUnit> queryUnitBySubj(String subjId);

	int update(SubjUnit unit);

	List<SubjUnit> queryUnitsBySubjs(String[] subjIds);

	List<SubjUnit> queryPage(SubjUnitPage page);

}
