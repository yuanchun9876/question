package com.yuzo.question.service;

import java.util.List;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysRole;



public interface ISysMenuService {

	int dels(String[] ids);

	int update(SysMenu menu);

	SysMenu queryById(String menuId);

	int save(SysMenu menu);

	List<SysMenu> queryAll();

	List<SysMenu> queryPar();

	List<SysMenu> queryChd(String menuId);

	List<SysMenu> selectByPids(String[] pmenuIds);



}
