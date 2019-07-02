package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.entity.SubjUnit;



public interface ISubjSectionService {

	List<SubjSection> queryByTchId(String tchId);

	List<SubjUnit> queryUnit();

	List<SubjUnit> queryUnitByTchId(String tchId);

	int save(SubjSection sctn);

	SubjSection queryById(String subjSctnId);

	int dels(String[] ids);

	List<SubjSection> querySctnByUnit(String unitId);

	int update(SubjSection sctn);

}
