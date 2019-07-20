package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserMyclass;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.page.SysUserPage;

public interface ISysUserService {

	int dels(String[] ids);

	int update(SysUser tm);

	SysUser queryById(String tmId);

	int save(SysUser tm, String mcId);

	List<SysUser> queryAll();

	List<UserTeam> querytm();
	
	List<UserMyclass> querymc();

	List<SysUser> queryPage(SysUserPage page);

	int updateUch(String userId, String mcId);

	List<SysUser> queryTmByUser(String userId);

	List<SysUser> queryByMcId(String mcId);

	List<SysRole> queryRoleList();

	int updateUserRole(String userId, String[] ids);





}
