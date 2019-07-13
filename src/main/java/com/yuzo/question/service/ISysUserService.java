package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.UserTeam;
import com.yuzo.question.page.SysUserPage;

public interface ISysUserService {

	int dels(String[] ids);

	int update(SysUser tm);

	SysUser queryById(String tmId);

	int save(SysUser tm);

	List<SysUser> queryAll();

	List<UserTeam> querytm();

	List<SysUser> queryPage(SysUserPage page);



}
