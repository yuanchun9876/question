package com.yuzo.question.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.entity.SysRoleMenu;
import com.yuzo.question.mapper.SysMenuMapper;
import com.yuzo.question.mapper.SysRoleMapper;
import com.yuzo.question.mapper.SysRoleMenuMapper;
import com.yuzo.question.service.ISysRoleService;



@Service
public class SysRoleServiceImpl implements ISysRoleService{

	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private SysMenuMapper menuMapper;
	
	@Autowired
	private SysRoleMenuMapper roleMenuMapper;
	
	

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

	@Override
	public List<SysMenu> queryPar() {
		// TODO Auto-generated method stub
		return menuMapper.queryPar();
	}

	@Override
	public int editMenu(String roleId, String[] pids, String[] cids) {
		// TODO Auto-generated method stub
		//roleMenuMapper
		// 删除
		
		roleMenuMapper.delsByRoleId(roleId);
		
		//
		int count = 0;
		for (int i = 0; i < cids.length; i++) {
			SysRoleMenu rm = new SysRoleMenu();
			rm.setRmId(UUID.randomUUID().toString());
			rm.setRoleId(roleId);
			rm.setMenuId(cids[i]);
			count += roleMenuMapper.insertSelective(rm);
		}
		
		for (int i = 0; i < pids.length; i++) {
			SysRoleMenu rm = new SysRoleMenu();
			rm.setRmId(UUID.randomUUID().toString());
			rm.setRoleId(roleId);
			rm.setMenuId(pids[i]);
			count += roleMenuMapper.insertSelective(rm);
		}
		return count;
	}
	

}
