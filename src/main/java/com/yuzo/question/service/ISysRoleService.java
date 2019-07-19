package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysRole;



public interface ISysRoleService {

	int dels(String[] ids);

	int update(SysRole role);

	SysRole queryById(String roleId);

	int save(SysRole role);

	List<SysRole> queryAll();



}
