package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.yuzo.question.entity.SubjSection;
import com.yuzo.question.page.SubjSectionPage;



public interface SubjSectionMapper {
    int deleteByPrimaryKey(String subjSctnId);

    int insert(SubjSection record);

    int insertSelective(SubjSection record);

    SubjSection selectByPrimaryKey(String subjSctnId);

    int updateByPrimaryKeySelective(SubjSection record);

    int updateByPrimaryKey(SubjSection record);

	List<SubjSection> queryByUnit(String subjUnitId);

	List<SubjSection> queryAllByTchId(String tchId);

	List<SubjSection> queryAll(SubjSectionPage page);

	List<SubjSection> querySctnsByUnits(String[] unitIds);
}