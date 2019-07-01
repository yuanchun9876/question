package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.SubjUnit;



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
}