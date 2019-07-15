package com.yuzo.question.mapper;

import java.util.List;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.page.SysUserPage;

public interface SysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	List<SysUser> queryPage(SysUserPage page);

	List<SysUser> queryAll();

	List<SysUser> queryTmByUser(String userId);
}