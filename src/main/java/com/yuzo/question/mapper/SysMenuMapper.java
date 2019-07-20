package com.yuzo.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuzo.question.entity.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

	List<SysMenu> queryAll();

	List<SysMenu> queryPar();

	List<SysMenu> queryChd(String menuId);

	List<SysMenu> selectByPids(String[] pmenuIds);

	List<SysMenu> queryParMenu(String userId);

	List<SysMenu> queryChdMenu(@Param("userId")String userId, @Param("menuId")String menuId);
}