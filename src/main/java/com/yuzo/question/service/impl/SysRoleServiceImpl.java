package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SubjectCourse;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.mapper.SubjectCourseMapper;
import com.yuzo.question.mapper.SysRoleMapper;
import com.yuzo.question.service.ISubjectCourseService;
import com.yuzo.question.service.ISysRoleService;



@Service
public class SysRoleServiceImpl implements ISysRoleService{

	@Autowired
	private SysRoleMapper roleMapper;

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			roleMapper.deleteByPrimaryKey(ids[i]);
		}
		return count;
	}

	@Override
	public int update(SysRole role) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public SysRole queryById(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int save(SysRole role) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(role);
	}

	@Override
	public List<SysRole> queryAll() {
		// TODO Auto-generated method stub
		return roleMapper.queryAll();
	}
	

}
