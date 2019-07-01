package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.ResourceData;



public interface ResourceDataMapper {
    int deleteByPrimaryKey(String rsrcId);

    int insert(ResourceData record);

    int insertSelective(ResourceData record);

    ResourceData selectByPrimaryKey(String rsrcId);

    int updateByPrimaryKeySelective(ResourceData record);

    int updateByPrimaryKey(ResourceData record);

	List<ResourceData> queryRsrcDataByUnit(String unitId);

	List<ResourceData> queryAll();
}