package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.ResourceType;



public interface ResourceTypeMapper {
    int deleteByPrimaryKey(String rsrcTypeId);

    int insert(ResourceType record);

    int insertSelective(ResourceType record);

    ResourceType selectByPrimaryKey(String rsrcTypeId);

    int updateByPrimaryKeySelective(ResourceType record);

    int updateByPrimaryKey(ResourceType record);

	List<ResourceType> queryRsrcTypeByUnit(String unitId);

	List<ResourceType> queryAll();
}