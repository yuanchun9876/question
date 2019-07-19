package com.yuzo.question.mapper;

import com.yuzo.question.entity.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(String urId);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(String urId);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}