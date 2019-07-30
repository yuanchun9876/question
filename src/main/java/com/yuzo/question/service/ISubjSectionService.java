package com.yuzo.question.service;

import java.util.List;
import java.util.Map;

import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.page.SubjSectionPage;



public interface ISubjSectionService {

	List<SubjSection> queryByTchId(String tchId);

	List<SubjUnit> queryUnit();

	List<SubjUnit> queryUnitByTchId(String tchId);

	int save(SubjSection sctn);

	SubjSection queryById(String subjSctnId);

	int dels(String[] ids);

	List<SubjSection> querySctnByUnit(String unitId);

	int update(SubjSection sctn);

	List<SubjectCourse> querySubj();

	SubjUnit queryUnitById(String subjUnitId);

	List<SubjSection> query(SubjSectionPage page);

	List<SubjSection> querySctnsByUnits(String[] unitIds);

	List<Map<String, Object>> queryTree();

}
