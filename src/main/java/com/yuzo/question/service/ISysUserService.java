package com.yuzo.question.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.SysUser;
import com.yuzo.question.entity.SysUserRole;
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

	List<SysRole> queryRoleList(List<SysUserRole> urList);

	int updateUserRole(String userId, String[] ids);

	List<SysUser> queryByName(String userName);

	List<SysUserRole> queryUserRole(String userId);

	JSONObject checkCustomertTel(String tel, HttpSession session);

	JSONObject sendCode(String tel, HttpSession session);

	JSONObject checkSMSCode(String smsCode, HttpSession session);

	JSONObject registerUser(SysUser user, HttpSession session);

	int setName(String userId);





}
