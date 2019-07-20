package com.yuzo.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuzo.question.entity.SysMenu;
import com.yuzo.question.entity.SysRole;
import com.yuzo.question.mapper.SysMenuMapper;
import com.yuzo.question.mapper.SysRoleMapper;

import com.yuzo.question.service.ISysMenuService;




@Service
public class SysMenuServiceImpl implements ISysMenuService{

	@Autowired
	private SysMenuMapper menuMapper;

	@Override
	public int dels(String[] ids) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < ids.length; i++) {
			count += menuMapper.deleteByPrimaryKey(ids[i]);
		}
		
		return count;
	}

	@Override
	public int update(SysMenu menu) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public SysMenu queryById(String menuId) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public int save(SysMenu menu) {
		// TODO Auto-generated method stub
		return menuMapper.insertSelective(menu);
	}

	@Override
	public List<SysMenu> queryAll() {
		// TODO Auto-generated method stub
		return menuMapper.queryAll();
	}

	@Override
	public List<SysMenu> queryPar() {
		// TODO Auto-generated method stub
		return menuMapper.queryPar();
	}

	@Override
	public List<SysMenu> queryChd(String menuId) {
		// TODO Auto-generated method stub
		return menuMapper.queryChd(menuId);
	}

	@Override
	public List<SysMenu> selectByPids(String[] pmenuIds) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPids(pmenuIds);
	}

	
}
