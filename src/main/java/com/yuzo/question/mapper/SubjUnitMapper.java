package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.SubjUnit;
import com.yuzo.question.page.SubjUnitPage;



public interface SubjUnitMapper {
    int deleteByPrimaryKey(String subjUnitId);

    int insert(SubjUnit record);

    int insertSelective(SubjUnit record);

    SubjUnit selectByPrimaryKey(String subjUnitId);

    int updateByPrimaryKeySelective(SubjUnit record);

    int updateByPrimaryKey(SubjUnit record);

	List<SubjUnit> queryAll();

	List<SubjUnit> queryBySubj(String subjId);

	List<SubjUnit> queryByTchId(String tchId);

	List<SubjUnit> queryUnitsBySubjs(String[] subjIds);

	List<SubjUnit> queryPage(SubjUnitPage page);

	List<SubjUnit> queryByCode(@Param("unitCode")String unitCode, @Param("subjId")String subjId);

	SubjUnit queryUnitBySctnId(String subjSctnId);
}